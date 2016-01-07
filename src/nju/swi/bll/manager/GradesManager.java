package nju.swi.bll.manager;

import java.util.ArrayList;
import java.util.List;

import nju.swi.bll.model.Grades;
import nju.swi.common.GenericResult;
import nju.swi.common.NoneDataResult;
import nju.swi.common.ResultCode;
import nju.swi.dao.GradesDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GradesManager {
	
	private static Logger logger = LoggerFactory.getLogger(GradesManager.class);
	
	public GenericResult<List<Grades>> getByLevel(int levelId) {
		GenericResult<List<Grades>> result = new GenericResult<List<Grades>>();
		try{
			List<GradesDao> daos = GradesDao.getByLevel(levelId);
			if(null != daos && !daos.isEmpty()) {
				List<Grades> grades = new ArrayList<Grades>();
				for(GradesDao dao : daos) {
					grades.add(new Grades(dao));
				}
				result.setData(grades);
			}else {
				result.setCode(ResultCode.E_NO_DATA);
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
			result.setCode(ResultCode.E_DATABASE_GET_ERROR);
		}
		return result;
	}
	
	public GenericResult<Integer> create(Grades grades) {
		GenericResult<Integer> result = new GenericResult<Integer>();
		try {
			GradesDao gradesDao = grades.toDao();
			gradesDao.save();
			result.setData(gradesDao.getInt("id"));
		} catch (Exception e) {
			result.setCode(ResultCode.E_DATABASE_INSERT_ERROR);
			logger.error("create gardes error: " + e.getMessage());
		}
		return result;
	}
	
	public NoneDataResult delete(int id) {
		NoneDataResult result = new NoneDataResult();
		// TODO: delete cdn resource file
		try {
			GradesDao.delete(id);
		} catch (Exception e) {
			result.setCode(ResultCode.E_DATABASE_DELETE_ERROR);
			logger.error("delete grades error: " + e.getMessage());
		}
		return result;
	}
}
