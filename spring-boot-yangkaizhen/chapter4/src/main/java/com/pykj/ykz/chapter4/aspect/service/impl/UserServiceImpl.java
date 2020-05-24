package com.pykj.ykz.chapter4.aspect.service.impl;

import com.pykj.ykz.chapter4.aspect.pojo.Person;
import com.pykj.ykz.chapter4.aspect.pojo.User;
import com.pykj.ykz.chapter4.aspect.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @description: 连接点
 * @author: zhangpengxiang
 * @time: 2020/4/21 17:16
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public Person printUser(User user) {
        if(user.getId() == null || "".equals(user.getId())) {
            throw  new RuntimeException("检查用户参数是否为空");
        }
        System.out.println("UserServiceImpl打印对象信息" + user);
        Person person = new Person();
        person.setId(Long.parseLong("666"));
        person.setName("888");
        return person;
    }
}
