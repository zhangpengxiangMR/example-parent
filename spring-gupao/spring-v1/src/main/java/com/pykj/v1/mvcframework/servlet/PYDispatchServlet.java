package com.pykj.v1.mvcframework.servlet;

import com.pykj.v1.mvcframework.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class PYDispatchServlet extends HttpServlet {

    /**
     * 保存application.properties配置文件中的内容
     */
    private Properties contextConfig = new Properties();

    /**
     * 保存扫描的所有的类名,享元模式，缓存
     */
    private List<String> classNames = new ArrayList<String>();

    /**
     * IoC容器，key默认是类名首字母小写，value对应的是实例化对象
     * 传说中的IOC容器，我们来揭开它的神秘面纱
     * 为了简化程序，暂时不考虑ConcurrentHashMap
     * 主要还是关注设计思想和原理
     */
    private Map<String, Object> ioc = new HashMap<String, Object>();

    /**
     * handlerMapping
     */
    private Map<String, Method> handlerMapping = new HashMap<String, Method>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //6、委派，根据URL去找到一个对应的Method并通过response返回
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Exception Detail:" + Arrays.toString(e.getStackTrace()));
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");
        if (!handlerMapping.containsKey(url)) {
            resp.getWriter().write("404 NOT Found");
            return;
        }
        Map<String, String[]> params = req.getParameterMap();
        Method method = this.handlerMapping.get(url);

        //获取形参列表
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] paramValues = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class paramterType = parameterTypes[i];
            if (paramterType == HttpServletRequest.class) {
                paramValues[i] = req;
            } else if (paramterType == HttpServletResponse.class) {
                paramValues[i] = resp;
            } else if (paramterType == String.class) {
                //通过运行时的状态去拿到你
                Annotation[][] pa = method.getParameterAnnotations();
                for (int j = 0; j < pa.length; j++) {
                    for (Annotation a : pa[i]) {
                        if (a instanceof PYRequestParam) {
                            String paramName = ((PYRequestParam) a).value();
                            if (!"".equals(paramName.trim())) {
                                String value = Arrays.toString(params.get(paramName))
                                        .replaceAll("\\[|\\]", "")
                                        .replaceAll("\\s+", ",");
                                paramValues[i] = value;
                            }
                        }
                    }
                }

            }
        }
        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());
        method.invoke(ioc.get(beanName), paramValues);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1、加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        //2、扫描相关的类
        doScanner(contextConfig.getProperty("scanPackage"));
        //=====================IoC====================================
        //3、初始化IoC容器，将扫描到的相关类的实例，保存带IoC容器中
        doInstance();
        //=====================AOP====================================
        //新生成的代理对象
        //=====================DI====================================
        //4、完成依赖注入
        doAutowired();
        //5、初始化HandlerMapping
        doInitHandlerMapping();
        System.out.println("Spring framework is init. ");
    }

    private void doInitHandlerMapping() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(PYController.class)) {
                continue;
            }
            String baseUrl = "";
            if (clazz.isAnnotationPresent(PYRequestMapping.class)) {
                PYRequestMapping pyRequestMapping = clazz.getAnnotation(PYRequestMapping.class);
                baseUrl = pyRequestMapping.value();
            }

            //只获取public的方法
            for (Method method : clazz.getMethods()) {
                if (!method.isAnnotationPresent(PYRequestMapping.class)) {
                    continue;
                }
                PYRequestMapping pyRequestMapping = method.getAnnotation(PYRequestMapping.class);
                String url = ("/" + baseUrl + "/" + pyRequestMapping.value()).replaceAll("/+", "/");
                handlerMapping.put(url, method);
                System.out.println("Mapped : " + url + "," + method);
            }
        }
    }

    private void doAutowired() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            //获取类的所有字段
            for (Field field : entry.getValue().getClass().getDeclaredFields()) {
                if (!field.isAnnotationPresent(PYAutowired.class)) {
                    continue;
                }
                PYAutowired pyAutowired = field.getAnnotation(PYAutowired.class);
                String beanName = pyAutowired.value().trim();
                if ("".equals(beanName)) {
                    beanName = field.getType().getName();
                }
                field.setAccessible(true);
                try {
                    field.set(entry.getValue(), ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doInstance() {
        if (classNames.isEmpty()) {
            return;
        }
        try {
            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(PYController.class)) {
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    Object instance = clazz.newInstance();
                    ioc.put(beanName, instance);
                } else if (clazz.isAnnotationPresent(PYService.class)) {
                    //1、在多个包下存在相同的类名称，只能自己取一个全局唯一的名称，自定义命名
                    String beanName = clazz.getAnnotation(PYService.class).value();
                    if ("".equals(beanName.trim())) {
                        beanName = toLowerFirstCase(clazz.getSimpleName());
                    }
                    //2、规范写法的类，默认类的首字母小写
                    Object instance = clazz.newInstance();
                    ioc.put(beanName, instance);
                    //3、如果是多个接口，判断有多少个实现类，如果只有一个，默认就选择这个实现类，如果有多个，只能抛异常
                    for (Class<?> o : clazz.getInterfaces()) {
                        if (ioc.containsKey(o.getName())) {
                            throw new Exception("The" + o.getName() + "is exists!");
                        }
                        ioc.put(o.getName(), instance);
                    }
                } else {
                    continue;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private void doScanner(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                String className = (scanPackage + "." + file.getName().replace(".class", ""));
                classNames.add(className);
            }
        }
    }

    private void doLoadConfig(String contextConfigLocation) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            contextConfig.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
