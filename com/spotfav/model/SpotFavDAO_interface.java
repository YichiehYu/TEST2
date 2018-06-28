package com.spotfav.model;

import java.util.List;

import com.blogfav.model.BlogFavVO;
import com.follow.model.FollowVO;

public interface SpotFavDAO_interface {
	public void insert(SpotFavVO spotFavVO);
	public void delete(String mebId, String spotId);
	public List<SpotFavVO> getAll();
	public List<SpotFavVO> getByMeb(String mebId);
	public List<SpotFavVO> getBySpot(String spotId);
	public boolean getByMebSpot(String spotId, String mebId);
	SpotFavVO findByPrimaryKey(String mebId);
	public List<SpotFavVO> getOneSpotFavAll(String mem_id);

}
