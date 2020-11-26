package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static DB.JdbcUtil.*;
import DTO.UserInfoBean;

public class memberDAO {
	private static  memberDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	// getInstance메소드
	public static memberDAO getInstance() {
		if (dao == null) {
			dao = new memberDAO();
		}
		
		return dao;
	}

	//setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}

	public int memberjoin(UserInfoBean uib) {
		String sql = "INSERT INTO MEMBERT VALUES(?,?,?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uib.getUserId());
			pstmt.setString(2, uib.getUserPwd());
			pstmt.setString(3, uib.getUserName());
			pstmt.setString(4, uib.getUserBirth());
			pstmt.setString(5, uib.getUserGender());
			pstmt.setString(6, uib.getUserEmail());
		
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();}
//		} finally {
//			close(con);
//			close(pstmt);
//		}
		
		return result;
	}

	public ArrayList<UserInfoBean> memberList() {
		ArrayList<UserInfoBean> list = new ArrayList<UserInfoBean>();
		UserInfoBean uib =null;
		String sql = "SELECT * FROM MEMBERT";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				uib = new UserInfoBean();
				
				uib.setUserId(rs.getString(1));
				uib.setUserPwd(rs.getString(2));
				uib.setUserName(rs.getString(3));
				uib.setUserBirth(rs.getString(4));
				uib.setUserGender(rs.getString(5));
				uib.setUserEmail(rs.getString(6));
				
				list.add(uib);
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}

	public String getloginfo(UserInfoBean uib) {
		String sql = "SELECT MB_NAME FROM MEMBERT WHERE MB_CODE=? AND MB_PWD=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,uib.getUserId());
			pstmt.setString(2,uib.getUserPwd());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				uib.setUserName(rs.getString("MB_NAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		
		
		return uib.getUserName();
	}

	
}












