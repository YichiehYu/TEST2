package com.spotfav.model;

import java.util.List;

import com.follow.model.FollowVO;

public class SpotFavService {
	private SpotFavDAO_interface dao;

	public SpotFavService() {
		dao = new SpotFavDAO();
	}
	
	public SpotFavVO addSpotFav(String mebId, String spotId) {
		
		SpotFavVO spotFavVO = new SpotFavVO();
		spotFavVO.setMebId(mebId);
		spotFavVO.setSpotId(spotId);
		dao.insert(spotFavVO);
		
		return spotFavVO;
	}
	
	
	public void deleteSpotFav(String mebId, String spotId) {
		dao.delete(mebId, spotId);
	}
	
	public List<SpotFavVO> getAll(){
		return dao.getAll();
	}
	
	public List<SpotFavVO> getByMeb(String mebId){
		return dao.getByMeb(mebId);
	}
	
	public List<SpotFavVO> getBySpot(String spotId){
		return dao.getBySpot(spotId);
	}
	
	public boolean getByMebSpot(String spotId, String mebId){
		return dao.getByMebSpot(spotId, mebId);
	}



	public List<SpotFavVO> getOneSpotFavAll(String mem_id) {
		return dao.getOneSpotFavAll(mem_id);
	}
	
	public SpotFavVO getOneSpotFav(String advId) {
		return dao.findByPrimaryKey(advId);
	}
	
}