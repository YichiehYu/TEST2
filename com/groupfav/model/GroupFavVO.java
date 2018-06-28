package com.groupfav.model;

import java.io.Serializable;

public class GroupFavVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String mebId;
	private String groupId;
	
	
	public String getMebId() {
		return mebId;
	}


	public void setMebId(String mebId) {
		this.mebId = mebId;
	}

	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public GroupFavVO() {
		super();
	}
	public GroupFavVO(String mebId,String groupId) {
		super();
		this.mebId = mebId;
		this.groupId = groupId;
	}
}
