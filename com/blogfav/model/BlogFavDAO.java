package com.blogfav.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.follow.model.FollowVO;

public class BlogFavDAO implements BlogFavDAO_interface{
	private static final String INSERT_STMT = 
			"INSERT INTO BLOG_FAV (MEB_ID ,BLOG_ID) VALUES (? ,?)";
	private static final String GET_ALL_STMT = 
			"SELECT * FROM BLOG_FAV order by MEB_ID";
	private static final String GET_ONE_STMT = 
			"SELECT * FROM BLOG_FAV where MEB_ID = ?";
	private static final String GET_ONE_STMT_2 = "SELECT MEB_ID , BLOG_ID FROM BLOG_FAV where MEB_ID = ?";
	private static final String DELETE = 
			"DELETE FROM BLOG_FAV where MEB_ID = ? AND BLOG_ID = ?";
	private static final String GET_PIC_STMT = "SELECT BLOG_PIC FROM BLOG_FAV where MEB_ID = ?";
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "CA101_G4";
	private static final String PASSWORD = "CA101_G4";
	@Override
	public void insert(BlogFavVO blogFavVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CA101_G4","CA101_G4");
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, blogFavVO.getMebId());
			pstmt.setString(2, blogFavVO.getBlogId());
			
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void delete(String mebId, String blogId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CA101_G4","CA101_G4");
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, mebId);
			pstmt.setString(2, blogId);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public BlogFavVO findByPrimaryKey(String mebId) {
		BlogFavVO blogFavVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CA101_G4","CA101_G4");
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, mebId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				blogFavVO = new BlogFavVO();
				blogFavVO.setMebId(rs.getString("MEB_ID"));
				blogFavVO.setBlogId(rs.getString("BLOG_ID"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		return blogFavVO;
	}

	@Override
	public List<BlogFavVO> getAll() {
		List<BlogFavVO> list = new ArrayList<BlogFavVO>();
		BlogFavVO blogFavVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CA101_G4","CA101_G4");
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				blogFavVO = new BlogFavVO();
				blogFavVO.setMebId(rs.getString("MEB_ID"));
				blogFavVO.setBlogId(rs.getString("BLOG_ID"));
				
				list.add(blogFavVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
	

	
	
	
	
	public static void main(String[] args) {
		
		BlogFavService blogFavService = new BlogFavService();
		
		BlogFavDAO blogFavDAO = new BlogFavDAO();
		
//		BlogFavVO blogFavVO = new BlogFavVO();
//		blogFavVO.setMebId("M00019");
//		blogFavVO.setBlogId("B00010");
//		blogFavDAO.insert(blogFavVO);
		
//		BlogFavVO blogFavVO = blogFavDAO.findByPrimaryKey("M00019");
//		System.out.println(blogFavVO.getMebId());
//		System.out.println(blogFavVO.getBlogId());
		
	
		
//		List<BlogFavVO> list = blogFavDAO.getAll();
//		for(BlogFavVO blogFavVO : list){
//			System.out.println(blogFavVO.getMebId());
//			System.out.println(blogFavVO.getBlogId());
//			System.out.println("========================");
//		}
		
//		blogFavDAO.delete("M00019", "B00005");
	
//	blogFavService.addBlogFav("M00019", "B00010");
		
//		BlogFavVO blogFavVO = blogFavService.getOneBlogFav("M00023");
//		System.out.println("會員編號:"+blogFavVO.getMebId());
//		System.out.println("部落格編號:"+blogFavVO.getBlogId());
		
//		List<BlogFavVO> list = blogFavService.getAll();
//		for(BlogFavVO blogFavVO : list){
//			System.out.println("會員編號:"+blogFavVO.getMebId());
//			System.out.println("部落格編號:"+blogFavVO.getBlogId());
//			System.out.println("===================");
//		}
		
		
		
		
//		blogFavService.deleteBlogFav("M00019", "B00010");
	}


		

	@Override
	public List<BlogFavVO> getOneBlogFavAll(String mebId) {
		List<BlogFavVO> list = new ArrayList<BlogFavVO>();
		BlogFavVO blogFavVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CA101_G4","CA101_G4");
			pstmt = con.prepareStatement(GET_ONE_STMT_2);
			pstmt.setString(1, mebId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				blogFavVO = new BlogFavVO();
				blogFavVO.setMebId(rs.getString("MEB_ID"));
				blogFavVO.setBlogId(rs.getString("BLOG_ID"));
			
				list.add(blogFavVO); // Store the row in the list
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
	public List<BlogFavVO> getOneBlogFav(String mebId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogFavVO> getOneBlogFavAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] findPicByMebId(String mebId) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		byte[] mebPic = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CA101_G4","CA101_G4");
			pstmt = con.prepareStatement(GET_PIC_STMT);
			pstmt.setString(1, mebId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mebPic = rs.getBytes("BLOG_PIC");
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
}

	
	
