package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    /*@RequestMapping("/index")
    public String index(ModelMap map) {

        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "www.baidu.com");

        // 返回模板文件名称，对应src/main/resources/templates/index.html
        return "index";

    }*/

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}
