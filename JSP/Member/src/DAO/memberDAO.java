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
		
		String sql = "SELECT * FROM MEMBERT";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserInfoBean uib = new UserInfoBean();
				uib.setUserId(rs.getNString("USERID"));
				uib.setUserPwd(rs.getNString("USERPW"));
				uib.setUserName(rs.getNString("USERNAME"));
				uib.setUserBirth(rs.getNString("USERBIRTH"));
				uib.setUserGender(rs.getNString("USERGENDER"));
				uib.setUserEmail(rs.getNString("USEREMAIL"));
				
				list.add(uib);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return list;
	}

	public String login(UserInfoBean uib) {
		String sql = "SELECT USERID FROM MEMBERT WHERE USERID = ? AND USERPW = ?";
		String loginid = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, uib.getUserId());
			pstmt.setNString(2, uib.getUserPwd());
			
			rs = pstmt.executeQuery();
			System.out.println(uib.getUserId());
			if(rs.next()) { // while은 데이터가 있는만큼 반복문을 돌려줌
				loginid = rs.getNString(1);
			}else {
				loginid = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return loginid;
	}

	
}












