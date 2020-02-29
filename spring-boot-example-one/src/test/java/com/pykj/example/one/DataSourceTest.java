package com.pykj.example.one;

import com.pykj.example.one.domain.Users;
import com.pykj.example.one.repository.primary.UserTest1Repository;
import com.pykj.example.one.repository.secondary.UserTest2Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {

    @Resource
    private UserTest1Repository userTest1Repository;
    @Resource
    private UserTest2Repository userTest2Repository;

    @Test
    public void testSave() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userTest1Repository.save(new Users(4L,"aa", "aa123456","aa@126.com", "aa",  formattedDate));
        userTest1Repository.save(new Users(5L,"bb", "bb123456","bb@126.com", "bb",  formattedDate));
        userTest2Repository.save(new Users(6L,"cc", "cc123456","cc@126.com", "cc",  formattedDate));

    }

}
