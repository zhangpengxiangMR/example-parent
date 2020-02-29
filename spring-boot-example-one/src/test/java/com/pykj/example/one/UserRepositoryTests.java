package com.pykj.example.one;

import com.pykj.example.one.domain.Users;
import com.pykj.example.one.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Resource
    private UserRepository userRepository;

    @Test
    public void test()  {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new Users(1L,"aa", "aa@126.com", "aa", "aa123456",formattedDate));
        userRepository.save(new Users(2L,"bb", "bb@126.com", "bb", "bb123456",formattedDate));
        userRepository.save(new Users(3L,"cc", "cc@126.com", "cc", "cc123456",formattedDate));

        System.out.println("获取size()" +userRepository.findAll().size());
        Assert.assertEquals("你是正确的吗？",9, userRepository.findAll().size());
        /* Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());*/
        System.out.println( userRepository.findByUserNameOrEmail("cc", "cc@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa"));

        Assert.assertEquals("去你大爷的",2,1);
    }

}
