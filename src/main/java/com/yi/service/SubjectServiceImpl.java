package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.SubjectVO;
import com.yi.persistence.SubjectDao;
@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDao dao;
	
	@Override
	public List<SubjectVO> subject_list() {
		// TODO Auto-generated method stub
		return dao.subject_list();
	}

}
