package com.blogfav.model;

import java.util.List;

import com.follow.model.FollowVO;

public interface BlogFavDAO_interface {
    public void insert(BlogFavVO blogFavVO);
    public void delete(String mebId, String blogId);
    public BlogFavVO findByPrimaryKey(String mebId);
    public List<BlogFavVO> getAll();
    public List<BlogFavVO> getOneBlogFavAll(String mem_id);
    List<BlogFavVO> getOneBlogFav(String mebId);
	List<BlogFavVO> getOneBlogFavAll();
    public byte[] findPicByMebId(String mebId);
	
}
