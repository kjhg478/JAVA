package jdbc1113;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
	public static Connection DBconnect() {
		
		// DB에 접속정보 저장을 위한
		// Connection 타입의 변수 con 선언
		Connection con = null;
		
		//접속할 DB의 주소정보
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		// 접속할 유저의 계정정보
		String user = "KJH";
		String password = "7777";
		
		// Database Driver 설정
		try {
			// ojdbc6 파일을 현재 소스에 적용
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// con에 정보를 저장
			con = DriverManager.getConnection(url, user, password);
			System.out.println("db 접속 성공 !");
		} catch(ClassNotFoundException cne) {	// 드라이버가 제대로 작동하지 않을 경우
			cne.printStackTrace();
			System.out.println("db 접속실패 : 드라이버");
		} catch(SQLException se) { // DB 계정 정보가 틀릴경우
			se.printStackTrace();
			System.out.println("db 접속실패 : db계정");
		}
		
		return con;
		
	}
}
