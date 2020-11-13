package data;

public class UserInfoBean {
	
	

	private String Today;
	private String Emcode;
	private String Cmcode;
	private String stCode;
	private String employeeCode;
	private String accessCode;
	private String userName;
	private int accessState;
	private boolean userLevel; // true : manager   false : mate
	private String accessTime;
	
	
	public String getToday() {
		return Today;
	}
	public void setToday(String today) {
		Today = today;
	}
	public String getEmcode() {
		return Emcode;
	}
	public void setEmcode(String emcode) {
		Emcode = emcode;
	}
	public String getCmcode() {
		return Cmcode;
	}
	public void setCmcode(String cmcode) {
		Cmcode = cmcode;
	}
	public String getStCode() {
		return stCode;
	}
	public void setStCode(String stCode) {
		this.stCode = stCode;
	}
	public String getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getAccessCode() {
		return accessCode;
	}
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAccessState() {
		return accessState;
	}
	public void setAccessState(int accessState) {
		this.accessState = accessState;
	}
	public boolean isUserLevel() {
		return userLevel;
	}
	public void setUserLevel(boolean userLevel) {
		this.userLevel = userLevel;
	}
}
