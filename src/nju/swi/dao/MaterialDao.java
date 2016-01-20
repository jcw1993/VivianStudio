package nju.swi.dao;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class MaterialDao extends Model<MaterialDao> {

	private static final long serialVersionUID = 1L;

	public static final MaterialDao dao = new MaterialDao();
	
	public static List<MaterialDao> getByLevel(int levelId) {
		return dao.find("select * from material where level_id = ? order by created_time desc", levelId);
	}
	
	public static void delete(int id) {
		dao.deleteById(id);
	}
}
