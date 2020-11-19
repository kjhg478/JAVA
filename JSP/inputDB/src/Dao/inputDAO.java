package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class inputDAO {
	
	private static inputDAO dao;
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	// getInstance 메소드
	public static inputDAO getInstance() {
		
		if(dao == null) {
			dao = new inputDAO();
		}
		
		return dao;
	}
	
	//setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int inputDB(String data1, String data2) {
		String sql = "INSERT INTO INPUTT VALUES(?,?)";
		int daoResult = 0;
		
		try {
			// sql문 작성
			pstmt = con.prepareStatement(sql);

			pstmt.setNString(1, data1);
			pstmt.setNString(2, data2);
			System.out.println(data1);
			System.out.println(data2);
			
			daoResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return daoResult;
		
	}

}
