package services;

import java.util.ArrayList;

import data.DataAccessObject;
import data.UserInfoBean;

public class Access {

	DataAccessObject dao;

	public Access() { } 

	public void entrance(String reqv, UserInfoBean uib,ArrayList<UserInfoBean> userinfo) {
		switch (reqv) {
		case "A1":
			logIn(uib,userinfo);
			break;
		case "A2":
			userReg(uib);
			break;
		case "A3":
			userMod(uib);
			break;
		case "A4":
			logOut(uib);
			break;
		}


	}

	private void logIn(UserInfoBean uib, ArrayList<UserInfoBean> userinfo) {
		dao = new DataAccessObject();
		dao.setAutoTransaction(false);

		if (dao.isEmployee(uib)) {	

			if (dao.isAccess(uib)) {

				if(dao.setLogInInfo(uib)) {

					dao.getUserInfo(uib, userinfo);

					// 필요없는데이터 삭제
					uib.setAccessCode(null);	

					dao.endAutoTransaction(true);	
				}else {

					dao.endAutoTransaction(false);	
				}



			}
		}

	}
	
	
	private void logOut(UserInfoBean uib) {
		
		boolean tran = false;
		dao = new DataAccessObject();
		dao.setAutoTransaction(false);
		
		if(dao.setLogInInfo(uib)) tran = true;
			
		
		dao.endAutoTransaction(tran);
	}
	


	// 유저 등록
	private void userReg(UserInfoBean uib) {

		boolean tran = false;

		dao = new DataAccessObject();

		dao.setAutoTransaction(false);

		if(dao.setUserReg(uib)) {tran = true;}

		dao.endAutoTransaction(tran);

	}


	// 유저 수정
	private void userMod(UserInfoBean uib) {
		boolean tran = false;
		dao = new DataAccessObject();

		dao.setAutoTransaction(false);

		if(dao.setUserInfoMod(uib)) {tran = true;}
		
		dao.endAutoTransaction(tran);


	}


}
