package com.member.model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.comewithme.TransTool;

public class MemberTest {
	public static void main(String[] args) throws IOException {
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		memberVO.setEmail("yyy@gmail.com");
		memberVO.setMebPass("123456");
		memberVO.setMebName("JDBC");
		memberVO.setGender(0);
		memberVO.setTel("0920120611");
		
	 	Calendar gc= new GregorianCalendar(1995,Calendar.JANUARY,21);
		java.util.Date uDate = gc.getTime();
		Date date = new Date(uDate.getTime()); 
		memberVO.setBirthday(date);
		
		memberVO.setIntro("123");
		memberVO.setReported(0);
		memberVO.setMebStatus(0);
//		
		InputStream is = new FileInputStream(new File("C:/Users/yichien/Downloads/1.jpg"));
		byte[] pic = new byte[is.available()];
		is.read(pic);
		memberVO.setMebPortrait(pic);
		memberDAO.insert(memberVO);
		
//		MemberVO memberVO = memberDAO.findByPrimaryKey("M00021");
//		System.out.println(memberVO.getEmail());
//		System.out.println(memberVO.getMebPass());
//		System.out.println(memberVO.getMebName());
//		System.out.println(memberVO.getGender());
//		System.out.println(memberVO.getTel());
//		System.out.println(memberVO.getBirthday());
//		System.out.println(memberVO.getIntro());
//		System.out.println(memberVO.getReported());
//		System.out.println(memberVO.getMebStatus());
		
//		memberVO.setEmail(memberVO.getEmail());
//		memberVO.setMebPass(memberVO.getMebPass());
//		memberVO.setMebName("小C");
//		memberVO.setGender(memberVO.getGender());
//		memberVO.setTel(memberVO.getTel());
//		memberVO.setBirthday(memberVO.getBirthday());
//		memberVO.setIntro(memberVO.getIntro());
//		memberVO.setReported(memberVO.getReported());
//		memberVO.setMebStatus(memberVO.getMebStatus());
//		
//		memberDAO.update(memberVO);
		
//		List<MemberVO> list = memberDAO.getAll();
//		for(MemberVO meb : list){
//			System.out.println("Email:"+meb.getEmail());
//			System.out.println("密碼:"+meb.getMebPass());
//			System.out.println("姓名:"+meb.getMebName());
//			System.out.println("性別:"+TransTool.gender(meb.getGender()));
//			System.out.println("電話:"+meb.getTel());
//			System.out.println("生日:"+meb.getBirthday());
//			System.out.println("自我介紹:"+meb.getIntro());
//			System.out.println("被檢舉次數:"+meb.getReported());
//			System.out.println("會員狀態:"+TransTool.mebStatus(meb.getMebStatus()));
//			System.out.println("==================================");
//		}
		
//		MemberService memberService = new MemberService();
//		java.sql.Date date = java.sql.Date.valueOf("1995-01-21");
//		InputStream ip = new FileInputStream(new File("/img/newCat3.png"));
//		byte[] buffer = new byte[ip.available()];
//		ip.read(buffer);
//		memberService.updateMember("M00022","1984@gmail.com", "8899562", "花花", 1, "0966552314", date, "我是小B", 0, 1, buffer);
		
//		Calendar gc = new GregorianCalendar(1995,Calendar.JANUARY,21);
//		java.util.Date uDate = gc.getTime();
//		Date date = new Date(uDate.getTime()); 
//		memberService.addMember("124578@gmail.com", "88995", "小B", 1, "0966552314", date, 0, 0, buffer);
//		
//		MemberVO memberVO = memberService.getOneMember("M00005");
//		System.out.println("Email:"+memberVO.getEmail());
//		System.out.println("密碼:"+memberVO.getMebPass());
//		System.out.println("姓名:"+memberVO.getMebName());
//		System.out.println("性別:"+TransTool.gender(memberVO.getGender()));
//		System.out.println("電話:"+memberVO.getTel());
//		System.out.println("生日:"+memberVO.getBirthday());
//		System.out.println("自我介紹:"+memberVO.getIntro());
//		System.out.println("被檢舉次數:"+memberVO.getReported());
//		System.out.println("會員狀態:"+TransTool.mebStatus(memberVO.getMebStatus()));
		
//		MemberVO memberVO = memberService.getOneMemberByEmail("159159@gmail.com");
//		System.out.println("會員編號:"+memberVO.getMebId());
//		System.out.println("Email:"+memberVO.getEmail());
//		System.out.println("密碼:"+memberVO.getMebPass());
//		System.out.println("姓名:"+memberVO.getMebName());
//		System.out.println("照片:"+memberVO.getMebPortrait());
		
//		List<MemberVO> list = memberService.getAll();
//		for(MemberVO meb : list){
//			System.out.println("Email:"+meb.getEmail());
//			System.out.println("密碼:"+meb.getMebPass());
//			System.out.println("姓名:"+meb.getMebName());
//			System.out.println("性別:"+TransTool.gender(meb.getGender()));
//			System.out.println("電話:"+meb.getTel());
//			System.out.println("生日:"+meb.getBirthday());
//			System.out.println("自我介紹:"+meb.getIntro());
//			System.out.println("被檢舉次數:"+meb.getReported());
//			System.out.println("會員狀態:"+TransTool.mebStatus(meb.getMebStatus()));
//			System.out.println("==================================");
//		}
		
//		System.out.println(memberService.getOneMemberPic("M00022"));
	}
}
