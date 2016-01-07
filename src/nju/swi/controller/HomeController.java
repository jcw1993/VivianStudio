package nju.swi.controller;

import nju.swi.bll.manager.ManagerFactory;
import nju.swi.bll.model.Student;
import nju.swi.common.GenericResult;
import nju.swi.common.NoneDataResult;
import nju.swi.common.ResultCode;

import com.jfinal.aop.Before;
import com.jfinal.ext.interceptor.POST;

public class HomeController extends BaseController {
	
	public void home() {
		renderJsp("home");
	}
	
	public void loginPage() {
		renderJsp("login");
	}
	
	public void schedule()
	{
		renderJsp("schedule");
	}
	
	@Before(POST.class)
	public void login() {
		String mail = getPara("mail");
		String password = getPara("password");
		
		GenericResult<Student> studentResult = ManagerFactory.getStudentManager().search(mail, password);
		renderJson(studentResult);
	}
	
	@Before(POST.class)
	public void logout() {
		renderJson(new NoneDataResult(ResultCode.OK));
	}

}
