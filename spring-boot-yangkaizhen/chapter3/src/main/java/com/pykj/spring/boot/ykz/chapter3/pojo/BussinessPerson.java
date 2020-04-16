package com.pykj.spring.boot.ykz.chapter3.pojo;

import com.pykj.spring.boot.ykz.chapter3.pojo.definition.Animal;
import com.pykj.spring.boot.ykz.chapter3.pojo.definition.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BussinessPerson implements Person {

    /**
     * @Autowired提供这样的规则，首先它会根据类型找到对应的Bean,如果对应类型的Bean不是唯一的，那么他会根据其属性名称和Bean的名称进行匹配。如果匹配上就使用该Bean，如果还匹配不上，就会抛出异常。
     * @Autowired是一个默认必须找到对应的Bean的注解，如果不确定其标注属性一定会存在并且允许这个被标注的属性为null,那么可以配置@Autowired属性required为false
     * @Primary含义告诉SpringIoC容器，当发现有多个同样类型的Bean时，请优先使用我进行注入，于是在进行测试，系统将用猫为你提供服务
     * @Qualifier,有时候多个类同时注入@Primary还是无法区分，@Qualifier(value="")配置项value需要一个字符串去定义，它将与@Autowired组合在一起，通过类型和名称找到对应的Bean
     */
    /*@Autowired
    private Animal animal = null;
    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    };*/

    //@Autowired(required = false)
    private Animal dog;

    @Override
    public void service() {
        this.dog.use();
    }

    @Override
    @Autowired
    @Qualifier("dog")
    public void setAnimal(Animal dog) {
        System.out.println("延迟依赖注入");
        this.dog = dog;
    }


}
