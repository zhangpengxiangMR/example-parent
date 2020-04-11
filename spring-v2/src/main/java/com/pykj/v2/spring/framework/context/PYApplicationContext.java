package com.pykj.v2.spring.framework.context;

import com.pykj.v2.spring.framework.annotation.PYAutowired;
import com.pykj.v2.spring.framework.annotation.PYController;
import com.pykj.v2.spring.framework.annotation.PYService;
import com.pykj.v2.spring.framework.beans.PYBeanWrapper;
import com.pykj.v2.spring.framework.beans.config.PYBeanDefinition;
import com.pykj.v2.spring.framework.beans.support.PYBeanDefinitionReader;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 职责：完成Bean的创建和DI
 */
public class PYApplicationContext {

    //private String [] configLocations;
    /**
     * beanDefinition缓存
     */
    private Map<String, PYBeanDefinition> beanDefinitionMap = new HashMap<>();

    private PYBeanDefinitionReader reader;

    private Map<String,PYBeanWrapper> factoryBeanInstanceCache = new HashMap<>();

    /**
     * 存储对象实例化对象
     */
    private Map<String,Object> factoryBeanObjectCache = new HashMap<>();

    public PYApplicationContext(String... configLocations) {
        //this.configLocations = configLocations;
        //1、加载配置文件
        reader = new PYBeanDefinitionReader(configLocations);
        //2、解析配置文件，封装成BeanDefinition
        List<PYBeanDefinition> beanDefiinitions =  reader.loadBeanDefinitions();
        //3、把BeanDefinition缓存起来
        try {
            doRegistBeanDefinition(beanDefiinitions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        doAutowrited();
    }

    private void doAutowrited() {
        //bean并没有真正的实例化，还只是配置阶段
        for (Map.Entry<String, PYBeanDefinition> stringPYBeanDefinitionEntry : this.beanDefinitionMap.entrySet()) {
            String beanName = stringPYBeanDefinitionEntry.getKey();
            getBean(beanName);
        }
    }

    private void doRegistBeanDefinition(List<PYBeanDefinition> beanDefiinitions) throws Exception {
        for (PYBeanDefinition beanDefiinition : beanDefiinitions) {
            if(this.beanDefinitionMap.containsKey(beanDefiinition.getFactoryBeanName())) {
                //continue;
                throw new Exception("The" + beanDefiinition.getFactoryBeanName() +"is exists");
            }
            beanDefinitionMap.put(beanDefiinition.getFactoryBeanName(),beanDefiinition);
            beanDefinitionMap.put(beanDefiinition.getBeanClassName(),beanDefiinition);
        }
    }

    public Object getBean(String beanName){
        //1、获取BeanDefinition配置
        PYBeanDefinition pyBeanDefinition = this.beanDefinitionMap.get(beanName);
        //2、反射实例化newInstance()
        Object instance = instantiateBean(beanName,pyBeanDefinition);
        //3、封装成一个BeanWrapper
        PYBeanWrapper pyBeanWrapper = new PYBeanWrapper(instance);
        //4、保存到IoC容器
        factoryBeanInstanceCache.put(beanName,pyBeanWrapper);
        //5、执行依赖注入
        populateBean(beanName,pyBeanDefinition,pyBeanWrapper);
        return pyBeanWrapper.getWrapperInstance();
    }

    private void populateBean(String beanName, PYBeanDefinition pyBeanDefinition, PYBeanWrapper beanWrapper) {
        //可能涉及到循环依赖？
        //A{ B b}
        //B{ A b}
        //用两个缓存，循环两次
        //1、把第一次读取结果为空的BeanDefinition存到第一个缓存
        //2、等第一次循环之后，第二次循环再检查第一次的缓存，再进行赋值

        Object instance = beanWrapper.getWrapperInstance();

        Class<?> clazz = beanWrapper.getWrapperClass();

        //在Spring中@Component
        if(!(clazz.isAnnotationPresent(PYController.class) || clazz.isAnnotationPresent(PYService.class))){
            return;
        }

        //把所有的包括private/protected/default/public 修饰字段都取出来
        for (Field field : clazz.getDeclaredFields()) {
            if(!field.isAnnotationPresent(PYAutowired.class)){ continue; }

            PYAutowired autowired = field.getAnnotation(PYAutowired.class);

            //如果用户没有自定义的beanName，就默认根据类型注入
            String autowiredBeanName = autowired.value().trim();
            if("".equals(autowiredBeanName)){
                //field.getType().getName() 获取字段的类型
                autowiredBeanName = field.getType().getName();
            }
            //暴力访问
            field.setAccessible(true);
            try {
                if(this.factoryBeanInstanceCache.get(autowiredBeanName) == null){
                    continue;
                }
                field.set(instance,this.factoryBeanInstanceCache.get(autowiredBeanName).getWrapperInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 创建真正的实例化对象
     * @param beanName
     * @param pyBeanDefinition
     * @return
     */
    private Object instantiateBean(String beanName, PYBeanDefinition pyBeanDefinition) {
        String className = pyBeanDefinition.getBeanClassName();
        Object instance = null;
        try {
            if(this.factoryBeanObjectCache.containsKey(beanName)) {
                instance = this.factoryBeanObjectCache.get(beanName);
            }else {
                Class<?> clazz = Class.forName(className);
                instance = clazz.newInstance();
                this.factoryBeanObjectCache.put(beanName,instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    public Object getBean(Class beanClass){
        return getBean(beanClass.getName());
    }

    /**
     * 获取BeanDefinition
     * @return
     */
    public int getBeanDefiitionCount() {
        return this.beanDefinitionMap.size();
    }

    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }

    public Properties getConfig() {
        return this.reader.getConfig();
    }
}
