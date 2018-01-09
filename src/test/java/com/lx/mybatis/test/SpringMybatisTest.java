package com.lx.mybatis.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lx.eclipse.service.EclipseMavenTestService;
import com.lx.eclipse.vo.EclipseMavenTest;

@RunWith(SpringJUnit4ClassRunner.class)
//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class SpringMybatisTest {

	private static Logger logger = Logger.getLogger(SpringMybatisTest.class);
	// private ApplicationContext ac = null;
	@Resource
	private EclipseMavenTestService eclipseMavenTestService = null;

	// @Before
	// public void before() {
	// ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	// userService = (IUserService) ac.getBean("userService");
	// }

	@Test
	public void test1() {
		EclipseMavenTest eclipseMavenTest = new EclipseMavenTest();
		eclipseMavenTest.setUsername("lixiong");
		eclipseMavenTest.setPassword("123");
		eclipseMavenTest.setName("李雄");
		int flag = eclipseMavenTestService.insert(eclipseMavenTest);
		
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
		logger.info("flag = "+flag);
		
	}
//	@Test
//	public void test2() {
//		User user = new User();
//		user = userService.selectByPrimaryKey((long) 1);
//		// System.out.println(user.getUserName());
//		// logger.info("值："+user.getUserName());
//		logger.info("user = "+user.toString());
//		
//	}
}
