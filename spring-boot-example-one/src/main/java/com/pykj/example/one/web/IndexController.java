package com.pykj.example.one.web;

import com.pykj.example.one.domain.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @RestController 里面的方法都以 json 格式输出，不用再配置什么 jackjson 的了！ 如果配置为@Controller 就代表着输出为页面内容
 */
@RestController
@Validated
public class IndexController {

    @RequestMapping("index")
    public String index(@NotNull(message = "name 不能为空") String name){
        return "spring-boot-example-one:" +name;
    }


    @RequestMapping(value="get/{name}", method= RequestMethod.GET)
    public User get(@PathVariable String name) {
        User user=new User();
        user.setName(name);
        return user;
    }


}
