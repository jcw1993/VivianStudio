package nju.swi.dao;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class MaterialDao extends Model<MaterialDao> {

	private static final long serialVersionUID = 1L;

	public static final MaterialDao dao = new MaterialDao();
	
	public static Page<MaterialDao> search(int page, int size) {
		return dao.paginate(page, size, "select *", "from material");
	}
}
