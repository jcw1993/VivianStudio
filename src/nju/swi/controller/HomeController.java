package nju.swi.controller;

import nju.swi.auth.AdminIdentity;
import nju.swi.auth.AuthService;
import nju.swi.auth.StudentIdentity;
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
		System.out.println("mail:" + mail);
		System.out.println("password:" + password);
		GenericResult<String> result = new GenericResult<String>();
		if(mail.equals("admin") && password.equals("admin")) {
			AdminIdentity identity = new AdminIdentity();
			AuthService.getInstance().setIdentity(identity, getRequest(), getResponse());
			result.setData("admin/gradesManage");
			renderJson(result);
			return;
		}
		
		GenericResult<Student> studentResult = ManagerFactory.getStudentManager().search(mail, password);
		if(studentResult.getCode() == ResultCode.OK) {
			StudentIdentity identity = new StudentIdentity();
			identity.setId(studentResult.getData().getId());
			identity.setMail(studentResult.getData().getMail());
			AuthService.getInstance().setIdentity(identity, getRequest(), getResponse());
			result.setData("student/grades");
		}else {
			result.setCode(ResultCode.E_NO_DATA);
		}
		renderJson(result);
	}
	
	@Before(POST.class)
	public void logout() {
		AuthService.getInstance().removeIdentity(getRequest(), getResponse());
		renderJson(new NoneDataResult(ResultCode.OK));
	}

}
