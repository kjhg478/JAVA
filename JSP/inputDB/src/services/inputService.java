package services;

import java.sql.Connection;

import Dao.inputDAO;
import db.JdbcUtil;

import static Dao.inputDAO.*;
import static db.JdbcUtil.*;

public class inputService {
	public boolean inputDB(String data1, String data2) {
		
		inputDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		boolean svcResult = false;
		
		
		int result = dao.inputDB(data1, data2);
		if(result==1) {
			JdbcUtil.commit(con);
		}
		
		return svcResult;
	}
}
