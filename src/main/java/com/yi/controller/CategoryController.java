package com.yi.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yi.domain.BoardVO;
import com.yi.domain.CategoryVO;
import com.yi.domain.Criteria;
import com.yi.domain.LoginDTO;
import com.yi.domain.PageMaker;
import com.yi.domain.SearchCriteria;
import com.yi.domain.SubjectVO;
import com.yi.service.BoardService;
import com.yi.service.CategoryService;
import com.yi.service.SubjectService;
import com.yi.util.UploadUtils;

@Controller
@RequestMapping("/category/*")//이 컨트롤러 안에 모든 url커맨터 앞에 board가 자동으로 붙음
public class CategoryController {
	@Inject
	private BoardService board_service;
	
	@Inject
	private SubjectService sub_service;
	
	@Inject
	private CategoryService cate_service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	
	@RequestMapping(value="categoryList", method=RequestMethod.GET)
	public void list( Model model, String bUserId) {
		logger.info("list ----------- get");
		List<CategoryVO> list = cate_service.category_list(bUserId);
		
		
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value="categoryRegister", method=RequestMethod.GET)
	public void registerGet(SubjectVO svo, CategoryVO cvo, Model model, String bUserId) {
		logger.info("register ----------- get");
		List<SubjectVO> sub_list_c = sub_service.subject_list();
		List<CategoryVO> cate_list_c = cate_service.category_list(bUserId);
		model.addAttribute("sub_list_c", sub_list_c);
		model.addAttribute("cate_list_c", cate_list_c);
		logger.info(sub_list_c+"sub_list_c");
		logger.info(cate_list_c+"cate_list_c");
	}
	
	@RequestMapping(value="categoryRegister", method=RequestMethod.POST)
	public String registerPost(HttpServletRequest request,CategoryVO vo, Model model) throws IOException {
		logger.info("register ----------- post");
		
		cate_service.category_insert(vo);
		model.addAttribute("result", "success");
		
		return "redirect:/blogPage/blog?bUserId="+vo.getUserId()+"&perPageNum=5";
		
	}
	
	
	
	/*@RequestMapping(value="removeBoard", method=RequestMethod.POST)
	public String removePageS(@RequestParam("bno") int bno,SearchCriteria cri, Model model, String bUserId) {
		logger.info("removePageS ----------- post");
		service.remove(bno);
		model.addAttribute("cri", cri);
		
		return "redirect:/blogPage/blog?bUserId="+bUserId+"&page="+cri.getPage()+"&keyword="+cri.getKeyword()+"&searchType="+cri.getSearchType();
	}
	
	@RequestMapping(value="modifyPageS", method=RequestMethod.GET)
	public void modifyPageSGet(BoardVO vo, Model model) {
		logger.info("modifyPageS ----------- get");
		vo = service.read(vo.getBno());
		model.addAttribute("BoardVO", vo);
		
		
	}
	
	@RequestMapping(value="modifyPageS", method=RequestMethod.POST)
	public String modifyPageSPost(BoardVO vo,SearchCriteria cri, String[] delFiles ,List<MultipartFile> addFiles, Model model) throws IOException {
		logger.info("modifyPageS ----------- post");
		logger.info(vo+" ----------- post");
		if(delFiles != null) {
			
		
		
		for(String delFile : delFiles) {
			logger.info("success"+delFile);
			
			File file = new File(uploadPath + delFile);
			file.delete();
			
			String front = delFile.substring(0, 12);
			String end = delFile.substring(14);
			String originalFileName = front + end;
			File file2 = new File(uploadPath + originalFileName);
			file2.delete();
			}
		}
		
		
		List<String> addImages = new ArrayList<>();
		if(addFiles != null) {
			System.out.println(addFiles);
		for(MultipartFile file : addFiles) {
			logger.info("file name : "+file.getOriginalFilename());
			logger.info("file size : "+file.getSize());
			
			if(file.getSize() > 0) {
				String thumb = UploadUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				
				addImages.add(thumb);
			}
			
			
		}
		}
		
		service.modifyFile(vo, delFiles, addImages);
		model.addAttribute("result", "success");
		//model.addAttribute("cri", cri);
		model.addAttribute("keyword", cri.getKeyword());
		"&keyword="+cri.getKeyword()+
		
		return "redirect:/sboard/list?page="+cri.getPage()+"&searchType="+cri.getSearchType();
		
	}
	*/
	
}
