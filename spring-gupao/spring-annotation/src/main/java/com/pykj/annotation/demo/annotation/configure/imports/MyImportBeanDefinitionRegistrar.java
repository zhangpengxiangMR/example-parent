package com.pykj.annotation.demo.annotation.configure.imports;

import com.pykj.annotation.project.entity.MyUser;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/15 12:13
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //如果有com.pykj.annotation.project.entity.Member\com.pykj.annotation.project.entity.Company这两个类就加载User
        boolean member = registry.containsBeanDefinition("com.pykj.annotation.project.entity.MyMember");
        boolean company = registry.containsBeanDefinition("com.pykj.annotation.project.entity.MyCompany");
        if (member && company) {
            BeanDefinition beanDefinition = new RootBeanDefinition(MyUser.class);
            registry.registerBeanDefinition("myUser", beanDefinition);
        }
    }
}
