package com.follow.model;

import java.io.Serializable;

public class FollowVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String mebIdA;
	private String mebIdB;

	public FollowVO() {
		super();
	}

	public FollowVO(String mebIdA, String mebIdB) {
		super();
		this.mebIdA = mebIdA;
		this.mebIdB = mebIdB;
	}

	public String getMebIdA() {
		return mebIdA;
	}
		
	public void setMebIdA(String mebIdA) {
		this.mebIdA = mebIdA;
	}
	public String getMebIdB() {
		return mebIdB;
	}
		
	public void setMebIdB(String mebIdB) {
		this.mebIdB = mebIdB;
	}


	}

