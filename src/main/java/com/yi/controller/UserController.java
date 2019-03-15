package com.yi.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yi.domain.AdminCheckVO;
import com.yi.domain.UserVO;
import com.yi.service.UserService;
import com.yi.util.MediaUtils;
import com.yi.util.UploadProfileUtils;
import com.yi.util.UploadUtils;



@Controller//컨트롤러로 인식시키기위해 필요
@RequestMapping("/user/*")//이 컨트롤러 안에 모든 url커맨터 앞에 board가 자동으로 붙음
public class UserController {
	@Autowired
	private UserService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public void registerGet(AdminCheckVO Avo, Model model) {
		AdminCheckVO ac = service.adminPw();
		model.addAttribute("ac",ac);
	}
	
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String register(UserVO vo, MultipartFile imageFiles ,Model model){
		logger.info("user insert ---------------" + vo);
		
		try {
			System.out.println(imageFiles.getSize());
			if(imageFiles.getSize() != 0) {
				logger.info("file name : "+imageFiles.getOriginalFilename());
				logger.info("file size : "+imageFiles.getSize());
				
				String thumPath = UploadProfileUtils.uploadFile(uploadPath, imageFiles.getOriginalFilename(), imageFiles.getBytes());
				
				
			
				vo.setProfileImage(thumPath);
			}
			
				
			
			service.insertUser(vo);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return "redirect:/blogHome/list";
		
	}
	
	
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String filename){
		ResponseEntity<byte[]> entity = null;
		logger.info("displayFile : " + filename);
		
		try {
			String format = filename.substring(filename.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(format);
			
			HttpHeaders headers = new HttpHeaders();
			InputStream in = null;
			in = new FileInputStream(uploadPath + "/" + filename);
			headers.setContentType(mType);
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			in.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	 @ResponseBody
	   @RequestMapping(value="/dul", method=RequestMethod.POST)
	   public ResponseEntity<String> dulRead(@RequestBody String du, Model model){
	      ResponseEntity<String> entity = null;
	      logger.info("member read ---------" + du);
	      
	      try {
	         boolean dul = service.dulUserId(du);
	         System.out.println("dul은"+ dul);
	         System.out.println("du는" + du);
	         if(dul == true) {
	            entity = new ResponseEntity<>("true",HttpStatus.OK);
	         }else {
	            entity = new ResponseEntity<String>("false", HttpStatus.OK);
	         }
	         
	         System.out.println("entity는"+ entity);
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	         entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	      }
	      return entity;
	   }
}
