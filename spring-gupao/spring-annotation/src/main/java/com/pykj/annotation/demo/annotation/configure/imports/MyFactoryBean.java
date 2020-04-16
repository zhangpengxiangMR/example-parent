package com.pykj.annotation.demo.annotation.configure.imports;

import com.pykj.annotation.project.entity.MyMonkey;
import org.springframework.beans.factory.FactoryBean;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/15 12:32
 */
public class MyFactoryBean implements FactoryBean<MyMonkey> {
    @Override
    public MyMonkey getObject() throws Exception {
        return new MyMonkey();
    }

    @Override
    public Class<?> getObjectType() {
        return MyMonkey.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
