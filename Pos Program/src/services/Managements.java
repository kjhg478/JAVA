package services;

import java.util.ArrayList;
import java.util.Comparator;
import data.DataAccessObject;
import data.GoodsInfoBean;

public class Managements {

	DataAccessObject dao;

	public Managements() {}

	public ArrayList<GoodsInfoBean> entrance(int reqValue, GoodsInfoBean gib) {
		ArrayList<GoodsInfoBean> goOut = null;
		switch (reqValue) {
		case 1:
			goodsReg(gib);
			break;

		case 2:
			goodsPriceMod(gib);;
			break;


		case 3:
			goOut = getDailySales(gib);;
			break;


		case 4:
			goOut = getBestGoods(gib);
			break;
		}

		return goOut;
	}

	// GOODS 등록
	private void goodsReg(GoodsInfoBean gib) {
		
		dao = new DataAccessObject();
		dao.setAutoTransaction(false);
		
		dao.goodsReg(3, gib);
	}

	// GOODS 가격정보 수정
	private void goodsPriceMod(GoodsInfoBean gib) {
		
		dao = new DataAccessObject();
		dao.setAutoTransaction(false);
		
		ArrayList<GoodsInfoBean> goodsList;

		goodsList = dao.goodsGetAll(3);

		for (int i = 0; i < goodsList.size(); i++) {
			if(goodsList.get(i).getGoodsCode().equals(gib.getGoodsCode())) {
				goodsList.get(i).setGoodsPrice(gib.getGoodsPrice());
				break;
			}
		}
		dao.goodsPriceMod(3, goodsList);
	}

	// GOODS HISTORY 가져오기
	private ArrayList<GoodsInfoBean> getDailySales(GoodsInfoBean gib) {
		
		dao = new DataAccessObject();
		dao.setAutoTransaction(false);
		
		ArrayList<GoodsInfoBean> goOut;
		goOut = dao.goodsGetHis(gib);

		return goOut;
	}



	// BEST 상품 추출
	private ArrayList<GoodsInfoBean> getBestGoods(GoodsInfoBean gib) {
		
		dao = new DataAccessObject();
		dao.setAutoTransaction(false);
		
		ArrayList<GoodsInfoBean> histories;
		ArrayList<GoodsInfoBean> goOut = null;
		histories = dao.goodsGetHis(gib);
		

		for(GoodsInfoBean i : histories) {
			if(goOut==null) {
				goOut = new ArrayList<GoodsInfoBean>();
				goOut.add(i);
			}else {
				boolean flag = true; 
				for (int j = 0; j < goOut.size(); j++) {
					if(i.getGoodsName().equals(goOut.get(j).getGoodsName())){
						goOut.get(j).setGoodsqty(goOut.get(j).getGoodsqty() + i.getGoodsqty());
						flag = false;
						break;
					}
				}
				if (flag) {goOut.add(i);}
			}
		}
		
		
		if (goOut!=null) {
			goOut.sort(new Comparator<GoodsInfoBean>() {

				public int compare(GoodsInfoBean arg0, GoodsInfoBean arg1) {
					
					return arg1.getGoodsqty() - arg0.getGoodsqty();
				}
			});

		}

		return goOut;
	}




















}
