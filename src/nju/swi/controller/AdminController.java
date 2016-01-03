package nju.swi.controller;

import java.util.Date;

import nju.swi.bll.manager.ManagerFactory;
import nju.swi.bll.model.Notification;
import nju.swi.bll.model.Student;
import nju.swi.common.GenericResult;
import nju.swi.common.NoneDataResult;
import nju.swi.common.ResultCode;

import com.jfinal.aop.Before;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.plugin.activerecord.Page;

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
	
	public void gradesManage() {
		renderJsp("admin/gradesManage");
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
