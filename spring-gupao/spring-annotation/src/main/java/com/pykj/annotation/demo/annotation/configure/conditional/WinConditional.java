package com.pykj.annotation.demo.annotation.configure.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/14 23:38
 */
public class WinConditional  implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println("----" + osName + "----");
        String osTest = environment.getProperty("os.test");
        System.out.println("----" + osTest + "----");
        if("Windows".equals(osName)){
            return true;
        }
        return false;
    }
}
