package nju.swi.auth;

public class AdminIdentity extends Identity {

	public AdminIdentity() {
		setUserType(USER_TYPE_ADMIN);
	}
	
	public AdminIdentity(Identity identity) {
		setId(identity.getId());
		setUserType(USER_TYPE_ADMIN);
		setMail(identity.getMail());
	}
}
