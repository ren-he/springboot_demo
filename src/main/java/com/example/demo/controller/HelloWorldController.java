package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/*
1.使用@Controller 注解，在对应的方法上，视图解析器可以解析return的jsp/html页面，并且跳转到相应页面

    若返回json等内容到页面，则需要加@ResponseBody注解。

2.@RestController注解，相当于@Controller+@ResponseBody两个注解的结合，返回json数据不需要在方法

    前面加@ResponseBody注解了，但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器

    无法解析jsp,html页面
*/

@RestController
public class HelloWorldController {

    @RequestMapping("/hello_world")
    public String index() {
        return "Hello World!";
    }

}
