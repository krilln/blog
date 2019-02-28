package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;
import com.yi.domain.SearchCriteria;
import com.yi.persistence.BoardDao;
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao dao;
	
	@Override
	@Transactional
	public void regist(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
		
		List<String> files = vo.getFiles();
		
		if(files == null || files.size() == 0) 
			return;
			
			for(String fullname : files) {
				dao.addAttach(fullname);
			}
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)//읽기만 가능
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		BoardVO vo = dao.read(bno);
		vo.setFiles(dao.getAttach(bno));
		return vo;
	}

	@Override
	public void modify(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	@Transactional
	public void modifyFile(BoardVO vo, String[] delFiles, List<String> addImages) {
		// TODO Auto-generated method stub
		if(delFiles != null) {
			for(String file:delFiles) {
				dao.deleteAttachByFullName(vo.getBno(), file);
				}
			}
			for(String file : addImages) {
				dao.addAttachByBno(file, vo.getBno());
			}
			
			dao.update(vo);
	}

	@Override
	@Transactional
	public void remove(int bno) {
		// TODO Auto-generated method stub
		dao.delAttach(bno);
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public void setViewcnt(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.setVcnt(vo);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return dao.totalCount();
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.listSearch(cri);
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.searchTotalCount(cri);
	}

}
