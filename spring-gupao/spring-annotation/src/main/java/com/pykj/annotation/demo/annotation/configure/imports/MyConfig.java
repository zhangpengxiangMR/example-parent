package com.pykj.annotation.demo.annotation.configure.imports;


import com.pykj.annotation.project.entity.MyCat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @description: @Import
 * @author: zhangpengxiang
 * @time: 2020/4/15 11:50
 */
@Configuration
@Import(value = {MyCat.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MyConfig {

    /**
     * 给IoC容器注册Bean的方式
     * 1、@Bean：直接导入单个Bean
     * 2、@ComponentScan：默认扫描(@Controller@Service@Repostory@Component)这几种注解
     * 3、Import：快速给容器导入Bean的方式
     * a、通过@Import直接导入
     * b、实现ImportSelector，自定义规则实现
     * c、实现ImportBeanDefinitionRegistrar，获得BeanDefinitionRegistry可以手动直接往IoC容器塞
     * 4、FactoryBean把需要注册的对象封装为FactoryBean
     * a、FactoryBean负责将Bean注册到IoC容器中
     * b、BeanFactory负责从IoC容器中获得Bean对象
     */
    @Bean
    public MyFactoryBean monkey() {
        return new MyFactoryBean();
    }


}
