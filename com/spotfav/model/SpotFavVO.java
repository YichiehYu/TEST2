package com.spotfav.model;

import java.io.Serializable;

public class SpotFavVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String mebId;
	private String spotId;
	
	public SpotFavVO() {
		super();
	}

	public SpotFavVO(String mebId, String spotId) {
		super();
		this.mebId = mebId;
		this.spotId = spotId;
	}

	public String getMebId() {
		return mebId;
	}

	public void setMebId(String mebId) {
		this.mebId = mebId;
	}

	public String getSpotId() {
		return spotId;
	}

	public void setSpotId(String spotId) {
		this.spotId = spotId;
	}
}
