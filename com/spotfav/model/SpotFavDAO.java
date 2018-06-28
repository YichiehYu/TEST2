package com.spotfav.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blogfav.model.BlogFavVO;
import com.follow.model.FollowVO;

public class SpotFavDAO implements SpotFavDAO_interface{
		private static final String INSERT = "INSERT INTO spot_fav (meb_id, spot_id) VALUES (?, ?)";
	private static final String DELETE = "DELETE FROM spot_fav WHERE meb_id=? AND spot_id=?";
	private static final String GET_ALL = "SELECT * FROM spot_fav";
	private static final String GET_BY_MEB = "SELECT spot_id FROM spot_fav WHERE meb_id=?";
	private static final String GET_BY_SPOT = "SELECT meb_id FROM spot_fav WHERE spot_id=?";
	private static final String GET_BY_MEB_SPOT = "SELECT * FROM spot_fav WHERE spot_id=? AND meb_id = ?";

	
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "CA101_G4";
	private static final String PASSWORD = "CA101_G4";
	private static final String INSERT_STMT = null;
	private static final String GET_ONE_STMT = null;
	private static final String GET_ALL_STMT = null;
	private static final String GET_ONE_STMT_2 = "SELECT MEB_ID , SPOT_ID FROM SPOT_FAV where MEB_ID = ?";
	

	@Override
	public void insert(SpotFavVO spotFavVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CA101_G4","CA101_G4");
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, spotFavVO.getMebId());
			pstmt.setString(2, spotFavVO.getSpotId());
			
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
	public void delete(String mebId, String spotId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","CA101_G4","CA101_G4");
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, mebId);
			pstmt.setString(2, spotId);

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
	public SpotFavVO findByPrimaryKey(String mebId) {
		SpotFavVO spotFavVO = null;
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
				spotFavVO = new SpotFavVO();
				spotFavVO.setMebId(rs.getString("MEB_ID"));
				spotFavVO.setSpotId(rs.getString("SPOT_ID"));
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
		return spotFavVO;
	}

	@Override
	public List<SpotFavVO> getAll() {
		List<SpotFavVO> list = new ArrayList<SpotFavVO>();
		SpotFavVO SpotFavVO = null;

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
				SpotFavVO = new SpotFavVO();
				SpotFavVO.setMebId(rs.getString("MEB_ID"));
				SpotFavVO.setSpotId(rs.getString("SPOT_ID"));
				
				list.add(SpotFavVO); // Store the row in the list
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
	public List<SpotFavVO> getByMeb(String mebId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpotFavVO> getBySpot(String spotId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getByMebSpot(String spotId, String mebId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SpotFavVO> getOneSpotFavAll(String mem_id) {
		List<SpotFavVO> list = new ArrayList<SpotFavVO>();
		SpotFavVO spotfavVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT_2);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				spotfavVO = new SpotFavVO();
				spotfavVO.setMebId(rs.getString("MEB_ID"));
				spotfavVO.setSpotId(rs.getString("SPOT_ID"));
			
				list.add(spotfavVO); // Store the row in the list
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
	
	
}
	

	