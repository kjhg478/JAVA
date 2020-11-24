package dto;

public class BoardDTO {
	// 필드
	String bWriter;
	String bPassword;
	String bTitle;
	String bContent;
	String bDate;
	
	// getter, setter
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbPassword() {
		return bPassword;
	}
	public void setbPassword(String bPassword) {
		this.bPassword = bPassword;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "BoardDTO [bWriter=" + bWriter + ", bPassword=" + bPassword + ", bTitle=" + bTitle + ", bContent="
				+ bContent + ", bDate=" + bDate + "]";
	}
	
	
	
}
