package com.yi.persistence;

import java.util.List;

import com.yi.domain.Criteria;
import com.yi.domain.ReplyVO;

public interface ReplyDao {
	public List<ReplyVO> list(int bno);
	public void create(ReplyVO vo);
	public void update(ReplyVO vo);
	public void delete(int bno);
	public List<ReplyVO> listPage(Criteria cri, int bno);
	public int totalCount(int bno);
	public ReplyVO selectByBno(int rno);
}
