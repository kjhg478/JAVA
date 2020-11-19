package dao;

import java.sql.*;


public class inputDAO {
	
	private static inputDAO dao;
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
		
	// getInstance메소드
	public static inputDAO getInstance() {
		
		if(dao == null) {
			dao = new inputDAO();
		}
		
		return dao;
	}
	
	// setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}

	public int inputDB(String input1, String input2) {
		System.out.println("(4)inputDAO의 inputDB메소드");
		String sql = "INSERT INTO INPUTT VALUES(?,?)";
		int daoResult = 0;
		
		try {
			// sql문 작성
			pstmt = con.prepareStatement(sql);
			System.out.println("(5)DB실행");
			
			// ?에 값 입력
			pstmt.setString(1, input1);
			pstmt.setString(2, input2);
			
			// db실행 => 결과를 daoResult에 담기
			daoResult = pstmt.executeUpdate();
			System.out.println("(6)DAO : DB를 실행 한 값을 받음");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return daoResult;
	}

	
		
		
		
		
	
	

}
