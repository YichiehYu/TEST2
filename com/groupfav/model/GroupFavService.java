package com.groupfav.model;

import java.util.List;

import com.blogfav.model.BlogFavVO;
import com.follow.model.FollowVO;

public class GroupFavService {
	private GroupFavDAO_Interface dao;

	public GroupFavService() {
		dao = new GroupFavDAO();
	}
	
	public List<String> findByMebId(String mebId){
		return dao.findByMebId(mebId);
	}


	public List<GroupFavVO> getOneGroupFavAll(String mem_id) {
		return dao.getOneGroupFavAll(mem_id);
	}
	


	
		
	
}
