package services;

import static dao.MemberDAO.getInstance;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberViewServices {

	public void MemberList(ArrayList<MemberDTO> list) {
		MemberDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		dao.MemberList(list);
		
	}

}
