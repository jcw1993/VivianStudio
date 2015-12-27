package nju.swi.bll.manager;

import java.util.ArrayList;
import java.util.List;

import nju.swi.bll.model.Material;
import nju.swi.common.GenericResult;
import nju.swi.common.ResultCode;
import nju.swi.dao.MaterialDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.plugin.activerecord.Page;

public class MaterialManager {
	private static Logger logger = LoggerFactory.getLogger(MaterialManager.class);
	
	public static final int MATERIAL_DEFAULT_PAGE_SIZE = 10;

	public GenericResult<Page<Material>> search(Integer page, Integer size) {
		GenericResult<Page<Material>> result = new GenericResult<Page<Material>>();
		if(null == page || page < 1) {
			page = 1;
		}
		if(null == size || size < 1) {
			size = MATERIAL_DEFAULT_PAGE_SIZE;
		}
		
		try {
			Page<MaterialDao> daoPage = MaterialDao.search(page, size);
			if(null != daoPage && null != daoPage.getList() && !daoPage.getList().isEmpty()) {
				
				List<Material> materialList = new ArrayList<Material>();
				for(MaterialDao dao : daoPage.getList()) {
					materialList.add(new Material(dao));
				}
				
				Page<Material> materiaPage = new Page<Material>(materialList, daoPage.getPageNumber(), daoPage.getPageSize(), daoPage.getTotalPage(), daoPage.getTotalRow());
				result.setData(materiaPage);
			}
		}catch(Exception e) {
			result.setCode(ResultCode.E_DATABASE_GET_ERROR);
			logger.error("comment search error: " + e.getMessage());
		}
		return result;
	}
}
