package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static db.JdbcUtil.*;

public class CheckDAO {
	private static CheckDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// getInstance메소드
	public static CheckDAO getInstance() {
		if (dao == null) {
			dao = new CheckDAO();
		}
		return dao;
	}

	// setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}

	public String NickCheck(String id) {
		String sql = "SELECT * FROM ME WHERE ID = ?";
		System.out.println(id);
		String result = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getNString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}


}
