package com.pykj.v2.spring.framework.webmvc.servlet;

import com.pykj.v2.spring.framework.annotation.PYRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 适配器模式：用来亡羊补牢，
 */
public class PYHandlerAdapter {


    public PYModelAndView handler(HttpServletRequest req, HttpServletResponse resp, PYHandlerMapping handlerMapping) throws Exception {
        //形参列表(形参，对应方法上的位置)
        Map<String, Integer> paramIndexMapping = new HashMap<>();
        //通过运行时的状态去拿到你
        Annotation[][] pa = handlerMapping.getMethod().getParameterAnnotations();
        for (int i = 0; i < pa.length; i++) {
            for (Annotation a : pa[i]) {
                if (a instanceof PYRequestParam) {
                    String paramName = ((PYRequestParam) a).value();
                    if (!"".equals(paramName.trim())) {
                        /*String value = Arrays.toString(params.get(paramName))
                                .replaceAll("\\[|\\]", "")
                                .replaceAll("\\s+", ",");
                        paramValues[i] = value;*/
                        paramIndexMapping.put(paramName, i);
                    }
                }
            }
        }
        //初始化request,response
        Class<?>[] paramTypes = handlerMapping.getMethod().getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> paramterType = paramTypes[i];
            if (paramterType == HttpServletRequest.class || paramterType == HttpServletResponse.class) {
                paramIndexMapping.put(paramterType.getName(), i);
            }
        }
        /*****************************************获取实参列表**************************************************************/
        //去拼接实参列表
        //request中拿到传递的参数
        Map<String, String[]> params = req.getParameterMap();
        //保存实参列表
        Object[] paramValues = new Object[paramTypes.length];
        //循环实参列表，拿到values和对应的index，进行赋值操作
        for (Map.Entry<String, String[]> param : params.entrySet()) {
            String value = Arrays.toString(params.get(param.getKey()))
                    .replaceAll("\\[|\\]", "")
                    .replaceAll("\\s+", ",");
            if (!paramIndexMapping.containsKey(param.getKey())) {
                continue;
            }
            int index = paramIndexMapping.get(param.getKey());
            paramValues[index] = castStringValue(value, paramTypes[index]);
        }
        if (paramIndexMapping.containsKey(HttpServletRequest.class.getName())) {
            int index = paramIndexMapping.get(HttpServletRequest.class.getName());
            paramValues[index] = req;
        }
        if (paramIndexMapping.containsKey(HttpServletResponse.class.getName())) {
            int index = paramIndexMapping.get(HttpServletResponse.class.getName());
            paramValues[index] = resp;
        }
        /**********************************************执行方法********************************************************/
        Object result = handlerMapping.getMethod().invoke(handlerMapping.getController(), paramValues);
        if (result == null || result instanceof Void) {
            return null;
        }
        boolean isModelAndView = handlerMapping.getMethod().getReturnType() == PYModelAndView.class;
        if (isModelAndView) {
            return (PYModelAndView) result;
        }
        return null;
    }

    private Object castStringValue(String value, Class<?> paramType) {
        if (String.class == paramType) {
            return value;
        } else if (Byte.class == paramType) {
            return Byte.parseByte(value);
        } else if (Integer.class == paramType) {
            return Integer.parseInt(value);
        } else if (Short.class == paramType) {
            return Short.parseShort(value);
        } else if (Long.class == paramType) {
            return Long.parseLong(value);
        } else if (Float.class == paramType) {
            return Float.parseFloat(value);
        } else if (Double.class == paramType) {
            return Double.parseDouble(value);
        } else if (Boolean.class == paramType) {
            return Boolean.parseBoolean(value);
        }
        return null;
    }
}
