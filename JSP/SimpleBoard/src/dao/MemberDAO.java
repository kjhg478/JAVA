package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static db.JdbcUtil.*;

import dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// getInstance메소드
	public static MemberDAO getInstance() {
		if (dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}

	// setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}

	public boolean Login(MemberDTO mem) {// 아이디 비교 후, 아이디 비밀번호 비교 ! (이게 보안상 더 적합)
		boolean result = false;
		String sql = "SELECT COUNT(*) FROM USERINFO_SY WHERE USERID =? AND USERPW = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setNString(1, mem.getUserId());
			pstmt.setNString(2, mem.getUserPw());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = (rs.getInt(1)==1)? true : false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public String LoginSession(MemberDTO mem) {
		String sql = "SELECT USERID FROM USERINFO_SY WHERE USERID =? AND USERPW = ?";
		String loginid = null;
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setNString(1, mem.getUserId());
			pstmt.setNString(2, mem.getUserPw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginid = rs.getNString(1);
			}else {
				loginid = null;
			}
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginid;
		
	}


	public int UserInfo(MemberDTO mem) {
		String sql = "INSERT INTO USERINFO_SY VALUES(?,?,?,?,?,?)";
		int result = 0;
		System.out.println(mem.getUserName());
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, mem.getUserId());
			pstmt.setNString(2, mem.getUserPw());
			pstmt.setNString(3, mem.getUserName());
			pstmt.setNString(4, mem.getUserBirth());
			pstmt.setNString(5, mem.getUserGender());
			pstmt.setNString(6, mem.getUserMail());
			
			result = pstmt.executeUpdate();
			System.out.println(mem.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public void MemberList(ArrayList<MemberDTO> list) {
		String sql = "SELECT USERID, USERNAME, USERBIRTH, USERGENDER, USEREMAIL FROM USERINFO_SY"; 
		
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO mem = new MemberDTO();
				mem.setUserId(rs.getNString(1));
				mem.setUserName(rs.getNString(2));
				mem.setUserBirth(rs.getNString(3));
				mem.setUserGender(rs.getNString(4));
				mem.setUserMail(rs.getNString(5));
				
				list.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
	}

}
