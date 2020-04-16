package com.pykj.spring.ioc;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private Map<String,Object> ioc = new ConcurrentHashMap<String, Object>();

    public ClassPathXmlApplicationContext(String path) {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read("./spring-example/src/main/resources/" + path);
            Element root = document.getRootElement();
            Iterator<Element> iterator =  root.elementIterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                //通过反射机制创建对象
                Class clazz = Class.forName(className);
                //通过无参数构造函数，创建目标对象
                Constructor constructor = clazz.getConstructor();
                Object o = constructor.newInstance();
                //给目标对象赋值
                Iterator<Element> elementIterator = element.elementIterator();
                while (elementIterator.hasNext()) {
                    Element element1 =  elementIterator.next();
                    String name = element1.attributeValue("name");
                    String valueStr = element1.attributeValue("value");
                    String ref = element.attributeValue("ref");
                    if(ref == null){
                        String methodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1);
                        Field field = clazz.getDeclaredField(name);
                        Method method = clazz.getDeclaredMethod(methodName,field.getType());
                        //根据成员变量的数据类型，将value进行转化
                        Object value = null;
                        if (field.getType().getName().equals("Long")) {
                            value = Long.parseLong(valueStr);
                        }
                        if(field.getType().getName().equals("java.lang.String")){
                            value = valueStr;
                        }
                        if(field.getType().getName().equals("int")){
                            value  = Integer.parseInt(valueStr);
                        }
                        method.invoke(o,value);
                    }else{

                    }
                }
                ioc.put(id,o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String id) {
        return ioc.get(id);
    }
}
