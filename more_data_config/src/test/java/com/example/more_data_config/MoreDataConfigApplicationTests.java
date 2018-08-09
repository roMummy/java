package com.example.more_data_config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoreDataConfigApplicationTests {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	protected JdbcTemplate jdbcTemplate1;

	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	protected JdbcTemplate jdbcTemplate2;

	@Before
	public void setUp() {
//		jdbcTemplate1.update("DELETE FROM USER ");
//		jdbcTemplate2.update("DELETE FROM USER ");
	}

	@Test
	public void contextLoads() {
		//忘第一个数据源中插入两天数据
		jdbcTemplate1.update("INSERT INTO USER(id,name,age) VALUE(?,?,?)", 1,"张三",10);
		jdbcTemplate1.update("INSERT INTO USER(id,name,age) VALUE(?,?,?)", 2,"李四",20);

		// 往第二个数据源中插入一条数据，若插入的是第一个数据源，则会主键冲突报错
		jdbcTemplate2.update("INSERT INTO USER(id,name,age) VALUE(?,?,?)", 1,"张三",10);

		// 查一下第一个数据源中是否有两条数据，验证插入是否成功
		Assert.assertEquals("2", jdbcTemplate1.queryForObject("select count(1) from user", String.class));

		// 查一下第二个数据源中是否有两条数据，验证插入是否成功
		Assert.assertEquals("1", jdbcTemplate2.queryForObject("select count(1) from user", String.class));
	}

}
