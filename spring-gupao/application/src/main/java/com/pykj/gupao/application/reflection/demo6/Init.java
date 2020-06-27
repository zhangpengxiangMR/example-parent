package com.pykj.gupao.application.reflection.demo6;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/27 23:24
 */
public class Init {


    public static void main(String[] args) throws Exception {
        List<BeanConfig> beanConfigList = xmlBean();
        if(beanConfigList != null && beanConfigList.size() > 0) {
            for ( BeanConfig beanConfig:beanConfigList) {
                if(null != beanConfig.getClazz() ) {
                    Class clazz = Class.forName(beanConfig.getClazz());
                    if(null != beanConfig.getFactoryMethod()) {
                        //静态工厂创建
                        Method method = clazz.getDeclaredMethod(beanConfig.getFactoryMethod());
                        IocContainer.putBean(beanConfig.getId(),method.invoke(null));
                    }else {
                        //无参构造创建
                        IocContainer.putBean(beanConfig.getId(),clazz.newInstance());
                    }
                }else if(null != beanConfig.getFactoryBean()) {
                    Object bean = IocContainer.getBean(beanConfig.getFactoryBean());
                    if(null == bean) {
                        System.out.println("数据格式有误...");
                    }
                    Method method = bean.getClass().getDeclaredMethod(beanConfig.getFactoryMethod());
                    IocContainer.putBean(beanConfig.getId(),method.invoke(bean));
                }else {
                    System.out.println("数据格式有误");
                }
            }
        }
    }


    private static List<BeanConfig> xmlBean() {
        List<BeanConfig> list = new ArrayList<>();
        BeanConfig beanConfig1 = new BeanConfig();
        beanConfig1.setId("a");
        beanConfig1.setClazz("com.pykj.gupao.application.reflection.demo5.A");
        list.add(beanConfig1);

        BeanConfig beanConfig2 = new BeanConfig();
        beanConfig2.setId("b");
        beanConfig2.setClazz("com.pykj.gupao.application.reflection.demo5.A");
        beanConfig2.setFactoryMethod("createBObj");
        list.add(beanConfig2);

        BeanConfig beanConfig3 = new BeanConfig();
        beanConfig3.setId("c");
        beanConfig3.setFactoryBean("a");
        beanConfig3.setFactoryMethod("createCObj");
        list.add(beanConfig3);

        return list;

    }

}
