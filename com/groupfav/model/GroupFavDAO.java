package com.groupfav.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.follow.model.FollowVO;

public class GroupFavDAO implements GroupFavDAO_Interface{

	
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "CA101_G4";
	private static final String PASSWORD = "CA101_G4";
	private static final String INSERT_STMT = "INSERT INTO GROUP_FAV (MEB_ID, GROUP_ID) VALUES  (?, ?) ";
	private static final String GET_ONE_STMT = null;
	private static final String GET_ALL_STMT = null;
	private static final String GET_ONE_STMT_2 = "SELECT MEB_ID , GROUP_ID FROM GROUP_FAV where MEB_ID = ?";
	private static final String DELETE ="DELETE FROM GROUP_FAV where MEB_ID = ? AND GROUP_ID = ? ";
	private static final String SELECT_BY_MEBID = 
			"SELECT GROUP_ID FROM GROUP_FAV  where MEB_ID = ? order by GROUP_ID ";
	private static final String SELECT_BY_GROUP_ID = 
			"SELECT COUNT('X') AS COUNTER FROM GROUP_FAV  where GROUP_ID = ?";
	private static final String SELECT = 
			"SELECT 'X' FROM GROUP_FAV where MEB_ID = ? AND GROUP_ID = ?";

	

	@Override
	public void insert(GroupFavVO groupFavVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CA101_G4","CA101_G4");
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, groupFavVO.getMebId());
			pstmt.setString(2, groupFavVO.getGroupId());
			
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
	public void delete(String mebId, String groupId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CA101_G4","CA101_G4");
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, mebId);
			pstmt.setString(2, groupId);

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
	public GroupFavVO findByPrimaryKey(String mebId) {
		GroupFavVO groupFavVO = null;
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
				groupFavVO = new GroupFavVO();
				groupFavVO.setMebId(rs.getString("MEB_ID"));
				groupFavVO.setGroupId(rs.getString("GROUP_ID"));
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
		return groupFavVO;
	}

	@Override
	public List<GroupFavVO> getAll() {
		List<GroupFavVO> list = new ArrayList<GroupFavVO>();
		

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
				GroupFavVO groupFavVO = new GroupFavVO();
				groupFavVO.setMebId(rs.getString("MEB_ID"));
				groupFavVO.setGroupId(rs.getString("GROUP_ID"));
				
				list.add(groupFavVO); // Store the row in the list
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
	


	@Override
	public List<GroupFavVO> getOneGroupFavAll(String mem_id) {
		List<GroupFavVO> list = new ArrayList<GroupFavVO>();
		GroupFavVO groupFavVO = null;

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
				groupFavVO = new GroupFavVO();
				groupFavVO.setMebId(rs.getString("MEB_ID"));
				groupFavVO.setGroupId(rs.getString("GROUP_ID"));
			
				list.add(groupFavVO); // Store the row in the list
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
	public void delete(GroupFavVO groupFavVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean check(GroupFavVO groupFavVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> findByMebId(String mebId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getFavNumber(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupFavVO> getOneGroupFav(String mebId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupFavVO> getOneGroupFavAll() {
		// TODO Auto-generated method stub
		return null;
	}
}


	
