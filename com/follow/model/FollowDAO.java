package com.follow.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class FollowDAO implements FollowDAO_Interface{
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "CA101_G4";
	private static final String PASSWORD = "CA101_G4";
	
	private static final String INSERT_STMT = 
		"INSERT INTO FOLLOW (MEB_ID_A,MEB_ID_B) VALUES (?,?)";
    private static final String DELETE_STMT=
    "DELETE FROM FOLLOW where MEB_ID_A=? AND MEB_ID_B=?";

	private static final String GET_ALL_STMT =	"SELECT MEB_ID_A,MEB_ID_B FROM FOLLOW order by MEB_ID_A";
	private static final String GET_ONE_STMT = "SELECT MEB_ID_A , MEB_ID_B FROM FOLLOW where MEB_ID_A = ?";
	private static final String GET_ONE_STMT_2 = "SELECT MEB_ID_A , MEB_ID_B FROM FOLLOW where MEB_ID_B = ?";

	
		
	@Override
	public void insert(FollowVO followVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt =  con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, followVO.getMebIdA());
			pstmt.setString(2, followVO.getMebIdB());
			
			pstmt.executeUpdate();
		} catch(ClassNotFoundException ce){
			throw new RuntimeException("Couldn't load database driver. "+ ce.getMessage());
			
		} catch(SQLException se){
			throw new RuntimeException("A database error occured" +se.getMessage());
		} finally {
			if(pstmt != null){
				try{
					pstmt.close();
				}catch(SQLException se){
					se.printStackTrace(System.err);
				}
			}
			if(con != null){
			   try{
				   con.close();
			   }catch(Exception e){
				   e.printStackTrace(System.err);
			   }
			}
		}
		
	}

	
	

	@Override
	public void delete(String mebIdA, String mebIdB) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setString(1, mebIdA);
			pstmt.setString(2, mebIdB);
			
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
	public FollowVO findByPrimaryKey(String advId) {
		// TODO Auto-generated method stub
		FollowVO followVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, advId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				followVO = new FollowVO();
				followVO.setMebIdA(rs.getString("MEB_ID_A"));
				followVO.setMebIdB(rs.getString("MEB_ID_B"));							
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

		return followVO;
		
	}

	@Override
	public List<FollowVO> getAll() {
		List<FollowVO> list = new ArrayList<FollowVO>();
		FollowVO followVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				followVO = new FollowVO();
				followVO.setMebIdA(rs.getString("MEB_ID_A"));
				followVO.setMebIdB(rs.getString("MEB_ID_B"));
			
				list.add(followVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	
	public static void main(String[] args)throws IOException{
		FollowDAO followDAO = new FollowDAO();
		
		//�s�W
		 
//	    FollowVO followVO = new FollowVO();
//	   
//	    followVO.setMebIdA("M00003");
//	    followVO.setMebIdB("M00007");
//	   
//	    followDAO.insert(followVO);
//	    
	    
	    
	
	    
//	    //�R��
//	    followDAO.delete("M00003", "M00005");
//	    
//	    
		// �d��
//		FollowVO followVO3 = followDAO.findByPrimaryKey("M00004");
//		System.out.print(followVO3.getMebIdA() + ",");
//		System.out.println(followVO3.getMebIdB());
//		System.out.println("---------------------");
		

	

	
//		List<FollowVO> list = followDAO.getAll();
//		for (FollowVO follow : list) {
//			System.out.print(follow.getMebIdA() + ",");
//			System.out.print(follow.getMebIdB());
//			System.out.println();
		}
	

		
	




	@Override
	public List<FollowVO> getOneFollowAll(String mem_id) {
		List<FollowVO> list = new ArrayList<FollowVO>();
		FollowVO followVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				followVO = new FollowVO();
				followVO.setMebIdA(rs.getString("MEB_ID_A"));
				followVO.setMebIdB(rs.getString("MEB_ID_B"));
			
				list.add(followVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public List<FollowVO> getOneFollowedAll(String mem_id) {
		List<FollowVO> list = new ArrayList<FollowVO>();
		FollowVO followVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CA101_G4","CA101_G4");
			pstmt = con.prepareStatement(GET_ONE_STMT_2);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				followVO = new FollowVO();
				followVO.setMebIdA(rs.getString("MEB_ID_A"));
				followVO.setMebIdB(rs.getString("MEB_ID_B"));
			
				list.add(followVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public List<FollowVO> getOneFollow(String mebId) {
		// TODO Auto-generated method stub
		return null;
	}
}



