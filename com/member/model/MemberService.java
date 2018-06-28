
package com.member.model;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.emp.model.EmpVO;

public class MemberService {
	private MemberDAO_Interface dao;

	public MemberService() {
		dao = new MemberDAO();
	}

	public MemberVO addMember(String email, String mebpass, String mebName,
			Integer gender, String tel, Date birthday, Integer reported, Integer mebStatus, byte[] mebPortrait) {

		MemberVO memberVO = new MemberVO();
		memberVO.setEmail(email);
		memberVO.setMebPass(mebpass);
		memberVO.setMebName(mebName);
		memberVO.setGender(gender);
		memberVO.setTel(tel);
		memberVO.setBirthday(birthday);
		memberVO.setReported(reported);
		memberVO.setMebStatus(mebStatus);
		memberVO.setMebPortrait(mebPortrait);
		
		dao.insert(memberVO);

		return memberVO;
	}

	public MemberVO updateMember(String mebId, String email, String mebpass, String mebName,
			Integer gender, String tel, Date birthday, String intro, Integer reported, Integer mebStatus, byte[] mebPortrait) {

		MemberVO memberVO = new MemberVO();
		memberVO.setMebId(mebId);
		memberVO.setEmail(email);
		memberVO.setMebPass(mebpass);
		memberVO.setMebName(mebName);
		memberVO.setGender(gender);
		memberVO.setTel(tel);
		memberVO.setBirthday(birthday);
		memberVO.setIntro(intro);
		memberVO.setReported(reported);
		memberVO.setMebStatus(mebStatus);
		memberVO.setMebPortrait(mebPortrait);
		
		dao.update(memberVO);

		return memberVO;
	}

	public MemberVO getOneMember(String mebId) {
		return dao.findByPrimaryKey(mebId);
	}
	
	public MemberVO getOneMemberByEmail(String email) {
		return dao.findByEmail(email);
	}
	
	public byte[] getOneMemberPic(String mebeId){
		return dao.findPicByMebId(mebeId);
	}
	
	public InputStream getOneMemberPic1(String mebId){
		return dao.findPicByMebId1(mebId);
	}

	public List<MemberVO> getAll() {
		return dao.getAll();
	}

	public List<MemberVO> getAll(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}


	}
