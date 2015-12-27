package nju.swi.bll.manager;

import java.util.ArrayList;
import java.util.List;

import nju.swi.bll.model.Homework;
import nju.swi.common.GenericResult;
import nju.swi.common.ResultCode;
import nju.swi.dao.HomeworkDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.plugin.activerecord.Page;

public class HomeworkManager {
	
	private static Logger logger = LoggerFactory.getLogger(HomeworkManager.class);
	
	public GenericResult<Integer> create(Homework homework) {
		GenericResult<Integer> result = new GenericResult<Integer>();
		HomeworkDao homeworkDao = homework.toDao();
		int insertId = 0;
		try {
			homeworkDao.save();
			insertId = homeworkDao.getInt("id");
		} catch (Exception e) {
			result.setCode(ResultCode.E_DATABASE_INSERT_ERROR);
			logger.error("create homework failed: " + e.getMessage());
		}
		
		if(insertId > 0) {
			result.setData(insertId);
		}else {
			result.setCode(ResultCode.E_OTHER_ERROR);
		}
		return result;
	}
	
	public GenericResult<Page<Homework>> search(Integer studentId, Integer page, Integer size) {
		GenericResult<Page<Homework>> result = new GenericResult<Page<Homework>>();
		if(null == page || page < 1) {
			page = 1;
		}
		if(null == size || size < 1) {
			size = 1;
		}
		
		try {
			Page<HomeworkDao> daoPage = HomeworkDao.search(studentId, page, size);
			if(null != daoPage && null != daoPage.getList() && !daoPage.getList().isEmpty()) {
				
				List<Homework> homeworkList = new ArrayList<Homework>();
				for(HomeworkDao dao : daoPage.getList()) {
					homeworkList.add(new Homework(dao));
				}
				
				Page<Homework> homeworkPage = new Page<Homework>(homeworkList, daoPage.getPageNumber(), daoPage.getPageSize(), daoPage.getTotalPage(), daoPage.getTotalRow());
				result.setData(homeworkPage);
			}
			
		}catch(Exception e) {
			result.setCode(ResultCode.E_DATABASE_GET_ERROR);
			logger.error("homework search error: " + e.getMessage());
		}
		
		return result;
	}

}
