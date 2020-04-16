package com.pykj.annotation.demo.annotation.configure.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @description: @Configuration表示配配置类；
 * ComponentScan扫描包路径，扫描的包必须添加Spring提供的注解，要不扫描不到,或者在配置类中自定义Bean
 * useDefaultFilters=false，指定是否需要使用Spring默认的扫描规则
 * includeFilters=Filter[]：指定只包含的组件
 * FilterType：指定过滤规则，支持的过滤规则有
 *     ANNOTATION：按照注解规则，过滤被指定注解标记的类；
 *     ASSIGNABLE_TYPE：按照给定的类型；
 *     ASPECTJ：按照ASPECTJ表达式；
 *     REGEX：按照正则表达式
 *     CUSTOM：自定义规则；
 * @author: zhangpengxiang
 * @time: 2020/4/13 16:53
 */
@Configuration
@ComponentScan(value = {"com.pykj.annotation.project","com.pykj.annotation.projectdemo"},
        useDefaultFilters = false,
        //includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {PYController.class, Component.class})}
        //includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = MyController.class)}
        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,value = MyTypeFilter.class)}
        )
//@ComponentScans(value = {@ComponentScan("com.pykj.annotation.project"), @ComponentScan("com.pykj.annotation.projectdemo")})
public class MyConfig {



}
