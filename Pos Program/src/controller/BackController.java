package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import data.GoodsInfoBean;
import data.UserInfoBean;
import services.Access;
import services.Managements;
import services.Sales;

public class BackController {

	private Access ac;
	private Sales ss;
	private Managements mg;
	private String[] userAccess;

	public BackController() {
		ac = new Access();
		ss = new Sales();
		mg = new Managements();


	}

	public String[] logInOut(String[] userInfo) {		
		UserInfoBean uib = new UserInfoBean();
		ArrayList<UserInfoBean> userinfo =  new ArrayList<UserInfoBean>();
       // Client로 부터 전달 받은 userInfo의 값을 UserInfoBean으로 복사
		uib.setEmployeeCode(userInfo[1]);
		uib.setAccessCode(userInfo[2]);
		uib.setStCode(userInfo[0]);
		uib.setAccessState(Integer.parseInt(userInfo[3]));

		
		if(uib.getAccessState()==1) {ac.entrance("A1",uib,userinfo);}
		else {
			ac.entrance("A4",uib,null);
			userinfo = null;
		}
		
		
		if (userinfo != null && userinfo.size()!=0) {
			userAccess = new String[5];
			userAccess[0] = userinfo.get(0).getEmployeeCode();
			userAccess[1] = userinfo.get(0).getUserName();
			userAccess[2] = userinfo.get(0).isUserLevel()? "Manager":"Mate";
			userAccess[3] = userinfo.get(0).getAccessTime();
			userAccess[4] = userinfo.get(0).getStCode();
		}else {userAccess = null;}
		

		return userAccess;
	}

	public String[] userRegistration(String[] userInfo) {
		UserInfoBean uib = new UserInfoBean();
		uib.setEmployeeCode(userInfo[0]);
		uib.setAccessCode(userInfo[1]);
		uib.setUserName(userInfo[2]);
		uib.setStCode(userInfo[3]);
		uib.setUserLevel(userInfo[4].equals("Manager")?true:false);
		
		ac.entrance("A2",uib,null);
		return userAccess;
	}

	public String[] userAccMod(String[] userInfo) {
		UserInfoBean uib = new UserInfoBean();
		// Client로 부터 전달 받은 userInfo의 값을 UserInfoBean으로 복사
		uib.setEmployeeCode(userInfo[1]);
		uib.setAccessCode(userInfo[2]);

		ac.entrance("A3",uib,null);

		return userAccess;
	}
	public String[] getGoodsInfo(String goodsCode) {
		String[] goodsInfo = null;
		GoodsInfoBean gib = new GoodsInfoBean();
		// bean 저장
		gib.setGoodsCode(goodsCode);
		ss.entrance(gib,"1");

		// Bean 값 배열로저장
		if(gib.getGoodsName()!=null) {
			goodsInfo = new String[6];
			goodsInfo[0] = gib.getGoodsCode();
			goodsInfo[1] = gib.getGoodsName();
			goodsInfo[2] = gib.getGoodsPrice()+"";
			goodsInfo[3] = gib.getGoodsqty()+"";
			goodsInfo[4] = gib.getExpireDate();
			
		}
		return goodsInfo;
	}
	
	public void stackGoodsInfo(String[][] goodsList, String[] user) {
		
		// 리스트배열 선언으로 2차원 배열값 빈에 저장하기
		ArrayList<GoodsInfoBean> goodsStack = new ArrayList<GoodsInfoBean>();
		
		GoodsInfoBean gib;
		UserInfoBean uib = new UserInfoBean();
		
		Date day = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String days = sdf.format(day);
		
		uib.setStCode(user[4]);
		uib.setToday(days);
		uib.setEmcode(user[0]);
		uib.setCmcode("00000");
		

		for (int i = 0; i < goodsList.length; i++) {
			gib = new GoodsInfoBean();

			gib.setGoodsCode(goodsList[i][0]);
			gib.setGoodsName(goodsList[i][1]);
			gib.setGoodsPrice(Integer.parseInt(goodsList[i][2]));
			gib.setGoodsqty(Integer.parseInt(goodsList[i][3]));
			gib.setUniqCode(goodsList[i][5]);
			
			goodsStack.add(gib);
		}
		
		ss.entrance(goodsStack,uib);
	}
	

	public String[][] searchOrder(String ordCode) {
		GoodsInfoBean gib = new GoodsInfoBean();
		ArrayList<GoodsInfoBean> salesList;

		gib.setUniqCode(ordCode);
		salesList = ss.entrance(gib,"2");
		String[][] arrSalesList = new String[salesList.size()][4];
		
		if(salesList!=null) {
		for (int i = 0; i < salesList.size(); i++) {
			arrSalesList [i][0]= salesList.get(i).getGoodsCode();
			arrSalesList [i][1]= salesList.get(i).getGoodsName();
			arrSalesList [i][2]= salesList.get(i).getGoodsPrice()+"";
			arrSalesList [i][3]= salesList.get(i).getGoodsqty()+"";
		}    
		}
		return arrSalesList;
	}
	
	public void cancelInfo(String ordCode, String[][] cancelList) {
		ArrayList<GoodsInfoBean> arrCancelList = new ArrayList<GoodsInfoBean>();
		GoodsInfoBean gib;
		
		for (int i = 0; i < cancelList.length; i++) {
			gib = new GoodsInfoBean();
			gib.setGoodsCode(cancelList[i][0]);
			gib.setGoodsName(cancelList[i][1]);
			gib.setGoodsPrice(Integer.parseInt(cancelList[i][2]));
			gib.setGoodsqty(Integer.parseInt(cancelList[i][3]));
			gib.setUniqCode(ordCode);
			
			arrCancelList.add(gib);
		}
	
		ss.entrance(arrCancelList,null);
		
	}
	
	public void cancelInfo(String ordCode, String[] cancelGoods) {
		
		GoodsInfoBean gib;
		
			gib = new GoodsInfoBean();
			gib.setGoodsCode(cancelGoods[0]);
			gib.setGoodsName(cancelGoods[1]);
			gib.setGoodsPrice(Integer.parseInt(cancelGoods[2]));
			gib.setGoodsqty(-1);
			gib.setUniqCode(ordCode);
		
		ss.entrance(gib,"3");
		
	}
	public void goodsReg(String[] goodsInfo) {
		GoodsInfoBean gib =  new GoodsInfoBean();
		
		gib.setGoodsCode(goodsInfo[0]);
		gib.setGoodsName(goodsInfo[1]);
		gib.setGoodsPrice(Integer.parseInt(goodsInfo[2]));
		gib.setExpireDate(goodsInfo[3]);
		gib.setGoodsqty(Integer.parseInt(goodsInfo[4]));
		gib.setSafetyQty(goodsInfo[5]);
		
		mg.entrance(1, gib);
	}
	
	public void goodsPriceMod(String[] goodsInfo) {
		GoodsInfoBean gib = new GoodsInfoBean();
		gib.setGoodsCode(goodsInfo[0]);
		gib.setGoodsPrice(Integer.parseInt(goodsInfo[1]));
		
		mg.entrance(2, gib);

	}
	// 일별 월별 매출 현황 정보 가져오기
	public String[][] getDailySales(String days, String ordCode) {
		
		ArrayList<GoodsInfoBean> goOut;
		String[][] dailyList;
		GoodsInfoBean gib = new GoodsInfoBean();
		gib.setUniqCode(days);
		int count = 0;
		
		if (ordCode.equals("5")){
			goOut = mg.entrance(4, gib);
		}else {
			goOut = mg.entrance(3, gib);
		}
		if(goOut!=null) {
		 dailyList = new String[goOut.size()][5];
		
		for (GoodsInfoBean i : goOut) {
			dailyList[count][0] = i.getGoodsCode();
			dailyList[count][1] = i.getGoodsName();
			dailyList[count][2] = i.getGoodsPrice()+"";
			dailyList[count][3] = i.getGoodsqty()+"";
			dailyList[count][4] = i.getAmount()+"";
			count++;
		}
		}else {dailyList=null;}
		return dailyList;
	}
	
	
	
}
