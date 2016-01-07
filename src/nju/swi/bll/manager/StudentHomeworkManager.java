package nju.swi.bll.manager;

import java.util.ArrayList;
import java.util.List;

import nju.swi.bll.model.StudentHomework;
import nju.swi.common.GenericResult;
import nju.swi.common.ResultCode;
import nju.swi.dao.StudentHomeworkDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.plugin.activerecord.Page;

public class StudentHomeworkManager {
	
	private static Logger logger = LoggerFactory.getLogger(HomeworkManager.class);
	
	public GenericResult<Integer> create(StudentHomework studentHomework) {
		GenericResult<Integer> result = new GenericResult<Integer>();
		StudentHomeworkDao studentHomeworkDao = studentHomework.toDao();
		int insertId = 0;
		try {
			studentHomeworkDao.save();
			insertId = studentHomeworkDao.getInt("id");
		} catch (Exception e) {
			result.setCode(ResultCode.E_DATABASE_INSERT_ERROR);
			logger.error("create studentHomework failed: " + e.getMessage());
		}
		
		if(insertId > 0) {
			result.setData(insertId);
		}else {
			result.setCode(ResultCode.E_OTHER_ERROR);
		}
		return result;
	}
	
	public GenericResult<Page<StudentHomework>> search(Integer studentId, Integer page, Integer size) {
		GenericResult<Page<StudentHomework>> result = new GenericResult<Page<StudentHomework>>();
		if(null == page || page < 1) {
			page = 1;
		}
		if(null == size || size < 1) {
			size = 1;
		}
		
		try {
			Page<StudentHomeworkDao> daoPage = StudentHomeworkDao.search(studentId, page, size);
			if(null != daoPage && null != daoPage.getList() && !daoPage.getList().isEmpty()) {
				List<StudentHomework> studentHomeworkList = new ArrayList<StudentHomework>();
				for(StudentHomeworkDao dao : daoPage.getList()) {
					studentHomeworkList.add(new StudentHomework(dao));
				}
				
				Page<StudentHomework> studentHomeworkPage = new Page<StudentHomework>(studentHomeworkList, daoPage.getPageNumber(), daoPage.getPageSize(), daoPage.getTotalPage(), daoPage.getTotalRow());
				result.setData(studentHomeworkPage);
			}
			
		}catch(Exception e) {
			result.setCode(ResultCode.E_DATABASE_GET_ERROR);
			logger.error("homework search error: " + e.getMessage());
		}
		
		return result;
	}
}
