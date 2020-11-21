package Service;

import java.sql.Connection;
import java.util.ArrayList;

import DAO.memberDAO;
import DTO.UserInfoBean;

import static DAO.memberDAO.*;
import static DB.JdbcUtil.*;

public class ListServices {
	
	public ListServices() {
		
	}
	
	public ArrayList<UserInfoBean> memberList() {
		ArrayList<UserInfoBean> list;
		memberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		memberDAO md = new memberDAO();
		list = dao.memberList();
		
		return list;
	}

}
