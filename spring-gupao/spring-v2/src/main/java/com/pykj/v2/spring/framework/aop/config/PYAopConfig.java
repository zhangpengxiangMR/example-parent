package com.pykj.v2.spring.framework.aop.config;

/**
 * 配置信息
 */
public class PYAopConfig {

    /**
     * 切面表达式
     */
    private String pointCut;
    /**
     * 切面类
     */
    private String aspectClass;
    /**
     * 前置通知回调方法
     */
    private String aspectBefore;
    /**
     * 后置通知回调方法
     */
    private String aspectAfter;
    /**
     * 异常通知回调方法
     */
    private String aspectAfterThrow;
    /**
     * 异常类型捕获
     */
    private String aspectAfterThrowingName;

    public String getPointCut() {
        return pointCut;
    }

    public void setPointCut(String pointCut) {
        this.pointCut = pointCut;
    }

    public String getAspectClass() {
        return aspectClass;
    }

    public void setAspectClass(String aspectClass) {
        this.aspectClass = aspectClass;
    }

    public String getAspectBefore() {
        return aspectBefore;
    }

    public void setAspectBefore(String aspectBefore) {
        this.aspectBefore = aspectBefore;
    }

    public String getAspectAfter() {
        return aspectAfter;
    }

    public void setAspectAfter(String aspectAfter) {
        this.aspectAfter = aspectAfter;
    }

    public String getAspectAfterThrow() {
        return aspectAfterThrow;
    }

    public void setAspectAfterThrow(String aspectAfterThrow) {
        this.aspectAfterThrow = aspectAfterThrow;
    }

    public String getAspectAfterThrowingName() {
        return aspectAfterThrowingName;
    }

    public void setAspectAfterThrowingName(String aspectAfterThrowingName) {
        this.aspectAfterThrowingName = aspectAfterThrowingName;
    }
}
