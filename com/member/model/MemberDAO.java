
package com.member.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.comewithme.TransTool;

public class MemberDAO implements MemberDAO_Interface {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "CA101_G4";
	private static final String PASSWORD = "CA101_G4";
	private static final String INSERT_STMT = "INSERT INTO MEMBER (MEB_ID,EMAIL,MEB_PASS,MEB_NAME,GENDER,TEL,BIRTHDAY,INTRO,REPORTED,MEB_STATUS,MEB_PORTRAIT) VALUES ('M'||TO_CHAR(SEQ_MEB_ID.NEXTVAL,'FM00000'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT MEB_ID,EMAIL,MEB_PASS,MEB_NAME,GENDER,TEL,to_char(BIRTHDAY,'yyyy-mm-dd')BIRTHDAY,INTRO,REPORTED,MEB_STATUS,MEB_PORTRAIT FROM MEMBER where MEB_STATUS = 1 order by MEB_ID";
	private static final String GET_ONE_STMT = "SELECT MEB_ID,EMAIL,MEB_PASS,MEB_NAME,GENDER,TEL,to_char(BIRTHDAY,'yyyy-mm-dd')BIRTHDAY,INTRO,REPORTED,MEB_STATUS,MEB_PORTRAIT FROM MEMBER where MEB_ID = ? AND MEB_STATUS <> 2";
	private static final String GET_EMAIL_STMT = "SELECT MEB_ID,EMAIL,MEB_PASS,MEB_NAME FROM MEMBER where EMAIL = ?";
	private static final String GET_PIC_STMT = "SELECT MEB_PORTRAIT FROM MEMBER where MEB_ID = ?";
	private static final String UPDATE = "UPDATE MEMBER set EMAIL=?, MEB_PASS=?, MEB_NAME=? ,GENDER=? ,TEL=? ,BIRTHDAY=? ,INTRO=? ,REPORTED=? ,MEB_STATUS=? ,MEB_PORTRAIT=? where MEB_ID = ?";
	private static final String DELETE_STMT = null;
	private static final String GET_ALL_NO_ME = 
			"SELECT MEB_ID,EMAIL,MEB_PASS,MEB_NAME,GENDER,TEL,to_char(BIRTHDAY,'yyyy-mm-dd')BIRTHDAY,INTRO,REPORTED,MEB_STATUS,MEB_PORTRAIT FROM MEMBER where MEB_STATUS = 1 AND MEB_ID <> ? order by MEB_ID";

	@Override
	public void insert(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memberVO.getEmail());
			pstmt.setString(2, memberVO.getMebPass());
			pstmt.setString(3, memberVO.getMebName());
			pstmt.setInt(4, memberVO.getGender());
			pstmt.setString(5, memberVO.getTel());
			pstmt.setDate(6, memberVO.getBirthday());
			pstmt.setString(7, memberVO.getIntro());
			pstmt.setInt(8, memberVO.getReported());
			pstmt.setInt(9, memberVO.getMebStatus());
			pstmt.setBytes(10, memberVO.getMebPortrait());

			pstmt.executeUpdate();
		} catch (ClassNotFoundException ce) {
			throw new RuntimeException("Couldn't load database driver. " + ce.getMessage());

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured" + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setString(1, memberVO.getEmail());
			pstmt.setString(2, memberVO.getMebPass());
			pstmt.setString(3, memberVO.getMebName());
			pstmt.setInt(4, memberVO.getGender());
			pstmt.setString(5, memberVO.getTel());
			pstmt.setDate(6, memberVO.getBirthday());
			pstmt.setString(7, memberVO.getIntro());
			pstmt.setInt(8, memberVO.getReported());
			pstmt.setInt(9, memberVO.getMebStatus());
			pstmt.setBytes(10, memberVO.getMebPortrait());
			pstmt.setString(11, memberVO.getMebId());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException ce) {
			throw new RuntimeException("Couldn't load database driver. " + ce.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public MemberVO findByPrimaryKey(String mebId) {
		// TODO Auto-generated method stub
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, mebId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMebId(rs.getString("MEB_ID"));
				memberVO.setEmail(rs.getString("EMAIL"));
				memberVO.setMebPass(rs.getString("MEB_PASS"));
				memberVO.setMebName(rs.getString("MEB_NAME"));
				memberVO.setGender(rs.getInt("GENDER"));
				memberVO.setTel(rs.getString("TEL"));
				memberVO.setBirthday(rs.getDate("BIRTHDAY"));
				memberVO.setIntro(rs.getString("INTRO"));
				memberVO.setReported(rs.getInt("REPORTED"));
				memberVO.setMebStatus(rs.getInt("MEB_STATUS"));
				memberVO.setMebPortrait(rs.getBytes("MEB_PORTRAIT"));
			}

		} catch (ClassNotFoundException ce) {
			throw new RuntimeException("Couldn't load database driver. " + ce.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return memberVO;

	}

	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMebId(rs.getString("MEB_ID"));
				memberVO.setEmail(rs.getString("EMAIL"));
				memberVO.setMebPass(rs.getString("MEB_PASS"));
				memberVO.setMebName(rs.getString("MEB_NAME"));
				memberVO.setGender(rs.getInt("GENDER"));
				memberVO.setTel(rs.getString("TEL"));
				memberVO.setBirthday(rs.getDate("BIRTHDAY"));
				memberVO.setIntro(rs.getString("INTRO"));
				memberVO.setReported(rs.getInt("REPORTED"));
				memberVO.setMebStatus(rs.getInt("MEB_STATUS"));
				memberVO.setMebPortrait(rs.getBytes("MEB_PORTRAIT"));

				list.add(memberVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public MemberVO findByEmail(String email) {

		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_EMAIL_STMT);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMebId(rs.getString("MEB_ID"));
				memberVO.setEmail(rs.getString("EMAIL"));
				memberVO.setMebPass(rs.getString("MEB_PASS"));
				memberVO.setMebName(rs.getString("MEB_NAME"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return memberVO;

	}

	@Override
	public byte[] findPicByMebId(String mebId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		byte[] mebPic = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_PIC_STMT);
			pstmt.setString(1, mebId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mebPic = rs.getBytes("MEB_PORTRAIT");
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return mebPic;

	}

	@Override
	public InputStream findPicByMebId1(String mebId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		InputStream mebPic = null;

		try {
			Statement ds = null;
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_PIC_STMT);
			pstmt.setString(1, mebId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mebPic = rs.getBinaryStream("MEB_PORTRAIT");
			}
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return mebPic;
	}

	public static void main(String[] args) throws IOException {
		MemberDAO memberDAO = new MemberDAO();

		// �s�W
		//
		// MemberVO memberVO1 = new MemberVO();

		// memberVO1.setEmail("yyy@gmail.com");
		// memberVO1.setMebPass("123456");
		// memberVO1.setMebName("1JDBC1");
		// memberVO1.setGender(0);
		// memberVO1.setTel("0920120611");
		// Calendar gc = new GregorianCalendar(1995, Calendar.JANUARY, 21);
		// java.util.Date uDate = gc.getTime();
		// Date date = new Date(uDate.getTime());
		// memberVO1.setBirthday(date);
		// memberVO1.setIntro("123dwqdqw");
		// memberVO1.setReported(0);
		// memberVO1.setMebStatus(0);
		// InputStream is = new FileInputStream(new File("C:/1.jpg"));
		// byte[] pic = new byte[is.available()];
		// is.read(pic);
		// memberVO1.setMebPortrait(pic);
		// memberDAO.insert(memberVO1);

		// �d�@��

		MemberVO memberVO3 = memberDAO.findByPrimaryKey("M00011");

		System.out.println("Email:" + memberVO3.getEmail());
		System.out.println("�K�X:" + memberVO3.getMebPass());
		System.out.println("�m�W:" + memberVO3.getMebName());
		System.out.println("�ʧO:" + TransTool.gender(memberVO3.getGender()));
		System.out.println("�q��:" + memberVO3.getTel());
		System.out.println("�ͤ�:" + memberVO3.getBirthday());
		System.out.println("�ۧڤ���:" + memberVO3.getIntro());
		System.out.println("�Q���|����:" + memberVO3.getReported());
		System.out.println("�|�����A:" + TransTool.mebStatus(memberVO3.getMebStatus()));
		System.out.println("---------------------");

		// �d����
		// List<MemberVO> list = memberDAO.getAll();
		// for(MemberVO meber : list){
		// System.out.println("Email:"+meber.getEmail());
		// System.out.println("�K�X:"+meber.getMebPass());
		// System.out.println("�m�W:"+meber.getMebName());
		// System.out.println("�ʧO:"+TransTool.gender(meber.getGender()));
		// System.out.println("�q��:"+meber.getTel());
		// System.out.println("�ͤ�:"+meber.getBirthday());
		// System.out.println("�ۧڤ���:"+meber.getIntro());
		// System.out.println("�Q���|����:"+meber.getReported());
		// System.out.println("�|�����A:"+TransTool.mebStatus(meber.getMebStatus()));
		// System.out.println("==================================");
		//

		// ��s

		// ���Ӥ�

	}

	@Override
	public List<MemberVO> getOneMember(String mebId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> getOneMemberAll(String mem_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> getAll(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Insert(MemberVO memberVO) {
		// TODO Auto-generated method stub

	}

	@Override

	public List<MemberVO> getAllNoMe(String mebId) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_NO_ME);
			pstmt.setString(1, mebId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMebId(rs.getString("MEB_ID"));
				memberVO.setEmail(rs.getString("EMAIL"));
				memberVO.setMebPass(rs.getString("MEB_PASS"));
				memberVO.setMebName(rs.getString("MEB_NAME"));
				memberVO.setGender(rs.getInt("GENDER"));
				memberVO.setTel(rs.getString("TEL"));
				memberVO.setBirthday(rs.getDate("BIRTHDAY"));
				memberVO.setIntro(rs.getString("INTRO"));
				memberVO.setReported(rs.getInt("REPORTED"));
				memberVO.setMebStatus(rs.getInt("MEB_STATUS"));
				memberVO.setMebPortrait(rs.getBytes("MEB_PORTRAIT"));

				list.add(memberVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

}
