package nju.swi.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;

import nju.swi.bll.manager.ManagerFactory;
import nju.swi.bll.model.Grades;
import nju.swi.bll.model.Material;
import nju.swi.bll.model.Notification;
import nju.swi.bll.model.Student;
import nju.swi.common.Constants;
import nju.swi.common.GenericResult;
import nju.swi.common.NoneDataResult;
import nju.swi.common.ResultCode;
import nju.swi.util.CommonUtil;
import nju.swi.util.MyMultipartRequest;
import nju.swi.util.QiniuUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.aop.Before;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.plugin.activerecord.Page;
import com.qiniu.common.QiniuException;

public class AdminController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	// 学生管理
	public void studentManage() {
		String keyword = getPara("keyword");
		int page = getParaToInt("pageIndex");
		GenericResult<Page<Student>> studentResult = ManagerFactory.getStudentManager().search(keyword, page, Constants.DEFAULT_ITEM_OER_PAGE);
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
		
		NoneDataResult deleteResult = ManagerFactory.getStudentManager().delete(studentId);
		renderJson(deleteResult);
	}
	
	// 成绩管理
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
	public void createGrades() throws IOException, ServletException {
		MyMultipartRequest multipartRequest = new MyMultipartRequest(getRequest());
		String title = (String) multipartRequest.getPara("title");
		int levelId = Integer.parseInt((String)multipartRequest.getPara("levelId"));
		byte[] data = (byte[]) multipartRequest.getPara("fileData");
		String fileName = (String) multipartRequest.getPara("fileName");

		String url = null;
		if(null != data && data.length > 0) {
			String uuid = UUID.randomUUID().toString();
			try {
				url = QiniuUtil.uploadData(uuid, fileName, data, QiniuUtil.getMimeTypeBySuffix(CommonUtil.getFileSuffix(fileName)));
			} catch (QiniuException e) {
				logger.error(fileName + " upload failed", e);
				renderJson(new NoneDataResult(ResultCode.E_UPLOAD_FILE_FAILED));
				return;
			}
		}else {
			renderJson(new NoneDataResult(ResultCode.E_UPLOAD_FILE_FAILED));
			return;
		}
		Grades grades = new Grades();
		grades.setTitle(title);
		grades.setLevelId(levelId);
		grades.setUrl(url);
		
		GenericResult<Integer> createResult = ManagerFactory.getGradesManager().create(grades);
		renderJson(createResult);
	}
	
	@Before(POST.class)
	public void deleteGrades() {
		int gradesId = getParaToInt("gradesId");
		if(gradesId == 0) {
			renderJson(new NoneDataResult(ResultCode.E_INVALID_PARAMETER));
		}
		
		GenericResult<Grades> gradesResult = ManagerFactory.getGradesManager().getById(gradesId);
		if(gradesResult.getCode() == ResultCode.OK) {
			try {
				QiniuUtil.deleteFile(gradesResult.getData().getUrl());
			} catch (QiniuException e) {
				logger.error(e.getMessage(), e);
				renderJson(new NoneDataResult(ResultCode.E_DELETE_FILE_FAILED));
				return;
			}
			NoneDataResult deleteResult = ManagerFactory.getMaterialManager().delete(gradesId);
			renderJson(deleteResult);
		}else {
			renderJson(new NoneDataResult(ResultCode.E_INVALID_PARAMETER));
		}
		
		NoneDataResult deleteResult = ManagerFactory.getGradesManager().delete(gradesId);
		renderJson(deleteResult);
	}
	
	// 课件管理
	public void materialManage() {
		int levelId = getParaToInt("levelId");
		if(levelId < 1) {
			levelId = 1;
		}
		setAttr("levelId", levelId);
		GenericResult<List<Material>> materialResult = ManagerFactory.getMaterialManager().getByLevel(levelId);
		if(materialResult.getCode() == ResultCode.OK && null != materialResult.getData() && !materialResult.getData().isEmpty()) {
			setAttr("materialList", materialResult.getData());
		}
		renderJsp("admin/materialManage");
	}
	
	public void createMaterialPage() {
		renderJsp("admin/materialCreate");
	}
	
	public void createMaterialPost() throws IOException {
		MyMultipartRequest multipartRequest = new MyMultipartRequest(getRequest());
		String title = (String) multipartRequest.getPara("title");
		int levelId = Integer.parseInt((String)multipartRequest.getPara("levelId"));
		byte[] data = (byte[]) multipartRequest.getPara("fileData");
		String fileName = (String) multipartRequest.getPara("fileName");

		String url = null;
		if(null != data && data.length > 0) {
			String uuid = UUID.randomUUID().toString();
			try {
				url = QiniuUtil.uploadData(uuid, fileName, data, QiniuUtil.getMimeTypeBySuffix(CommonUtil.getFileSuffix(fileName)));
			} catch (QiniuException e) {
				logger.error(fileName + " upload failed", e);
				renderJson(new NoneDataResult(ResultCode.E_UPLOAD_FILE_FAILED));
				return;
			}
		}else {
			renderJson(new NoneDataResult(ResultCode.E_UPLOAD_FILE_FAILED));
			return;
		}
		
		Material material = new Material();
		material.setTitle(title);
		material.setLevelId(levelId);
		material.setUrl(url);
		
		GenericResult<Integer> createResult = ManagerFactory.getMaterialManager().create(material);
		renderJson(createResult);
	}
	
	public void deleteMaterial() {
		int materialId = getParaToInt("materialId");
		if(materialId == 0) {
			renderJson(new NoneDataResult(ResultCode.E_INVALID_PARAMETER));
		}
		GenericResult<Material> materialResult = ManagerFactory.getMaterialManager().getById(materialId);
		if(materialResult.getCode() == ResultCode.OK) {
			try {
				QiniuUtil.deleteFile(materialResult.getData().getUrl());
			} catch (QiniuException e) {
				logger.error(e.getMessage(), e);
				renderJson(new NoneDataResult(ResultCode.E_DELETE_FILE_FAILED));
				return;
			}
			NoneDataResult deleteResult = ManagerFactory.getMaterialManager().delete(materialId);
			renderJson(deleteResult);
		}else {
			renderJson(new NoneDataResult(ResultCode.E_INVALID_PARAMETER));
		}
	}
	
	// 通知管理
	public void notificationManage() {
		int page = getParaToInt("pageIndex");
		GenericResult<Page<Notification>> notificationResult = ManagerFactory.getNotificationManager().search(page, Constants.DEFAULT_ITEM_OER_PAGE);
		if(notificationResult.getCode() == ResultCode.OK && null != notificationResult.getData()) {
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
