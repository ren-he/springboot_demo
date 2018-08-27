package com.example.demo.controller;

import com.example.demo.common.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestErrorController {

    @RequestMapping("/errorPage")
    public String errorPage() throws Exception {

        // 测试统一异常处理
        throw new Exception("发生错误");
    }

    @RequestMapping("/errorJson")
    public String errorJson() throws Exception {

        // 测试统一异常处理
        throw new MyException("发生错误");
    }
}
