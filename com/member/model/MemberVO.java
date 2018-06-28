
package com.member.model;

import java.io.Serializable;
import java.sql.Date;

public class MemberVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String mebId;
	private String email;
	private String mebPass;
	private String mebName;
	private Integer gender;
	private String tel;
	private Date birthday;
	private String intro;
	private Integer reported;
	private Integer mebStatus;
	private byte[] mebPortrait;
	public MemberVO() {
		super();
	}
	public MemberVO(String mebId, String email, String mebPass, String mebName, Integer gender, String tel,
			Date birthday, String intro, Integer reported, Integer mebStatus, byte[] mebPortrait) {
		super();
		this.mebId = mebId;
		this.email = email;
		this.mebPass = mebPass;
		this.mebName = mebName;
		this.gender = gender;
		this.tel = tel;
		this.birthday = birthday;
		this.intro = intro;
		this.reported = reported;
		this.mebStatus = mebStatus;
		this.mebPortrait = mebPortrait;
	}
	public String getMebId() {
		return mebId;
	}
	public void setMebId(String mebId) {
		this.mebId = mebId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMebPass() {
		return mebPass;
	}
	public void setMebPass(String mebPass) {
		this.mebPass = mebPass;
	}
	public String getMebName() {
		return mebName;
	}
	public void setMebName(String mebName) {
		this.mebName = mebName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Integer getReported() {
		return reported;
	}
	public void setReported(Integer reported) {
		this.reported = reported;
	}
	public Integer getMebStatus() {
		return mebStatus;
	}
	public void setMebStatus(Integer mebStatus) {
		this.mebStatus = mebStatus;
	}
	public byte[] getMebPortrait() {
		return mebPortrait;
	}
	public void setMebPortrait(byte[] mebPortrait) {
		this.mebPortrait = mebPortrait;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}