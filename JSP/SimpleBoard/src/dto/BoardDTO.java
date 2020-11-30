package dto;

public class BoardDTO {
	
	private int Num;
	private String Title;
	private String Name;
	private String Password;
	private String Content;
	private String Date;
	private int Hit;
	private String File;
	
	@Override
	public String toString() {
		return "BoardDTO [Num=" + Num + ", Title=" + Title + ", Name=" + Name + ", Password=" + Password + ", Content="
				+ Content + ", Date=" + Date + ", Hit=" + Hit + ", File=" + File + "]";
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		this.Num = num;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		this.Content = content;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		this.Date = date;
	}
	public int getHit() {
		return Hit;
	}
	public void setHit(int hit) {
		this.Hit = hit;
	}
	public String getFile() {
		return File;
	}
	public void setFile(String file) {
		this.File = file;
	}


}
