package nju.swi.auth;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class AuthService {
	
	private static Logger logger = LoggerFactory.getLogger(AuthService.class); 
	private static String IDENTITY_COOKIE_KEY = "identity";
	
	private static AuthService instance = null;
	
	public static AuthService getInstance() {
		if(null == instance) {
			instance = new AuthService();
		}
		return instance;
	}
	
 	public void setIdentity(Identity identity, HttpServletRequest request, HttpServletResponse response) {
 		Gson gsonSerializer = new Gson();
		Cookie cookie;
		try {
			cookie = new Cookie(IDENTITY_COOKIE_KEY, URLEncoder.encode(gsonSerializer.toJson(identity), "UTF-8"));
			cookie.setMaxAge(Integer.MAX_VALUE);
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		}
 	}
	
	public Identity getIdentity(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		Identity identity = null;
		
		Gson gson = new Gson();
		if(null != cookies && cookies.length > 0) {
			try {
				for(Cookie cookie : cookies) {
					String userToken = URLDecoder.decode(cookie.getValue(), "UTF-8");
					
					if(cookie.getName().equals(IDENTITY_COOKIE_KEY)) {
						identity = gson.fromJson(userToken, Identity.class);
						if(identity.getUserType() == Identity.USER_TYPE_STUDENT) {
							identity = new StudentIdentity(identity);
						}else {
							identity = new AdminIdentity(identity); 
						}
						break;
					}
				} 
			} catch (UnsupportedEncodingException e) {
				logger.error(e.getMessage());
			}
			
		}
		return identity;
	}
	
	public void removeIdentity(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if(null == cookies) {
			return;
		}
		
		for(Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			cookie.setValue(null);
			response.addCookie(cookie);
		}
	}
	
}
