package Service;

import java.sql.Connection;
import java.util.ArrayList;

import DTO.UserInfoBean;
import DAO.memberDAO;
import static DAO.memberDAO.*;
import static DB.JdbcUtil.*;
public class ListService {

	public ArrayList<UserInfoBean> memberList() {
		memberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		ArrayList<UserInfoBean> list;
		list = dao.memberList();
		return list;
	}

}
