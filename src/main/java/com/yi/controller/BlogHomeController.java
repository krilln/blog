package com.yi.controller;

import java.awt.Dialog.ModalExclusionType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yi.domain.BlogVO;
import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;
import com.yi.domain.PageMaker;
import com.yi.domain.SearchCriteria;
import com.yi.domain.UserVO;
import com.yi.service.BlogService;
import com.yi.service.UserService;


@Controller//컨트롤러로 인식시키기위해 필요
@RequestMapping("/blogHome/*")//이 컨트롤러 안에 모든 url커맨터 앞에 board가 자동으로 붙음
public class BlogHomeController {
	
	@Autowired
	private BlogService service;
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(BlogHomeController.class);
	
	
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void list(SearchCriteria cri, Model model, BlogVO vo, UserVO uvo) {
		logger.info("list ----------- get");
		logger.info(cri+"");
		List<BlogVO> list = service.listSearch(cri);
		logger.info(vo.getbUserId()+"");
		logger.info(list+"");
		UserVO U_list = userService.readUser(vo.getbUserId());
		logger.info(U_list+"");
		int total = service.searchTotalCount(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(total);
		
		
		model.addAttribute("U_list", U_list);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("cri", cri);
	}
	
	/*@RequestMapping(value="registerS", method=RequestMethod.GET)
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
		
		return "redirect:/sboard/list";
		
	}
	
	@RequestMapping(value="readPageS", method=RequestMethod.GET)
	public void readPageS(@RequestParam("bno") int bno,SearchCriteria cri , Model model) {
		logger.info("readPageS ----------- get");
		BoardVO vo = service.read(bno);
		model.addAttribute("boardVO", vo);
		model.addAttribute("cri", cri);
		service.setViewcnt(vo);
	}
	
	@RequestMapping(value="removePageS", method=RequestMethod.POST)
	public String removePageS(@RequestParam("bno") int bno,SearchCriteria cri, Model model) {
		logger.info("removePageS ----------- post");
		service.remove(bno);
		model.addAttribute("cri", cri);
		
		return "redirect:/sboard/list?page="+cri.getPage()+"&keyword="+cri.getKeyword()+"&searchType="+cri.getSearchType();
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
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ResponseEntity<String> getDelete(String filename){
		ResponseEntity<String> entity = null;
		
		try {
			File file = new File(uploadPath + filename);
			file.delete();
			
			String front = filename.substring(0, 12);
			String end = filename.substring(14);
			String originalFileName = front + end;
			File file2 = new File(uploadPath + originalFileName);
			file2.delete();
			
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}*/
	
}
