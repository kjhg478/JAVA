package data;

public class GoodsInfoBean {
	
	

	private String uniqCode;
	private String goodsCode;
	private String goodsName;
	private int goodsPrice;
	private int goodsqty;
	private String expireDate;
	private String safetyQty;
	private int Amount;
	
	
	
	
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getSafetyQty() {
		return safetyQty;
	}
	public void setSafetyQty(String safetyQty) {
		this.safetyQty = safetyQty;
	}
	public String getUniqCode() {
		return uniqCode;
	}
	public void setUniqCode(String uniqCode) {
		this.uniqCode = uniqCode;
	}

	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsqty() {
		return goodsqty;
	}
	public void setGoodsqty(int goodsqty) {
		this.goodsqty = goodsqty;
	}
	
}
