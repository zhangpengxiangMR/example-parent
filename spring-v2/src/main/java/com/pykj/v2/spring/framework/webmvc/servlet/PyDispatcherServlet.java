package com.pykj.v2.spring.framework.webmvc.servlet;

import com.pykj.v2.spring.framework.annotation.PYController;
import com.pykj.v2.spring.framework.annotation.PYRequestMapping;
import com.pykj.v2.spring.framework.context.PYApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DispatcherServlet用到委派模式
 * 职责：负责任务调度，请求分发
 */
public class PyDispatcherServlet extends HttpServlet {

    private PYApplicationContext applicationContext;

    private List<PYHandlerMapping> handlerMappings = new ArrayList<>();

    private Map<PYHandlerMapping, PYHandlerAdapter> handlerAdapters = new HashMap<>();

    private List<PYViewResolver> viewResolvers = new ArrayList<PYViewResolver>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //6、委派，根据URL去找到一个对应的Method并通过response返回
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                processDispatchResult(req,resp,new PYModelAndView("500"));
            } catch (Exception ex) {
                ex.printStackTrace();
                resp.getWriter().write("500 Exception Detail:" + Arrays.toString(e.getStackTrace()));
            }
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、通过URL获取HandlerMappping
        PYHandlerMapping handlerMapping = getHandler(req);
        if (handlerMapping == null) {
            processDispatchResult(req, resp, new PYModelAndView("404"));
            resp.getWriter().write("404 NOT Found");
            return;
        }
        //2、根据一个HandlerMapping获取一个HanslerAdapter适配器
        PYHandlerAdapter ha = getHandlerApadter(handlerMapping);

        //3、解析某一个方法的形参和返回值，统一封装为ModelAndView对象
        PYModelAndView mv = ha.handler(req, resp, handlerMapping);

        //把ModelAndView变成一个ViewResolver
        processDispatchResult(req, resp, mv);

    }

    private PYHandlerAdapter getHandlerApadter(PYHandlerMapping handlerMapping) {
        if(this.handlerAdapters.isEmpty()){return null;}
        return this.handlerAdapters.get(handlerMapping);
    }

    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, PYModelAndView mv) throws Exception {
        if(mv == null ){return;}
        if(this.viewResolvers.isEmpty()){return;}
        for (PYViewResolver viewResolver : this.viewResolvers) {
            PYView view = viewResolver.resolveViewName(mv.getViewName());
            //直接往浏览器输出
            view.render(mv.getModel(),req,resp);
            return;
        }

    }

    private PYHandlerMapping getHandler(HttpServletRequest req) {
        if (this.handlerMappings.isEmpty()) {
            return null;
        }
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");
        for (PYHandlerMapping handlerMapping : handlerMappings) {
            Matcher matcher = handlerMapping.getPattern().matcher(url);
            if (!matcher.matches()) {
                continue;
            }
            return handlerMapping;
        }
        return null;
    }

    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //初始化Spring核心IoC容器和DI注入
        applicationContext = new PYApplicationContext(config.getInitParameter("contextConfigLocation"));
        //初始化MVC九大组件
        initStrategies(applicationContext);
        System.out.println("Spring framework is init. ");
    }

    private void initStrategies(PYApplicationContext context) {
        //多文件上传的组件
        //initMultipartResolver(context);
        //初始化本地语言环境
        //initLocaleResolver(context);
        //初始化模板处理器
        //initThemeResolver(context);
        //handlerMapping
        initHandlerMappings(context);
        //初始化参数适配器
        initHandlerAdapters(context);
        //初始化异常拦截器
        //initHandlerExceptionResolvers(context);
        //初始化视图预处理器
        //initRequestToViewNameTranslator(context);
        //初始化视图转换器
        initViewResolvers(context);
        //FlashMap管理器
        //initFlashMapManager(context);

    }

    private void initViewResolvers(PYApplicationContext context) {
        //templateRoot=layouts
        String templateRoot = context.getConfig().getProperty("templateRoot");
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();

        File templateRootDir = new File(templateRootPath);
        for (File file : templateRootDir.listFiles()) {
            this.viewResolvers.add(new PYViewResolver(templateRoot));
        }
    }

    private void initHandlerAdapters(PYApplicationContext context) {
        for (PYHandlerMapping handlerMapping : handlerMappings) {
            this.handlerAdapters.put(handlerMapping,new PYHandlerAdapter());
        }
    }

    private void initHandlerMappings(PYApplicationContext context) {
        if (this.applicationContext.getBeanDefiitionCount() == 0) {
            return;
        }
        for (String beanName : this.applicationContext.getBeanDefinitionNames()) {
            Object instance = this.applicationContext.getBean(beanName);
            Class<?> clazz = instance.getClass();
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
                String regex = ("/" + baseUrl + "/" + pyRequestMapping.value().replaceAll("\\*", ".*")).replaceAll("/+", "/");
                Pattern pattern = Pattern.compile(regex);
                //handlerMapping.put(url,method);
                handlerMappings.add(new PYHandlerMapping(pattern, instance, method));
                System.out.println("Mapped : " + pattern + "," + method);
            }
        }
    }

}
