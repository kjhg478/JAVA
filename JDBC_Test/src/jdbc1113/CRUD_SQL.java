package jdbc1113;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD_SQL {
	//DB 접속을 위한 변수 con 선언
	Connection con = null;
	
	//쿼리문 전송하기 위한 변수 선언
	Statement stmt = null;			// sql문을 db로 전송하기 위한 변수
	PreparedStatement pstmt = null; // ?를 문자로 인식하기 위한 변수

	// 조회(SELECT) 결과 저장하기 위한 변수 rs 선언
	ResultSet rs = null;
	
	//1. DB 접속
	public void connect() {
		con = DBC.DBconnect();
		// DBC에 있는 DBconnect()를 가져온다 !
	}
		//2. DB 접속 해제
	public void conClose() {
		try {
			con.close();
			System.out.println("DB 접속 해제!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void stuJoin(CRUD_DTO stu) {
		String sql = "INSERT INTO STUTABLE VALUES(?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setNString(1, stu.getStuName());
			pstmt.setInt(2, stu.getStuAge());
			// 첫번째 물음표에 stu.getStuName() 값을
			// 두번째 물음표에 stu.getStuAge() 값을
			
			pstmt.executeUpdate();
			System.out.println("학생 등록 성공 !");
		} catch (SQLException e) {
			System.out.println("학생 등록 실패 !");
			e.printStackTrace();
		}
	}
	public void select() {
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM STUTABLE";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // rs에 담긴 데이터 수만큼 반복
				System.out.println("이름 : " + rs.getString(1));
				System.out.println("나이 : " + rs.getInt(2));
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void Modify(CRUD_DTO stu) {
		
		String sql = "UPDATE STUTABLE SET STUNAME = ?, STUAGE = ? WHERE STUNAME = ?";
		System.out.println(stu.getStuName());
		System.out.println(stu.getStuAge());
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setNString(1, stu.getStuName());
			pstmt.setInt(2, stu.getStuAge());
			pstmt.setNString(3, stu.getStuName2());
			
			pstmt.executeUpdate();
			
			System.out.println("학생 정보 수정 성공!");
			con.close();
		} catch (SQLException e) {
			System.out.println("학생 정보 수정 실패!");
			e.printStackTrace();
		}

		
	}
	public void Delete(CRUD_DTO stu) {
		String sql = "DELETE STUTABLE WHERE STUNAME = ?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setNString(1, stu.getStuName());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

