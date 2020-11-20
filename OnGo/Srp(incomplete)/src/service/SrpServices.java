package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SrpDao;
import dto.SrpBean;

import static dao.SrpDao.*;
import static DB.JdbcUtil.*;

public class SrpServices {
	
	public SrpServices() {
		
	}
	public ArrayList<SrpBean> entrance(SrpBean sb, ArrayList<SrpBean> list) {
		
		switch (sb.getServicecode()) {
		case 1:
			SrpDb(sb);
			break;
		case 2:
			stuinfo(list);
			break;
		default:
			break;
		}
		return list;
	}
	
	
	
	private void SrpDb(SrpBean sb) {
	
		SrpDao dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		dao.Login(sb);
		
		
//		if(srpResult > 0) {
//			commit(con);
//			result = true;
//			close(con);
//		} else {
//			close(con);
//			result = false;
//		}
	
	}
	
	private ArrayList<SrpBean> stuinfo(ArrayList<SrpBean> list) {
		
		SrpDao dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		list = dao.SrpDao(list);
		
		return list;
		
		
	}

}
