package com.pykj.v2.spring.framework.beans.support;

import com.pykj.v2.spring.framework.beans.config.PYBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *  职责：加载配置文件
 */
public class PYBeanDefinitionReader {

    /**
     * 保存扫描的结果
     */
    private List<String> regitryBeanClasses = new ArrayList<String>();

    //private String [] configLocations;
    /**
     * Properties
     */
    private Properties contextConfig = new Properties();

    public PYBeanDefinitionReader(String... configLocations) {
        //读取配置文件
        doLoadConfig(configLocations[0]);
        //扫描配置文件中的配置的相关的类
        doScanner(contextConfig.getProperty("scanPackage"));
    }

    public List<PYBeanDefinition> loadBeanDefinitions() {
        List<PYBeanDefinition> result = new ArrayList<>();
        for (String regitryBeanClass : regitryBeanClasses) {
            try {
                Class<?> clazz = Class.forName(regitryBeanClass);
                String beanName = toLowerFirstCase(clazz.getSimpleName());
                String beanClassName = clazz.getName();
                //1、默认是类名首字母小写
                result.add(doCreateBeanDefinition(beanName,beanClassName));
                //2、自定义
                //3、接口注入
                for (Class<?> i : clazz.getInterfaces()) {
                    result.add(doCreateBeanDefinition(i.getName(),clazz.getName()));
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private PYBeanDefinition doCreateBeanDefinition(String beanName, String beanClassName) {
        PYBeanDefinition pyBeanDefinition = new PYBeanDefinition();
        pyBeanDefinition.setFactoryBeanName(beanName);
        pyBeanDefinition.setBeanClassName(beanClassName);
        return pyBeanDefinition;
    }

    private void doLoadConfig(String contextConfigLocation) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation.replaceAll("classpath:",""));
        try {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doScanner(String scanPackage) {
        //jar 、 war 、zip 、rar
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.","/"));
        File classPath = new File(url.getFile());

        //当成是一个ClassPath文件夹
        for (File file : classPath.listFiles()) {
            if(file.isDirectory()){
                doScanner(scanPackage + "." + file.getName());
            }else {
                if(!file.getName().endsWith(".class")){continue;}
                //全类名 = 包名.类名
                String className = (scanPackage + "." + file.getName().replace(".class", ""));
                regitryBeanClasses.add(className);
            }
        }
    }

    private String toLowerFirstCase(String simpleName) {
        char [] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
