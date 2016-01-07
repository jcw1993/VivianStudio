package nju.swi.dao;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class GradesDao extends Model<GradesDao> {

	private static final long serialVersionUID = 1L;

	public static GradesDao dao = new GradesDao();
	
	public static List<GradesDao> getByLevel(int levelId) {
		return dao.find("select * from grades where level_id = ? order by created_time desc", levelId);
	}
	
	public static void delete(int id) {
		dao.deleteById(id);
	}
}
