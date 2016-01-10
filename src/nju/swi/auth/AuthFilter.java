package nju.swi.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class AuthFilter implements Filter {
	
	private static Logger logger = LoggerFactory.getLogger(AuthFilter.class);
	
	private static String[] unLimitedUrls = { "/home", "/schedule", "/contact", "/news", "/introduction", "/loginPage", "/login", "/register", "/registerPage", "/logout", "/assets\\/.*"};

	private static ArrayList<Pattern> unLimitedPatterns = new ArrayList<Pattern>();

	static {
		unLimitedPatterns = new ArrayList<Pattern>();
		for (String unLimitedUrl : unLimitedUrls) {
			unLimitedPatterns.add(Pattern.compile(unLimitedUrl));
		}
	}
	
	private Gson gson = null;

	@Override
	public void destroy() {
		logger.info("AuthFilter destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		String servletPath = httpServletRequest.getServletPath();
		String baseUrl = httpServletRequest.getContextPath();
		
		boolean authencated = false;
		authencated |= urlMathPatterns(servletPath, unLimitedPatterns);
		
		
		if(!authencated) {
			Identity identity = AuthService.getInstance().getIdentity(httpServletRequest);
			if(null == identity) {
				httpServletResponse.sendRedirect(baseUrl + "/home");
				return;
			}
			
			if(identity instanceof StudentIdentity) {
				
			}else if(identity instanceof AdminIdentity) {

			}else {
				httpServletResponse.sendRedirect(baseUrl + "/home");
				return;
			}
		}
		
		chain.doFilter(request, response);
		return;
	}
	
	private static boolean urlMathPatterns(String url, ArrayList<Pattern> patterns) {
		for (Pattern pattern : patterns) {
			Matcher matcher = pattern.matcher(url);
			if (matcher.matches()) {
				return true;
			}
		}

		return false;
	}

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("AuthencationFilter init");
		if(null == gson) {
			gson = new Gson();
		}
	}
}
