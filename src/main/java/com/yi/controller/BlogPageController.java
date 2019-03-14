package com.yi.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yi.domain.BlogVO;
import com.yi.domain.BoardVO;
import com.yi.domain.CategoryVO;
import com.yi.domain.Criteria;
import com.yi.domain.PageMaker;
import com.yi.domain.ReplyVO;
import com.yi.domain.SearchCriteria;
import com.yi.domain.UserVO;
import com.yi.service.BlogService;
import com.yi.service.BoardService;
import com.yi.service.CategoryService;
import com.yi.service.UserService;
import com.yi.util.MediaUtils;

@Controller
@RequestMapping("/blogPage/*")
public class BlogPageController {
	@Inject
	private BoardService board_service;
	
	@Inject
	private UserService user_service;
	
	@Inject
	private CategoryService cate_service;
	
	@Inject
	private BlogService blog_service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	private static final Logger logger = LoggerFactory.getLogger(BlogPageController.class);
	
	@RequestMapping(value="blog", method=RequestMethod.GET)
	public void registerGet(SearchCriteria cri, String bUserId,  Model model,@RequestParam(name="bno", defaultValue="0")int bno) {
		logger.info("blog ----------- get");
		logger.info(bUserId+" bid");
		logger.info(bno+" bno");
		
		
			UserVO user_info = user_service.readUser(bUserId);
			logger.info(user_info+" user_info");
			model.addAttribute("user_info",user_info);
			
			BlogVO blog_info = blog_service.readBlog(bUserId);
			logger.info(blog_info+" blog_info");
			model.addAttribute("blog_info",blog_info);
			
			List<BoardVO> board_list = board_service.listAll(bUserId);
			logger.info(board_list+" board_list");
			model.addAttribute("board_list",board_list);
			
			List<CategoryVO> cate_list = cate_service.category_list(bUserId);
			logger.info(cate_list+"cate_list");
			model.addAttribute("cate_list", cate_list);
			
			//페이징
			List<BoardVO> list = board_service.listSearch(cri,bUserId);
			logger.info("list :"+list);
			int total = board_service.searchTotalCount(cri,bUserId);
			BoardVO read_bvo;
			if(bno == 0) {
				read_bvo = board_service.read(board_list.get(0).getBno());
			}else {
				read_bvo = board_service.read(bno);
			}
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(total);
			
			
			model.addAttribute("list", list);
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("cri", cri);
			model.addAttribute("bUserId",bUserId);
			model.addAttribute("read_bvo", read_bvo);
			model.addAttribute("bno",bno);
			model.addAttribute("total",total);
		
		
	}
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String filename){
		ResponseEntity<byte[]> entity = null;
		logger.info("displayFile : " + filename);
		
		try {
			String format = filename.substring(filename.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(format);
			/*String FileDate = filename.substring(0,12);
			String OriFile = filename.substring(filename.indexOf("_") + 1);*/
			
			HttpHeaders headers = new HttpHeaders();
			InputStream in = null;
			/*logger.info("displayFile : " + FileDate+OriFile);*/
			in = new FileInputStream(uploadPath + filename);
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
	
	
	
}
