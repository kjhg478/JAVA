package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Dto.MemberDTO;

import static Db.JdbcUtil.*;
public class DAO {
	
	private static DAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static DAO getInstance() {
		if(dao==null) {
			dao = new DAO();
		}
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	public int IdCheck(String userId) {
		System.out.println(userId);
		int result = 0;
		String sql="SELECT * FROM KJH_MEMBER WHERE STUID=?";		
		try 
		{

			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, userId);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				result=1;
			}
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		System.out.println(result);
		return result;
	}

	public int memberJoin(MemberDTO member) {
		String sql = "INSERT INTO KJH_MEMBER VALUES(?,?,?,?)";
		int result = 0;
		
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member.getUserId());
			
				pstmt.setString(2, member.getUserPw());
				pstmt.setString(3, member.getUserName());
				pstmt.setString(4, member.getUserGroup());
	
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
		return result;
	}
	
}