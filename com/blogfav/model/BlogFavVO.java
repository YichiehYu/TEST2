package com.blogfav.model;

import java.io.Serializable;

public class BlogFavVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String mebId;
	private String blogId;
	private byte[] blogPic;
	
	public BlogFavVO() {
		super();
	}
	
	public BlogFavVO(String mebId, String blogId) {
		super();
		this.mebId = mebId;
		this.blogId = blogId;
	}
	
	public String getMebId() {
		return mebId;
	}
	public void setMebId(String mebId) {
		this.mebId = mebId;
	}
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	public byte[] getBlogPic() {
		return blogPic;
	}
	public void setBlogPic(byte[] blogPic) {
		this.blogPic = blogPic;
	}
}
