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
import com.jfinal.plugin.ehcache.CacheKit;

public class HomeworkManager {
	private static Logger logger = LoggerFactory.getLogger(HomeworkManager.class);
	private static final String ALL_HOMEWORK_KEY = "AllHomework";
	
	public GenericResult<List<Homework>> getAll() {
		GenericResult<List<Homework>> result = new GenericResult<List<Homework>>();
		List<Homework> allHomework = CacheKit.get(Homework.class.getName(), ALL_HOMEWORK_KEY);
		if(null != allHomework && !allHomework.isEmpty()) {
			result.setData(allHomework);
		}else {
			try {
				List<HomeworkDao> homeworkDaos = HomeworkDao.getAll();
				if(null != homeworkDaos && !homeworkDaos.isEmpty()) {
					allHomework = new ArrayList<Homework>();
					for(HomeworkDao dao : homeworkDaos) {
						Homework homework = new Homework(dao);
						allHomework.add(homework);
					}
				}
				CacheKit.put(Homework.class.getName(), ALL_HOMEWORK_KEY, allHomework);
				result.setData(allHomework);
			}catch(Exception e) {
				result.setCode(ResultCode.E_DATABASE_GET_ERROR);
				logger.error("HomeworkManager getAll failed: " + e.getMessage());
			}
			
		}
		return result;
	}
	
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
			CacheKit.remove(Homework.class.getName(), ALL_HOMEWORK_KEY);
		}else {
			result.setCode(ResultCode.E_OTHER_ERROR);
		}
		return result;
	}
	
	public GenericResult<Page<Homework>> search(Integer page, Integer size) {
		GenericResult<Page<Homework>> result = new GenericResult<Page<Homework>>();
		GenericResult<List<Homework>> allResult = getAll();
		if(allResult.getCode() == ResultCode.OK) {
			int startIndex = (page - 1) * size;
			int count = 0;
			List<Homework> homeworkList = new ArrayList<Homework>();
			int endIndex = Math.min(startIndex + size, allResult.getData().size());
			for(int i = startIndex; i < endIndex; i++) {
				homeworkList.add(allResult.getData().get(i));
			}
			Page<Homework> notificationPage = new Page<Homework>(homeworkList, page, size, count / size, count);
			result.setData(notificationPage);
		}else {
			result.setCode(allResult.getCode());
		}
		return result;
	}
}
