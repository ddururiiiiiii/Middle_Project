package kr.or.ddit.user.vo;

public class UserVO {

	private String userId;
	private String userName;
	private String userPw;
	private String userNickName;
	private String userBir;
	private String userGender;
	private String userTel;
	private String userEmail;
	private String likeyCode;
	private String userZip;
	private String userAdd1;
	private String userAdd2;
	//private String userMoney = null;
	private int userMoney = 0;
	private String adminCk = "N";
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserBir() {
		return userBir;
	}
	public void setUserBir(String userBir) {
		this.userBir = userBir;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getLikeyCode() {
		return likeyCode;
	}
	public void setLikeyCode(String likeyCode) {
		this.likeyCode = likeyCode;
	}
	public String getUserZip() {
		return userZip;
	}
	public void setUserZip(String userZip) {
		this.userZip = userZip;
	}
	public String getUserAdd1() {
		return userAdd1;
	}
	public void setUserAdd1(String userAdd1) {
		this.userAdd1 = userAdd1;
	}
	public String getUserAdd2() {
		return userAdd2;
	}
	public void setUserAdd2(String userAdd2) {
		this.userAdd2 = userAdd2;
	}
	public int getUserMoney() {
		return userMoney;
	}
	public void setUserMoney(int userMoney) {
		this.userMoney = userMoney;
	}
	
	public String getAdminCk() {
		return adminCk;
	}
	public void setAdminCk(String adminCk) {
		this.adminCk = adminCk;
	}

	
}
