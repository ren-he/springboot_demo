package com.example.demo.service;

public interface UserService {

    /**
     * 添加用户
     * @param userId
     * @param userName
     * @param age
     */
    void addUser(Integer userId, String userName, Integer age);

    /**
     * 根据ID删除用户
     * @param userId
     */
    void deleteUserById(Integer userId);

    /**
     * 查询用户数
     * @return
     */
    Integer getUserCount();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();
}
