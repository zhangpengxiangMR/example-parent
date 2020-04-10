package com.pykj.v2.spring.framework.webmvc.servlet;

import com.pykj.v2.spring.framework.annotation.PYController;
import com.pykj.v2.spring.framework.annotation.PYRequestMapping;
import com.pykj.v2.spring.framework.annotation.PYRequestParam;
import com.pykj.v2.spring.framework.context.PYApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * DispatcherServlet用到委派模式
 * 职责：负责任务调度，请求分发
 *
 */
public class PyDispatcherServlet extends HttpServlet {

    private PYApplicationContext applicationContext;

    /**
     * handlerMapping
     */
    private Map<String,Method> handlerMapping = new HashMap<String, Method>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //6、委派，根据URL去找到一个对应的Method并通过response返回
        try {
            doDispatch(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Exception Detail:" + Arrays.toString(e.getStackTrace()));
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url =  url.replaceAll(contextPath,"").replaceAll("/+","/");
        if(!handlerMapping.containsKey(url)){
            resp.getWriter().write("404 NOT Found");
            return;
        }
        Map<String,String[]> params = req.getParameterMap();
        Method method = this.handlerMapping.get(url);

        //获取形参列表
        Class<?> [] parameterTypes = method.getParameterTypes();
        Object [] paramValues = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class paramterType = parameterTypes[i];
            if(paramterType == HttpServletRequest.class){
                paramValues[i] = req;
            }else if(paramterType == HttpServletResponse.class){
                paramValues[i] = resp;
            }else if(paramterType == String.class){
                //通过运行时的状态去拿到你
                Annotation[] [] pa = method.getParameterAnnotations();
                for (int j = 0; j < pa.length ; j ++) {
                    for(Annotation a : pa[i]){
                        if(a instanceof PYRequestParam){
                            String paramName = ((PYRequestParam) a).value();
                            if(!"".equals(paramName.trim())){
                                String value = Arrays.toString(params.get(paramName))
                                        .replaceAll("\\[|\\]","")
                                        .replaceAll("\\s+",",");
                                paramValues[i] = value;
                            }
                        }
                    }
                }

            }
        }
        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());
        method.invoke(applicationContext.getBean(beanName),paramValues);
    }

    private String toLowerFirstCase(String simpleName) {
        char [] chars = simpleName.toCharArray();
        chars[0] += 32 ;
        return String.valueOf(chars);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //初始化Spring核心IoC容器和DI注入
        applicationContext = new PYApplicationContext(config.getInitParameter("contextConfigLocation"));
        //5、初始化HandlerMapping
        doInitHandlerMapping();
        System.out.println("Spring framework is init. ");
    }
    private void doInitHandlerMapping() {
        if(this.applicationContext.getBeanDefiitionCount() == 0 ){
            return;
        }
        /*if(ioc.isEmpty()) {return;}*/
        for (String beanName : this.applicationContext.getBeanDefinitionNames()) {
            Class<?> clazz = this.applicationContext.getBean(beanName).getClass();
            if(!clazz.isAnnotationPresent(PYController.class)){continue;}
            String baseUrl = "";
            if(clazz.isAnnotationPresent(PYRequestMapping.class)) {
                PYRequestMapping pyRequestMapping = clazz.getAnnotation(PYRequestMapping.class);
                baseUrl = pyRequestMapping.value();
            }

            //只获取public的方法
            for (Method method : clazz.getMethods()) {
                if(!method.isAnnotationPresent(PYRequestMapping.class)){continue;}
                PYRequestMapping pyRequestMapping = method.getAnnotation(PYRequestMapping.class);
                String url = ("/" +baseUrl + "/"+ pyRequestMapping.value()).replaceAll("/+","/");
                handlerMapping.put(url,method);
                System.out.println("Mapped : " + url  + "," + method);
            }
        }
    }

}
