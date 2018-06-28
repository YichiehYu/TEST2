package com.blogfav.model;

import java.util.List;

import com.follow.model.FollowVO;

public class BlogFavService {
	private BlogFavDAO_interface dao;

	public BlogFavService() {
		dao = new BlogFavDAO();
	}

	public BlogFavVO addBlogFav(String mebId, String blogId) {

		BlogFavVO blogFavVO = new BlogFavVO();
		blogFavVO.setMebId(mebId);
		blogFavVO.setBlogId(blogId);
		
		dao.insert(blogFavVO);

		return blogFavVO;
	}
	
	public void deleteBlogFav(String mebId, String blogId) {

		dao.delete(mebId, blogId);

	}

	public BlogFavVO getOneBlogFav(String mebId) {
		return dao.findByPrimaryKey(mebId);
	}

	public List<BlogFavVO> getAll() {
		return dao.getAll();
	}
	
	public byte[] getOneBlogFavPic(String mebId){
		return dao.findPicByMebId(mebId);
	}
	
	public List<BlogFavVO> getOneBlogFavAll(String mebId) {
		return dao.getOneBlogFavAll(mebId);
	}
}
