package com.pykj.spring.boot.ykz.chapter3.pojo;

import com.pykj.spring.boot.ykz.chapter3.pojo.definition.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Primary含义告诉SpringIoC容器，当发现有多个同样类型的Bean时，请优先使用我进行注入，于是在进行测试，系统将用猫为你提供服务
 */
@Component
@Primary
public class Cat implements Animal {

    @Override
    public void use() {
        System.out.println("猫【" + Cat.class.getSimpleName() + "】是抓老鼠。");
    }
}
