package calendar.datadase;

public class UserVO {
	/*
	CREATE TABLE userInfo(
		    user_id VARCHAR2(20) PRIMARY KEY,
		    user_pw VARCHAR2(20) NOT NULL,
		    user_name VARCHAR2(20) NOT NULL,
		    user_birth NUMBER NOT NULL,
		    user_phone NUMBER NOT NULL
		    );
		    */
	
	
	private String userId;
	private String userPw;
	private String userName;
	private Integer userBirth;
	private Integer userPhone;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(Integer userBirth) {
		this.userBirth = userBirth;
	}
	public Integer getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(Integer userPhone) {
		this.userPhone = userPhone;
	}
	
	
	
}
