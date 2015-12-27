package nju.swi.controller;

import nju.swi.bll.manager.ManagerFactory;
import nju.swi.bll.model.Material;
import nju.swi.common.GenericResult;
import nju.swi.common.ResultCode;

import com.jfinal.plugin.activerecord.Page;

public class StudentController extends BaseController {

	public void grades() {
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
		renderJsp("student/profile");
	}
}
