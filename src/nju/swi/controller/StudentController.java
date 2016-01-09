package nju.swi.controller;

import java.util.List;

import nju.swi.auth.AuthService;
import nju.swi.bll.manager.ManagerFactory;
import nju.swi.bll.model.Grades;
import nju.swi.bll.model.Material;
import nju.swi.bll.model.Notification;
import nju.swi.bll.model.Student;
import nju.swi.common.GenericResult;
import nju.swi.common.NoneDataResult;
import nju.swi.common.ResultCode;

import com.jfinal.aop.Before;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.plugin.activerecord.Page;

public class StudentController extends BaseController {

	public void grades() {
		// TODO: get login student object
		int studentId = AuthService.getInstance().getIdentity(getRequest()).getId();
		GenericResult<Student> studentResult = ManagerFactory.getStudentManager().getById(studentId);
		if(studentResult.getCode() == ResultCode.OK) {
			GenericResult<List<Grades>> gradesResult = ManagerFactory.getGradesManager().getByLevel(studentResult.getData().getLevelId());
			if(gradesResult.getCode() == ResultCode.OK && null != gradesResult.getData() && !gradesResult.getData().isEmpty()) {
				setAttr("gradesList", gradesResult.getData());
			}
		}
		renderJsp("student/grades");
	}
	
	public void uploadPage() {
		renderJsp("student/upload");
	}
	
	public void download() {
		int page = getParaToInt("pageIndex");
		int size = getParaToInt("pageSize");
		GenericResult<Page<Material>> materialResult = ManagerFactory.getMaterialManager().search(page, size);
		if(materialResult.getCode() == ResultCode.OK && null != materialResult.getData()) {
			setAttr("materials", materialResult.getData().getList());
			setAttr("baseUrl", "download");
			setAttr("pageIndex", page);
			setAttr("itemCount", materialResult.getData().getTotalRow());
			setAttr("itemsPerPage", 10);
		}
		renderJsp("student/download");
	}
	
	public void profile() {
		int studentId = AuthService.getInstance().getIdentity(getRequest()).getId();
		GenericResult<Student> studentResult = ManagerFactory.getStudentManager().getById(studentId);
		if(studentResult.getCode() == ResultCode.OK) {
			setAttr("student", studentResult.getData());
		}
		renderJsp("student/profile");
	}
	
	public void profileEdit() {
		int studentId = AuthService.getInstance().getIdentity(getRequest()).getId();
		GenericResult<Student> studentResult = ManagerFactory.getStudentManager().getById(studentId);
		if(studentResult.getCode() == ResultCode.OK) {
			setAttr("student", studentResult.getData());
		}
		renderJsp("student/profileEdit");
	}
	
	@Before(POST.class)
	public void updateProfile() {
		int studentId = AuthService.getInstance().getIdentity(getRequest()).getId();
		GenericResult<Student> studentResult = ManagerFactory.getStudentManager().getById(studentId);
		if(studentResult.getCode() == ResultCode.OK) {
			setAttr("student", studentResult.getData());
		}
		String name = getPara("name");
		String sex = getPara("sex");
		String password = getPara("password");
		String qq = getPara("qq");
		String phone = getPara("phone");
		String mail = getPara("mail");
		String address = getPara("address");
		Student student = studentResult.getData();
		student.setName(name);
		student.setQq(qq);
		student.setPhone(phone);
		student.setMail(mail);
		student.setAddress(address);
		student.setSex(sex);
		student.setPassword(password);
		NoneDataResult updateResult = ManagerFactory.getStudentManager().update(student);
		renderJson(updateResult);
	}
	
	public void notificationList() {
		GenericResult<List<Notification>> notificationResult = ManagerFactory.getNotificationManager().getAll();
		if(notificationResult.getCode() == ResultCode.OK) {
			setAttr("notifications", notificationResult.getData());
		}
		renderJsp("student/notificationList");
	}
	
	public void notificationDetail() {
		int notificationId = getParaToInt("notificationId");
		GenericResult<Notification> notificationResult = ManagerFactory.getNotificationManager().getById(notificationId);
		if(notificationResult.getCode() == ResultCode.OK) {
			setAttr("notification", notificationResult.getData());
		}
		renderJsp("student/notificationDetail");
	}
	
	
}
