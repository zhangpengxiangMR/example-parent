package com.pykj.ykz.chapter4.aspect;

import com.pykj.ykz.chapter4.aspect.pojo.Person;
import com.pykj.ykz.chapter4.aspect.pojo.User;
import com.pykj.ykz.chapter4.aspect.validator.UserValidator;
import com.pykj.ykz.chapter4.aspect.validator.impl.UserValidatorImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @description: 切面
 * @author: zhangpengxiang
 * @time: 2020/4/21 17:22
 */
@Slf4j
@Aspect
public class MyAspect {

    /**
     * 定义切点
     */
    @Pointcut("execution(* com.pykj.ykz.chapter4.*.*.*.*.printUser(..)) && bean(userServiceImpl)")
    public void pointCut() {
    }

    /**
     * 引入
     */
    @DeclareParents(
            value = "com.pykj.ykz.chapter4.aspect.service.impl.UserServiceImpl+",
            defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    /**
     * 环绕通知
     *
     * @param proceedingJoinPoint
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("around before");
        log.info("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());
        processInputArg(proceedingJoinPoint.getArgs());
        try {
            //obj之前可以写目标方法执行前的逻辑
            // 调用执行目标方法
            Object obj = proceedingJoinPoint.proceed();
            processOutPutObj(obj);
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("around after");
        return null;
    }

    /**
     * 处理返回对象
     */
    private void processOutPutObj(Object obj) {
        log.info("原OBJ为：" + obj.toString());
        if (obj instanceof Person) {
            Person resultVO = (Person) obj;
            resultVO.setName("小龙人");
            log.info("修改后：" + resultVO);
        }
    }

    /**
     * 处理输入参数
     *
     * @param args 入参列表
     */
    private void processInputArg(Object[] args) {
        for (Object arg : args) {
            System.out.println("ARG原来为:" + arg);
            if (arg instanceof User) {
                User paramVO = (User) arg;
                paramVO.setUserName("xiaolong英文版");
            }
        }
    }


    /**
     * 事前通知
     *
     * @param point
     * @param user
     */
    @Before("pointCut() && args(user)")
    public void before(JoinPoint point, User user) {
        log.info("User对象打印：" + user);
        Object[] args = point.getArgs();
        log.info(" point.getArgs()打印：" + Arrays.toString(args));
        log.info("before...");
    }

    /**
     * 事后通知
     *
     * @param point
     */
    @After("pointCut()")
    public void after(JoinPoint point) {
        Object[] args = point.getArgs();
        log.info(" point.getArgs()打印：" + Arrays.toString(args));
        log.info("after...");
    }

    /**
     * 没有异常才会执行
     *
     * @param point
     * @param ret
     */
    @AfterReturning(value = "pointCut()", returning = "ret")
    public Object afterReturning(JoinPoint point, Object ret) {
        Object[] args = point.getArgs();
        log.info(" point.getArgs()打印：" + Arrays.toString(args));
        log.info("第一个后置返回通知的返回值：" + ret);
        Person person = null;
        if (ret instanceof Person) {
            person = (Person) ret;
            person.setName("通过AOP把值修改了");
        }
        log.info("修改完毕-->返回方法为:" + ret);
        log.info("afterReturning ......");
        return person;
    }

    /**
     * 异常执行
     *
     * @param point
     */
    @AfterThrowing("pointCut()")
    public void afterThrowing(JoinPoint point) {
        Object[] args = point.getArgs();
        log.info(" point.getArgs()打印：" + Arrays.toString(args));
        log.info("afterThrowing ......");
    }


    /**
     * 切点的定义
     * exexution 表示在执行的时候，拦截里面的正则匹配的方法
     * * 表示任意返回类型的方法
     * com.pykj.ykz.chapter4.aspect.service.impl.UserServiceImpl 指定目标对象的全限定名称
     * printUser 指定目标对象的方法
     * (..) 表示任意参数进行匹配
     * Aspectj指示器
     * arg()限定连接点方法参数
     */
   /* @Pointcut("execution(* com.pykj.ykz.chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(){
        log.info("before...");
    }

    @After("pointCut()")
    public void after(){
        log.info("after...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        log.info("afterReturning ......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        log.info("afterThrowing ......");
    }*/

    /*@Before("execution(* com.pykj.ykz.chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void before(){
        log.info("before...");
    }

    @After("execution(* com.pykj.ykz.chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void after(){
        log.info("after...");
    }

    @AfterReturning("execution(* com.pykj.ykz.chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void afterReturning() {
        log.info("afterReturning ......");
    }

    @AfterThrowing("execution(* com.pykj.ykz.chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void afterThrowing() {
        log.info("afterThrowing ......");
    }*/


}
