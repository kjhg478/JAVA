package services;

import static dao.MemberDAO.getInstance;
import static db.JdbcUtil.*;


import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;

public class JoinServices {

	public int UserInfo(MemberDTO mem) {
		
		MemberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		
		int result = dao.UserInfo(mem);
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
			close(con);
		}
		
		
		return result;
	}

}
