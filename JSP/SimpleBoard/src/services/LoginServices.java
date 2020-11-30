package services;

import static dao.MemberDAO.getInstance;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;

public class LoginServices {

	public boolean Login(MemberDTO mem) {
		boolean result = false;
		
		MemberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		if(dao.Login(mem)) {
			result = true;
			close(con);
		}else {
			close(con);
		}
		
		return result;
	}

	public String LoginSession(MemberDTO mem) {
		MemberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		String loginid = dao.LoginSession(mem);
		
		return loginid;
	}

}
