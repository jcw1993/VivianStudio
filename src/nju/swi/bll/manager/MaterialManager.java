package nju.swi.bll.manager;

import java.util.ArrayList;
import java.util.List;

import nju.swi.bll.model.Material;
import nju.swi.common.GenericResult;
import nju.swi.common.NoneDataResult;
import nju.swi.common.ResultCode;
import nju.swi.dao.MaterialDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaterialManager {
	
	private static Logger logger = LoggerFactory.getLogger(MaterialManager.class);
	
	public GenericResult<List<Material>> getByLevel(int levelId) {
		GenericResult<List<Material>> result = new GenericResult<List<Material>>();
		try{
			List<MaterialDao> daos = MaterialDao.getByLevel(levelId);
			if(null != daos && !daos.isEmpty()) {
				List<Material> materials = new ArrayList<Material>();
				for(MaterialDao dao : daos) {
					materials.add(new Material(dao));
				}
				result.setData(materials);
			}else {
				result.setCode(ResultCode.E_NO_DATA);
			}
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			result.setCode(ResultCode.E_DATABASE_GET_ERROR);
		}
		return result;
	}
	
	public GenericResult<Material> getById(int id) {
		GenericResult<Material> result = new GenericResult<Material>();
		try {
			MaterialDao materialDao = MaterialDao.dao.findById(id);	
			result.setData(new Material(materialDao));
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			result.setCode(ResultCode.E_DATABASE_GET_ERROR);
		}
		return result;
	}
	
	public GenericResult<Integer> create(Material material) {
		GenericResult<Integer> result = new GenericResult<Integer>();
		try {
			MaterialDao materialDao = material.toDao();
			materialDao.save();
			result.setData(materialDao.getInt("id"));
		} catch (Exception e) {
			result.setCode(ResultCode.E_DATABASE_INSERT_ERROR);
			logger.error("create gardes error: " + e.getMessage(), e);
		}
		return result;
	}
	
	public NoneDataResult delete(int id) {
		NoneDataResult result = new NoneDataResult();
		try {
			MaterialDao.delete(id);
		} catch (Exception e) {
			result.setCode(ResultCode.E_DATABASE_DELETE_ERROR);
			logger.error("delete grades error: " + e.getMessage(), e);
		}
		return result;
	}
}
