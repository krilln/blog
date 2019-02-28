package com.yi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.yi.domain.BoardVO;
import com.yi.domain.PageMaker;
import com.yi.domain.SearchCriteria;
import com.yi.service.BoardService;
import com.yi.util.UploadUtils;

@Controller
@RequestMapping("/board/*")//이 컨트롤러 안에 모든 url커맨터 앞에 board가 자동으로 붙음
public class BoardController {
	@Inject
	private BoardService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void list(SearchCriteria cri, Model model) {
		logger.info("list ----------- get");
		logger.info(cri+"");
		List<BoardVO> list = service.listSearch(cri);
		int total = service.searchTotalCount(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(total);
		
		
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("cri", cri);
	}
	
	@RequestMapping(value="registerS", method=RequestMethod.GET)
	public void registerGet() {
		logger.info("register ----------- get");
		
	}
	
	@RequestMapping(value="registerS", method=RequestMethod.POST)
	public String registerPost(BoardVO vo, List<MultipartFile> imageFiles ,Model model) throws IOException {
		logger.info("register ----------- post");
		logger.info(vo.toString());
		
		List<String> files = new ArrayList<>();
		for(MultipartFile file : imageFiles) {
			logger.info("file name : "+file.getOriginalFilename());
			logger.info("file size : "+file.getSize());
			
			String thumPath = UploadUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			
			files.add(thumPath);
		}
		vo.setFiles(files);
		
		service.regist(vo);
		model.addAttribute("result", "success");
		
		return "redirect:/board/list";
		
	}
}
