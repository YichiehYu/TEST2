package com.follow.model;

import java.util.List;




public interface FollowDAO_Interface {
  
	public void insert(FollowVO followVO);
    public void delete(String mebIdA, String mebIdB);
    public FollowVO findByPrimaryKey(String advId);
    public List<FollowVO> getAll();
    public List<FollowVO> getOneFollowAll(String mem_id);
    public List<FollowVO> getOneFollowedAll(String mem_id);
	List<FollowVO> getOneFollow(String mebId);

   
}
