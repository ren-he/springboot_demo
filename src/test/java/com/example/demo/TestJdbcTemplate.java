package com.example.demo;

import com.example.demo.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestJdbcTemplate {

	@Autowired
	private UserService userService;

	@Before
	public void setUp() {
		// 准备，清空user表
		userService.deleteAllUsers();
	}

	@Test
	public void test() {
		// 插入5个用户
		userService.addUser(1, "a", 1);
		userService.addUser(2, "b", 2);
		userService.addUser(3, "c", 3);
		userService.addUser(4, "d", 4);
		userService.addUser(5, "e", 5);

		// 查数据库，应该有5个用户
		Assert.assertEquals(5, userService.getUserCount().intValue());

		// 删除两个用户
		userService.deleteUserById(1);
		userService.deleteUserById(5);

		// 查数据库，应该有5个用户
		Assert.assertEquals(3, userService.getUserCount().intValue());

	}

}
