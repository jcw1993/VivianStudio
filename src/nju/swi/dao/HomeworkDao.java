package nju.swi.dao;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class HomeworkDao extends Model<HomeworkDao> {
	
	private static final long serialVersionUID = 1L;

	public static HomeworkDao dao = new HomeworkDao();
	
	public static List<HomeworkDao> getAll() {
		return dao.find("select * from homework");
	}
	
	public static Page<HomeworkDao> search(Integer studentId, int page, int size) {
		return dao.paginate(page, size, "select *", "from homework where student_id = ? or is null", studentId, studentId);
	}
	
}
