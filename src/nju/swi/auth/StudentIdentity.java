package nju.swi.auth;

public class StudentIdentity extends Identity {
	 
	public StudentIdentity() {
		setUserType(USER_TYPE_STUDENT);
	}
	
	public StudentIdentity(Identity identity) {
		setId(identity.getId());
		setUserType(USER_TYPE_STUDENT);
		setMail(identity.getMail());
	}

}
