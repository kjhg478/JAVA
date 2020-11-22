package dto;

public class SrpBean {
	
	private String tename;
	private String suname;
	private String televel;
	private String grcode;
	private String clcode;
	private String stclcode;
	private String id;
	private String pw;
	private int servicecode;
	private String Comment;
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public int getServicecode() {
		return servicecode;
	}
	public void setServicecode(int servicecode) {
		this.servicecode = servicecode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTename() {
		return tename;
	}
	public void setTename(String tename) {
		this.tename = tename;
	}
	public String getSuname() {
		return suname;
	}
	public void setSuname(String suname) {
		this.suname = suname;
	}
	public String getTelevel() {
		return televel;
	}
	public void setTelevel(String televel) {
		this.televel = televel;
	}
	public String getGrcode() {
		return grcode;
	}
	public void setGrcode(String grcode) {
		this.grcode = grcode;
	}
	public String getClcode() {
		return clcode;
	}
	public void setClcode(String clcode) {
		this.clcode = clcode;
	}
	public String getStclcode() {
		return stclcode;
	}
	public void setStclcode(String stclcode) {
		this.stclcode = stclcode;
	}

}
