package com.example.mybatis;

import com.example.mybatis.model.User;
import com.example.mybatis.dao.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
    public void findByName() throws Exception {
//	    userMapper.insert("b", 1);
//        List<User> users = userMapper.findByName("b");
//		userMapper.deleteById(1);
//        Assert.assertEquals(1, users.get(0).getAge().intValue());
		List<User> u = userMapper.findByIds(6);
		System.out.print(u);
    }

}
