package Service;

import DAO.memberDAO;
import DB.JdbcUtil;
import DTO.UserInfoBean;

import static DAO.memberDAO.*;
import static DB.JdbcUtil.*;

import java.sql.Connection;

public class memberservice {
	memberDAO dao = getInstance();
	Connection con = getConnection();
	
	public int memberjoin(UserInfoBean uib) {
		
		dao.setConnection(con);
		int result = dao.memberjoin(uib);
		if (result>0) {
			JdbcUtil.commit(con);
			
		}else {JdbcUtil.rollback(con);}
		close(con);
		return result;
	}

}
