package com.pykj.gupao.application.reflection.demo2;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/22 22:51
 */
public class Main {

    public static void main(String[] args) throws Exception{
        String key = "Word";
        //Office office = getInstanceByKey(key);
        Office office = getInstanceReflectByKey(key);
        office.toPDF();
    }

    /**
     * 反射生成对象
     * @param key
     * @return
     * @throws Exception
     */
    private static Office getInstanceReflectByKey(String key) throws Exception {
        String packageName = "com.pykj.gupao.application.reflection.demo2.";
        Class clazz = Class.forName(packageName + key);
        return (Office)clazz.newInstance();
    }

    /**
     * 简单工厂模式
     * @param key
     * @return
     */
    private static Office getInstanceByKey(String key) {
        if("Word".equals(key)) {
            return new Word();
        }else if("Excel".equals(key)) {
            return new Excel();
        }
        return null;
    }


}
