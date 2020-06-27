package com.pykj.gupao.application.reflection.demo6;

import java.util.HashMap;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/27 23:23
 */
public class IocContainer {

    private static HashMap container =new HashMap();

    public static void putBean(String id,Object object) {
        container.put(id,object);
    }

    public static Object getBean(String id) {
        return container.get(id);
    }

}
