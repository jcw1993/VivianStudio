package nju.swi.dao;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class StudentHomeworkDao extends Model<StudentHomeworkDao> {
	
	private static final long serialVersionUID = 1L;
	public static StudentHomeworkDao dao = new StudentHomeworkDao();
	
	public static Page<StudentHomeworkDao> search(Integer studentId, int page, int size) {
		return dao.paginate(page, size, "select *", "from student_homework where student_id = ? or is null", studentId, studentId);
	}
	
}
