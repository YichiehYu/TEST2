package com.groupfav.model;

import java.util.List;

import com.blogfav.model.BlogFavVO;

public interface GroupFavDAO_Interface {
    public void insert(GroupFavVO groupFavVO);
    public void delete(GroupFavVO groupFavVO);
    public boolean check(GroupFavVO groupFavVO);
    public List<String> findByMebId(String mebId);
    public Integer getFavNumber(String groupId);
    public List<GroupFavVO> getOneGroupFavAll(String mem_id);
    
    List<GroupFavVO> getOneGroupFav(String mebId);
	List<GroupFavVO> getOneGroupFavAll();
	void delete(String mebId, String groupId);
	public GroupFavVO findByPrimaryKey(String mebId);
	List<GroupFavVO> getAll();
	
}
