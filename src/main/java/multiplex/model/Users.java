package multiplex.model;

public class Users {

	private int userId;
	private String password;
	private String userName;
	private char userType;
	private String mobileNo;
	private String emailId;

	

	public Users(int userId, String password, String userName, char userType, String mobileNo, String emailId) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.userType = userType;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}
	public Users() {}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char getUserType() {
		return userType;
	}

	public void setUserType(char userType) {
		this.userType = userType;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
