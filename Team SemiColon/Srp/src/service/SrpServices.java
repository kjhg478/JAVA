package service;

import java.sql.Connection;
import java.util.ArrayList;

import DB.JdbcUtil;
import dao.SrpDao;
import dto.SrpBean;

import static dao.SrpDao.*;
import static DB.JdbcUtil.*;

public class SrpServices {
	
	public SrpServices() {
		
	}
	
	public boolean SrpDb(SrpBean sb) {
		boolean result = false;
		SrpDao dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
	
		
		
		if(dao.Login(sb)) {
			dao.SrpDao(sb);
			sb.setComment("굿");
			result = true;
			JdbcUtil.close(con);
			
			
		}else {
			sb.setComment("등록된 회원정보가 없습니다.");
			JdbcUtil.close(con);
		}
		
		return result;
		
		
		
		
	
		
//		if(srpResult > 0) {
//			commit(con);
//			result = true;
//			close(con);
//		} else {
//			close(con);
//			result = false;
//		}
	
	}
	
}
