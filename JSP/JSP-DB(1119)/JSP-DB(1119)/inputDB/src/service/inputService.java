package service;

import java.sql.Connection;

import dao.inputDAO;

import static dao.inputDAO.*;
import static db.JdbcUtil.*;


public class inputService {

	public boolean inputDB(String input1, String input2) {
		// dao패키지의 inputDAO를 import
		System.out.println("(3)inputService의 inputDB메소드");
		inputDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		boolean svcResult = false;
		
		int daoResult = dao.inputDB(input1, input2);
		System.out.println("(7)inputService로 돌아옴");
		System.out.println("DAO에서 daoResult값을 return받음");
		if(daoResult>0) {
			commit(con);
			svcResult = true;
			close(con);
		} else {
			close(con);
			svcResult = false;
		}
		
		return svcResult;
	}

	

}









