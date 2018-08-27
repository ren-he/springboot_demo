package com.example.demo;

import com.example.demo.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ApplicationTests {

	private MockMvc mvc;

	/*
	@Before
	public void setup() {
		mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
	}

	@Test
	public void contextLoads() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				//.andExpect(content().string(equalTo("Hello World!")));
	}*/

	@Before
	public void setup() {
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void testUserController() throws Exception{
		RequestBuilder requestBuilder;

		// get 查询用户列表，应该为空
		requestBuilder = get("/users/");
		mvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[]")));

        // post 提交一个用户
		requestBuilder = post("/users/")
				.param("id", "1")
				.param("name", "任贺")
				.param("age", "27");
		mvc.perform(requestBuilder)
				.andExpect(content().string(equalTo("success")));

		// get 查询用户列表，应该有刚才插入的数据
		requestBuilder = get("/users/");
		mvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"任贺\",\"age\":27}]")));

		// put 修改用户信息
		requestBuilder = put("/users/1")
				.param("name", "任合意")
				.param("age", "27");
		mvc.perform(requestBuilder)
				.andExpect(content().string(equalTo("success")));

		// get 取得一个id为1的用户
		requestBuilder = get("/users/1");
		mvc.perform(requestBuilder)
				.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"任合意\",\"age\":27}")));

		// delete 删除id为1的用户
		requestBuilder = delete("/users/1");
		mvc.perform(requestBuilder)
				.andExpect(content().string(equalTo("success")));

		// get 查询用户列表，应该为空
		requestBuilder = get("/users/");
		mvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[]")));

	}

}
