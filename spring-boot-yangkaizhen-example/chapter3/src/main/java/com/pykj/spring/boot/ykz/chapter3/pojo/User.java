package com.pykj.spring.boot.ykz.chapter3.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Component表明这个类将被SpringIoC容器扫描装配，其中配置的“user”则是作为Bean的名称，当然你也可以不配置这个字符串，那么IoC容器就会把类名的第一个字母作为小写，其他不变作为Bean名称让如到IoC容器中
 * @Value则是指定具体的值，使得SpringIoC给与对应的属性注入对用的值。
 */
@Component("user")
public class User {
    @Value("1")
    private Long id;
    @Value("user_name_1")
    private String userName;
    @Value("note_1")
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
