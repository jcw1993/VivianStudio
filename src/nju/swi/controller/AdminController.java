package nju.swi.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import nju.swi.bll.manager.ManagerFactory;
import nju.swi.bll.model.Grades;
import nju.swi.bll.model.Notification;
import nju.swi.bll.model.Student;
import nju.swi.common.GenericResult;
import nju.swi.common.NoneDataResult;
import nju.swi.common.ResultCode;

import com.jfinal.aop.Before;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.upload.UploadFile;

public class AdminController extends BaseController {
	
	public void studentManage() {
		String keyword = getPara("keyword");
		int page = getParaToInt("pageIndex");
		int size = getParaToInt("pageSize");
		GenericResult<Page<Student>> studentResult = ManagerFactory.getStduentManager().search(keyword, page, 10);
		if(studentResult.getCode() == ResultCode.OK) {
			setAttr("students", studentResult.getData().getList());
			setAttr("baseUrl", "studentManage");
			setAttr("pageIndex", page);
			setAttr("itemCount", studentResult.getData().getTotalRow());
			setAttr("itemsPerPage", 10);
		}
		renderJsp("admin/studentManage");
	}
	
	@Before(POST.class)
	public void deleteStudent() {
		int studentId = getParaToInt("studentId");
		if(studentId < 1) {
			renderJson(new NoneDataResult(ResultCode.E_INVALID_PARAMETER));
		}
		
		NoneDataResult deleteResult = ManagerFactory.getStduentManager().delete(studentId);
		renderJson(deleteResult);
	}
	
	public void gradesManage() {
		int levelId = getParaToInt("levelId");
		if(levelId < 1) {
			levelId = 1;
		}
		setAttr("levelId", levelId);
		GenericResult<List<Grades>> gradesResult = ManagerFactory.getGradesManager().getByLevel(levelId);
		if(gradesResult.getCode() == ResultCode.OK && null != gradesResult.getData() && !gradesResult.getData().isEmpty()) {
			setAttr("gradesList", gradesResult.getData());
		}
		renderJsp("admin/gradesManage");
	}
	
	public void createGradesPage() {
		renderJsp("admin/gradesCreate");
	}
	
	@Before(POST.class)
	public void createGrades() {
		UploadFile uploadFile = getFile();
		File file = null;
		int levelId = getParaToInt("levelId");
		if(null != uploadFile && null != (file = uploadFile.getFile())) {
			
		}
	}
	
	@Before(POST.class)
	public void deleteGrades() {
		int gradesId = getParaToInt("gradesId");
		if(gradesId == 0) {
			renderJson(new NoneDataResult(ResultCode.E_INVALID_PARAMETER));
		}
		
		NoneDataResult deleteResult = ManagerFactory.getGradesManager().delete(gradesId);
		renderJson(deleteResult);
	}
	
	public void notificationManage() {
		int page = getParaToInt("pageIndex");
		int size = getParaToInt("pageSize");
		GenericResult<Page<Notification>> notificationResult = ManagerFactory.getNotificationManager().search(page, 10);
		if(notificationResult.getCode() == ResultCode.OK) {
			setAttr("notifications", notificationResult.getData().getList());
			setAttr("baseUrl", "notificationManage");
			setAttr("pageIndex", page);
			setAttr("itemCount", notificationResult.getData().getTotalRow());
			setAttr("itemsPerPage", 10);
		}
		renderJsp("admin/notificationManage");
	}
	
	public void homeworkManage() {
		renderJsp("admin/homeworkManage");
	}
	
	@Before(POST.class)                                        
	public void deleteNotification() {
		int notificationId = getParaToInt("notificationId");
		NoneDataResult deleteResult = ManagerFactory.getNotificationManager().delete(notificationId);
		renderJson(deleteResult);
	}
	
	public void createNotificationPage() {
		renderJsp("admin/notificationCreate");
	}
	
	@Before(POST.class)
	public void createNotification() {
		String title = getPara("title");
		String content = getPara("content");
		Notification notification = new Notification();
		notification.setTitle(title);
		notification.setContent(content);
		notification.setCreatedTime(new Date());
		GenericResult<Integer> createResult = ManagerFactory.getNotificationManager().create(notification);
		renderJson(createResult);
	}
 }
