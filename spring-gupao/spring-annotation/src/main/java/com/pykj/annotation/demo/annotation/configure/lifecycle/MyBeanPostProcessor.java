package com.pykj.annotation.demo.annotation.configure.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/15 17:51
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before" + beanName + "-" + bean);
        return bean;
    }

    @Override
    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("After" + beanName + "-" + bean);
        return bean;
    }
}
