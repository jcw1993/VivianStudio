package nju.swi.auth;

import javax.servlet.http.HttpServletRequest;

import nju.swi.util.UserInfoStorage;

public class AuthService {
	
	private static AuthService instance = null;
	
	public static AuthService getInstance() {
		if(null == instance) {
			instance = new AuthService();
		}
		return instance;
	}
	
 	public void setIdentity(Identity identity, HttpServletRequest request) {
 		if(null == identity) {
 			return;
 		}
 		
 		if(identity instanceof AdminIdentity) {
 			UserInfoStorage.putAdmin(request.getSession().getId(), identity);
 		}else {
 			UserInfoStorage.putMember(request.getSession().getId(), identity);
 		}
  	}
	
	public Identity getIdentity(HttpServletRequest request) {
		Identity identity = (AdminIdentity) UserInfoStorage.getAdmin(request.getSession().getId());
		if(null == identity) {
			identity = (StudentIdentity) UserInfoStorage.getMember(request.getSession().getId());
		}

		return identity;
	}
	
	public void removeIdentity(HttpServletRequest request) {
		UserInfoStorage.removeAdmin(request.getSession().getId());
		UserInfoStorage.removeMember(request.getSession().getId());
	}
	
}
