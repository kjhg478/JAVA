package Service;

import DTO.UserInfoBean;

import static DAO.memberDAO.*;
import static DB.JdbcUtil.*;

import java.sql.Connection;

import DAO.memberDAO;


public class loginService {
	memberDAO dao = getInstance();
	Connection con = getConnection();
	
	
	public String getloginfo(UserInfoBean uib) {
		dao.setConnection(con);

		String loginId = dao.getloginfo(uib);
		close(con);
		
		return loginId;

	}



}
