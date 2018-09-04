package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users") // 通过这里配置是下面的映射都在/users下
public class UserController {

    // 创建线程安全的map
    static Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> gtUserList() {

        // 处理"/users"下的GET请求，用于获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        return new ArrayList<>(userMap.values());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {

        // 处理"/users"下的POST请求，用于添加用户
        // 除了@ModelAttribute绑定参数之外，还可以用@RequestParam从页面中传递参数
        userMap.put(user.getId(), user);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {

        // 处理"/users/{id}"下的GET请求，用于获取url中id值的用户信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return userMap.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {

        // 处理"/users/{id}"下的put请求，用于更新用户信息
        User updateUser = userMap.get(id);
        updateUser.setName(user.getName());
        updateUser.setAge(user.getAge());
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {

        // 处理"/users/{id}"下的DELETE请求，用于删除用户信息
        userMap.remove(id);
        return "success";
    }
}
