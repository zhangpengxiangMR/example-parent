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
 *
 *  职责：加载配置文件
 */
public class PYBeanDefinitionReader {

    /**
     * 保存扫描的结果(所有.class类的全类名 = 包名.类名)
     */
    private List<String> regitryBeanClasses = new ArrayList<String>();

    //private String [] configLocations;
    /**
     * Properties，读取到的配置信息
     */
    private Properties contextConfig = new Properties();

    public PYBeanDefinitionReader(String... configLocations) {
        //读取web.xml中的配置文件，默认读取第一个classpath:application.properties
        doLoadConfig(configLocations[0]);
        //从properties中找到配置的扫描包路径(scanPackage=com.pykj.v2.demo)，扫描配置文件中的配置的相关的类
        doScanner(contextConfig.getProperty("scanPackage"));
    }

    public Properties getConfig(){
        return this.contextConfig;
    }

    /**
     * 通过.class类的全类名得到一个clazz，把beanName和beanClassName保存到PYBeanDefinition中
     * @return
     */
    public List<PYBeanDefinition> loadBeanDefinitions() {
        List<PYBeanDefinition> result = new ArrayList<>();
        for (String regitryBeanClass : regitryBeanClasses) {
            try {
                Class<?> clazz = Class.forName(regitryBeanClass);
                if(clazz.isInterface()){continue;}
                String beanName = toLowerFirstCase(clazz.getSimpleName());
                String beanClassName = clazz.getName();
                System.out.println("beanName输出：" + beanName);
                System.out.println("beanClassName输出：" + beanClassName);
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

    /**
     * 读取web.xml配置文件中的classpath:application.properties，把结果封装到contextConfig中，也就是一个Properties文件
     * @param contextConfigLocation
     */
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

    /**
     * scanPackage=com.pykj.v2.demo，扫描所有配置的包路径，把.class文件保存到regitryBeanClasses
     * @param scanPackage
     */
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
