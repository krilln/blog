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
@RequestMapping("/board/*")//이 컨트롤러 안에 모든 url커맨터 앞에 board가 자동으로 붙음
public class BoardController {
	@Inject
	private BoardService service;
	
	@Inject
	private SubjectService sub_service;
	
	@Inject
	private CategoryService cate_service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void list(SearchCriteria cri, Model model, String bUserId) {
		logger.info("list ----------- get");
		logger.info(cri+"");
		List<BoardVO> list = service.listSearch(cri,bUserId);
		int total = service.searchTotalCount(cri,bUserId);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(total);
		
		
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("cri", cri);
	}
	
	@RequestMapping(value="boardRegister", method=RequestMethod.GET)
	public void registerGet(SubjectVO svo, CategoryVO cvo, Model model, String bUserId) {
		logger.info("register ----------- get");
		List<SubjectVO> sub_list = sub_service.subject_list();
		List<CategoryVO> cate_list = cate_service.category_list(bUserId);
		model.addAttribute("sub_list", sub_list);
		model.addAttribute("cate_list", cate_list);
		logger.info(sub_list+"sub_list");
		logger.info(cate_list+"cate_list");
	}
	
	@RequestMapping(value="boardRegister", method=RequestMethod.POST)
	public String registerPost(HttpServletRequest request,BoardVO vo, List<MultipartFile> imageFiles ,Model model) throws IOException {
		logger.info("register ----------- post");
		logger.info("content"+request.getParameter("content"));
		logger.info("title"+request.getParameter("title"));
		logger.info(vo.toString());
		try {
			System.out.println(imageFiles.size());
			if(imageFiles.size() > 0) {
				List<String> files = new ArrayList<>();
				for(MultipartFile file : imageFiles) {
					logger.info("file name : "+file.getOriginalFilename());
					logger.info("file size : "+file.getSize());
					
					String thumPath = UploadUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
					
					files.add(thumPath);
				}
				vo.setFiles(files);
			}
		
		
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		service.regist(vo);
		model.addAttribute("result", "success");
		
		return "redirect:/blogPage/blog?bUserId="+vo.getUserId();
		
	}
	
	@RequestMapping(value="read", method=RequestMethod.GET)
	public void readPage(@RequestParam("bno") int bno,Criteria cri , Model model) {
		logger.info("read ----------- get");
		BoardVO vo = service.read(bno);
		model.addAttribute("boardVO", vo);
		model.addAttribute("cri", cri);
		service.setViewcnt(vo);
	}
	
	
	@RequestMapping(value="removeBoard", method=RequestMethod.POST)
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
		/*"&keyword="+cri.getKeyword()+*/
		
		return "redirect:/sboard/list?page="+cri.getPage()+"&searchType="+cri.getSearchType();
		
	}
	
	
}
