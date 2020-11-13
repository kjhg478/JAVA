package services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import data.DataAccessObject;
import data.GoodsInfoBean;
import data.UserInfoBean;

public class Sales {

	DataAccessObject dao;

	public Sales() {

	}
	
	public ArrayList<GoodsInfoBean> entrance(GoodsInfoBean gib,String reqCode) {
		ArrayList<GoodsInfoBean> salesList = null;
		switch (reqCode) {
		case "1":
			// 상품검색
			goodsSearch(gib);
			break;
		case "2":
			// 상품 반품 검색
			salesList = getSalesList(gib);
			break;
			
		case "3":
			// 상품 반품 검색
			cancelOne(gib);
			break;
		}
		return salesList;
	}
	
	public void entrance(ArrayList<GoodsInfoBean> goodsStack,UserInfoBean uib) {

		// 상품판매 정보 저장
		stackSalesInfo(goodsStack,uib);
	}
	
	
	

	private void goodsSearch(GoodsInfoBean gib) {
		dao = new DataAccessObject();
		dao.setAutoTransaction(false);
		dao.getGoodsInfo(gib);
	}

	private void stackSalesInfo(ArrayList<GoodsInfoBean> goodsStack, UserInfoBean uib) {
		
		dao = new DataAccessObject();
		dao.setAutoTransaction(false);
		int count = 0;
		
	
		for(GoodsInfoBean gib : goodsStack) {
			dao.stackSalesInfo(gib,count,uib);
			count++;
		}
		
		dao.endAutoTransaction(true);
		
	}
	
	private ArrayList<GoodsInfoBean> getSalesList(GoodsInfoBean gib) {
		dao = new DataAccessObject();
		dao.setAutoTransaction(false);
		
		ArrayList<GoodsInfoBean> salesList;
		salesList = dao.getSalesList(gib,2);
		
		return salesList;
	}
	
	private void cancelOne(GoodsInfoBean gib) {
		dao.stackSalesInfo(2, gib);
	}
}
