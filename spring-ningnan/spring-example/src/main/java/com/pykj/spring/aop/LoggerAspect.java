package com.pykj.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect//表示该类是一个切面类
@Component//将该类的对象注入到Ioc容器
public class LoggerAspect {

    @Before(value = "execution(public int com.pykj.spring.aop.CalImpl.*(..))")//表示方法执行的具体位置和时机
    public void before(JoinPoint joinPoint) {
        //获取方法名
        String name = joinPoint.getSignature().getName();
        //获取参数
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(name + "方法参数是：" + args);

    }

    @After(value = "execution(public int com.pykj.spring.aop.CalImpl.*(..))")//表示方法执行的具体位置和时机
    public void after(JoinPoint joinPoint) {
        //获取方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法执行完毕");
    }

    @AfterReturning(value = "execution(public int com.pykj.spring.aop.CalImpl.*(..))", returning = "object")
    public void afterReturning(JoinPoint joinPoint, Object object) {
        //获取方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "的结果是:" + object);
    }

    @AfterThrowing(value = "execution(public int com.pykj.spring.aop.CalImpl.*(..))", throwing = "ex")
    public void afterReturning(JoinPoint joinPoint, Exception ex) {
        //获取方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法抛出异常:" + ex);
    }

}
