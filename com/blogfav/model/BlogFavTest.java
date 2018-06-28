package com.blogfav.model;

import java.util.List;

public class BlogFavTest {
	public static void main(String[] args) {
		BlogFavDAO blogFavDAO = new BlogFavDAO();
		BlogFavVO blogFavVO = new BlogFavVO();
		blogFavVO.setMebId("M00019");
		blogFavVO.setBlogId("B00005");
//		blogFavDAO.insert(blogFavVO);
		
//		BlogFavVO blogFavVO = blogFavDAO.findByPrimaryKey("M00019");
//		System.out.println(blogFavVO.getMebId());
//		System.out.println(blogFavVO.getBlogId());
		
//		List<BlogFavVO> list = blogFavDAO.getAll();
//		for(BlogFavVO blogFavVO : list){
//			System.out.println(blogFavVO.getMebId());
//			System.out.println(blogFavVO.getBlogId());
//			System.out.println("========================");
//		}
		
//		blogFavDAO.delete("M00019", "B00005");
		
		BlogFavService blogFavService = new BlogFavService();
//		blogFavService.addBlogFav("M00023", "B00014");
		
//		BlogFavVO blogFavVO = blogFavService.getOneBlogFav("M00023");
//		System.out.println("會員編號:"+blogFavVO.getMebId());
//		System.out.println("部落格編號:"+blogFavVO.getBlogId());
		
//		List<BlogFavVO> list = blogFavService.getAll();
//		for(BlogFavVO blogFavVO : list){
//			System.out.println("會員編號:"+blogFavVO.getMebId());
//			System.out.println("部落格編號:"+blogFavVO.getBlogId());
//			System.out.println("===================");
//		}
		
//		blogFavService.deleteBlogFav("M00023", "B00014");
	}
}
