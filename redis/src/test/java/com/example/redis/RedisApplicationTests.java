package com.example.redis;

import com.example.redis.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

//	@Autowired(required = false)
	@Resource
	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void contextLoads() {
		//保存对象
		User user = new User("1", 11);
		redisTemplate.opsForValue().set(user.getUsername(), user);

		user = new User("2", 22);
		redisTemplate.opsForValue().set(user.getUsername(), user);

		user = new User("3", 33);
		redisTemplate.opsForValue().set(user.getUsername(), user);

		Assert.assertEquals(11, redisTemplate.opsForValue().get("1").getAge().longValue());
		Assert.assertEquals(22, redisTemplate.opsForValue().get("2").getAge().longValue());
		Assert.assertEquals(33, redisTemplate.opsForValue().get("3").getAge().longValue());
	}

}
