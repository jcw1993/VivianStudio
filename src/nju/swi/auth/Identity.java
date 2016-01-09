package nju.swi.auth;

public class Identity {
	
	public static final int USER_TYPE_STUDENT = 1;
	public static final int USER_TYPE_ADMIN = 2;
	
	private int id;
	private int userType;
	private String mail;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
