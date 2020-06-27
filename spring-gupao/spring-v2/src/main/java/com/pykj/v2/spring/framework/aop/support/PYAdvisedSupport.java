package com.pykj.v2.spring.framework.aop.support;

import com.pykj.v2.spring.framework.aop.aspect.PYAdvice;
import com.pykj.v2.spring.framework.aop.config.PYAopConfig;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * AOP的核心处理类
 */
public class PYAdvisedSupport {

    /**
     * 保存AopConfig的用户配置信息
     */
    private PYAopConfig config;

    /**
     * 类的实例对象，通过instantiateBean()方法传入
     */
    private Object target;

    /**
     * 类的class对象，通过instantiateBean()方法传入
     */
    private Class targetClass;

    /**
     * 方法的通知缓存
     */
    private Map<Method, Map<String, PYAdvice>> methodCache;
    //private Map<Method, List<Object>> methodCache;


    private Pattern pointCutClassPattern;

    public PYAdvisedSupport(PYAopConfig config) {
        this.config = config;
    }

    private void parse() {
        //把Spring的Excpress变成Java能够识别的正则表达式
        //public .* com\.pykj\.v2\.demo\.service\..*Service\..*\(.*\)
        String pointCut = config.getPointCut()
                .replaceAll("\\.", "\\\\.")
                .replaceAll("\\\\.\\*", ".*")
                .replaceAll("\\(", "\\\\(")
                .replaceAll("\\)", "\\\\)");
        //保存专门匹配Class的正则
        //public .* com\.pykj\.v2\.demo\.service\..*Service
        String pointCutForClassRegex = pointCut.substring(0, pointCut.lastIndexOf("\\(") - 4);
        //class com\.pykj\.v2\.demo\.service\..*Service
        pointCutClassPattern = Pattern.compile("class " + pointCutForClassRegex.substring(pointCutForClassRegex.lastIndexOf(" ") + 1));
        //保存专门匹配方法的正则
        //public .* com\.pykj\.v2\.demo\.service\..*Service\..*\(.*\)
        Pattern pointCutPattern = Pattern.compile(pointCut);

        //享元的共享池
        methodCache = new HashMap<Method, Map<String, PYAdvice>>();
        try {
            //切面类
            Class aspectClass = Class.forName(this.config.getAspectClass());
            //保存切面类的所有方法
            Map<String, Method> aspectMethods = new HashMap<String, Method>();
            for (Method method : aspectClass.getMethods()) {
                aspectMethods.put(method.getName(), method);
            }
            //目标对象的所有方法
            for (Method method : this.targetClass.getMethods()) {
                String methodString = method.toString();
                System.out.println("----:" + methodString);
                if (methodString.contains("throws")) {
                    methodString = methodString.substring(0, methodString.lastIndexOf("throws")).trim();
                }

                Matcher matcher = pointCutPattern.matcher(methodString);
                if (matcher.matches()) {
                    Map<String, PYAdvice> advices = new HashMap<String, PYAdvice>();

                    if (!(null == config.getAspectBefore() || "".equals(config.getAspectBefore()))) {
                        advices.put("before", new PYAdvice(aspectClass.newInstance(), aspectMethods.get(config.getAspectBefore())));
                    }
                    if (!(null == config.getAspectAfter() || "".equals(config.getAspectAfter()))) {
                        advices.put("after", new PYAdvice(aspectClass.newInstance(), aspectMethods.get(config.getAspectAfter())));
                    }
                    if (!(null == config.getAspectAfterThrow() || "".equals(config.getAspectAfterThrow()))) {
                        PYAdvice advice = new PYAdvice(aspectClass.newInstance(), aspectMethods.get(config.getAspectAfterThrow()));
                        advice.setThowName(config.getAspectAfterThrowingName());
                        advices.put("afterThrow", advice);
                    }
                    //跟目标代理类的业务方法和Advices建立一对多个关联关系，以便在Porxy类中获得
                    methodCache.put(method, advices);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据一个目标代理类的方法，获得其对应的通知
     *
     * @param method
     * @param o
     * @return
     */
    public Map<String, PYAdvice> getAdvices(Method method, Object o) throws Exception {
        Map<String, PYAdvice> cache = methodCache.get(method);
        if (null == cache) {
            Method m = targetClass.getMethod(method.getName(), method.getParameterTypes());
            cache = methodCache.get(m);
            this.methodCache.put(m, cache);
        }
        return cache;
    }

    /**
     * 验证当前类是否满足AOP切面要求
     *
     * @return
     */
    public boolean pointCutMath() {
        return pointCutClassPattern.matcher(this.targetClass.toString()).matches();
    }


    /**
     * 类的class对象，通过instantiateBean()方法传入
     *
     * @param clazz
     */
    public void setTargetClass(Class<?> clazz) {
        this.targetClass = clazz;
        parse();
    }

    /**
     * 类的实例对象，通过instantiateBean()方法传入
     *
     * @param instance
     */
    public void setTarget(Object instance) {
        this.target = instance;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
