
package com.member.model;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.emp.model.EmpVO;
import com.follow.model.FollowVO;

public interface MemberDAO_Interface {
    public void insert(MemberVO memberVO);
    public void update(MemberVO memberVO);
    public MemberVO findByPrimaryKey(String advId);
    public MemberVO findByEmail(String email);
    public byte[] findPicByMebId(String mebId);
    public InputStream findPicByMebId1(String mebId);
    public List<MemberVO> getAll();
	void Insert(MemberVO memberVO);
	public List<MemberVO> getOneMember(String mebId);
	List<MemberVO> getOneMemberAll(String mem_id);
	 public List<MemberVO> getAll(Map<String, String[]> map);
	  public List<MemberVO> getAllNoMe(String mebId);

}