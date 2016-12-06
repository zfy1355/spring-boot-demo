package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import project.Application;
import project.dto.User;
import project.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class JdbcTest {
		@Autowired
		private UserService userSerivce;

		@Before
		public void setUp() {
			// 准备，清空user表
			userSerivce.deleteAllUsers();
		}

		@Test
		public void test() throws Exception {
			// 插入5个用户
			userSerivce.create( new User("a", 1));
			userSerivce.create( new User("b", 2));
			userSerivce.create( new User("c", 3));
			userSerivce.create( new User("d", 4));
			userSerivce.create( new User("e", 5));

			// 查数据库，应该有5个用户
			Assert.assertEquals(5, userSerivce.getAllUsers().size());

			// 删除两个用户
			userSerivce.deleteByName("a");
			userSerivce.deleteByName("e");

			// 查数据库，应该有5个用户
			Assert.assertEquals(3, userSerivce.getAllUsers().size());

		}


	}
