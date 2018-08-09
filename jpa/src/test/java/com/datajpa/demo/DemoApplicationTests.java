package com.datajpa.demo;

import com.datajpa.demo.user.User;
import com.datajpa.demo.user.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
//
	@Autowired
	private UserRepository userRepository;


	@Test
	public void contextLoads() {
		//创建记录
		System.out.print("测试你好");
		userRepository.save(new User("aaa", 1));
		userRepository.save(new User("bbb", 2));
		userRepository.save(new User("ccc", 3));

		Assert.assertEquals(3, userRepository.findAll().size());
		Assert.assertEquals(1, userRepository.findByName("aaa").getAge().intValue());
	}

}
