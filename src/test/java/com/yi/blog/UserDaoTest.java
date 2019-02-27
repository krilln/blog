package com.yi.blog;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.UserVO;
import com.yi.persistence.UserDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoTest {
	@Autowired
	private UserDao dao;
	
	@Test
	public void test01Insert() {
		UserVO vo = new UserVO();
		vo.setUserId("user001");
		vo.setName("박춘배");
		vo.setNickname("행보관");
		vo.setPassword("1234");
		vo.setEmail("hoho@naver.com");
		vo.setBirthday("1902-03-17");
		vo.setGender(true);
		vo.setPhone("010-3333-4444");
		vo.setAdmin(true);
		
		dao.insertUser(vo);
	}
}
