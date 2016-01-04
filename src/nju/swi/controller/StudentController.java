package nju.swi.controller;

import java.util.List;

import nju.swi.bll.manager.ManagerFactory;
import nju.swi.bll.model.Grades;
import nju.swi.bll.model.Material;
import nju.swi.bll.model.Student;
import nju.swi.common.GenericResult;
import nju.swi.common.ResultCode;

import com.jfinal.plugin.activerecord.Page;

public class StudentController extends BaseController {

	public void grades() {
		// TODO: get login student object
		int studentId = 1;
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
		int studentId = 1;
		GenericResult<Student> studentResult = ManagerFactory.getStudentManager().getById(studentId);
		if(studentResult.getCode() == ResultCode.OK) {
			setAttr("student", studentResult.getData());
		}
		renderJsp("student/profile");
	}
	
}
