package com.follow.model;

import java.sql.Date;
import java.util.List;


public class FollowService {
	private static final String String = null;
	private FollowDAO_Interface dao;

	public FollowService() {
		dao = new FollowDAO();
	}

	public FollowVO insertFollow(String mebIdA, String mebIdB) {

		FollowVO followVO = new FollowVO();
		followVO.setMebIdA(mebIdA);
		followVO.setMebIdB(mebIdB);
		
		dao.insert(followVO);

		return followVO;
	}
	
	 public void deleteFollow(String mebIdA, String mebIdB) {
		 dao.delete(mebIdA, mebIdB);
	 }

	public FollowVO getOneFollow(String advId) {
		return dao.findByPrimaryKey(advId);
	}
	

	public List<FollowVO> getAll() {
		return dao.getAll();
	}

	public List<FollowVO> getOneFollowAll(String mem_id) {
		return dao.getOneFollowAll(mem_id);
	}
	
	public List<FollowVO> getOneFollowedAll(String mem_id) {
		return dao.getOneFollowedAll(mem_id);
	}	

}
