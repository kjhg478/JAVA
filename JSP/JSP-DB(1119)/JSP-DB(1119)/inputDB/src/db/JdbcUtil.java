// jsp와 DB가 연동되게 하는 설정 (항상 필요함)
// 이 util파일은 그냥 그대로만 가지고가면됨 연동할때 쓰는 설정파일임 

package db;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class JdbcUtil {

	public static Connection getConnection() {
		Connection con = null;

		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/OracleDB");
			System.out.println("ds = " + ds);
			
			con = ds.getConnection();
			System.out.println("con = " + con);
			con.setAutoCommit(false);
			System.out.println("DB접속 성공!Util");
		} catch (Exception e) {
			System.out.println("DB접속 실패!Util");
			e.printStackTrace();
		}

		return con;

	}

	// (1) con close
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// (2) stmt close
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// (3) pstmt close
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// (4) rs close
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// (5) commit
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// (6) rollback
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
