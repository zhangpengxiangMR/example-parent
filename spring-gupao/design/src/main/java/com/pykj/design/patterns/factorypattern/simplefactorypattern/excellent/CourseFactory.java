package com.pykj.design.patterns.factorypattern.simplefactorypattern.excellent;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/20 23:35
 */
public class CourseFactory {

    public static ICourse create(String name){
        if("java".equals(name)){
            return new JavaCourse();
        }else if("python".equals(name)) {
            return new PythonCourse();
        }else {
            return null;
        }
    }

}
