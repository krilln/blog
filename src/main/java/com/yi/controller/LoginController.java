package com.yi.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yi.domain.BlogVO;
import com.yi.domain.LoginDTO;
import com.yi.domain.UserVO;
import com.yi.service.BlogService;
import com.yi.service.UserService;
@Controller//컨트롤러로 인식시키기위해 필요
@RequestMapping("/login/*")//이 컨트롤러 안에 모든 url커맨터 앞에 board가 자동으로 붙음
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService service;
	@Autowired
	private BlogService b_service;
	
	/*@RequestMapping(value="login", method=RequestMethod.GET)
	public void loginGet(){
		
		logger.info("login get ---------------");
		
	}*/
	
	
	@RequestMapping(value="loginPost", method=RequestMethod.POST)
	public void loginPost(String userId, String password, Model model) {
		logger.info("login post ---------------");
		UserVO vo = service.read(userId, password);
		
		if(vo == null) {
			logger.info("loginPost return ---------------");
			return;
		}
		LoginDTO dto = new LoginDTO();
		dto.setUserId(vo.getUserId());
		dto.setNickname(vo.getNickname());
		
		BlogVO blog_ck = b_service.readBlog(vo.getUserId());
		
		if(blog_ck != null) {
			dto.setBlogCheck(true);
		}else {
			dto.setBlogCheck(false);
		}
		
		
		model.addAttribute("loginDTO", dto);
		
		
	}
	
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logoutGET(HttpSession session) {
		logger.info("logout GET ---------------");
		session.invalidate();
		
		return "redirect:/blogHome/list";
	}
}
