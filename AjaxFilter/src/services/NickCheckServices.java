package services;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.CheckDAO;

public class NickCheckServices {

	public String NickCheck(String id) {
		CheckDAO dao = CheckDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		String result = dao.NickCheck(id);
		
		close(con);
		
		return result;
	}

}
