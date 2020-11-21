package Service;

import static DAO.memberDAO.getInstance;
import static DB.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import DAO.memberDAO;
import DTO.UserInfoBean;

public class LoginServices {
	
	public LoginServices() {
		
	}

	public String login(UserInfoBean uib) {
		memberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		
		String loginid = dao.login(uib);
		
		return loginid;

	}
	

}
