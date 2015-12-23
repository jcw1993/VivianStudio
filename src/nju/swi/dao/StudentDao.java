package nju.swi.dao;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class StudentDao extends Model<StudentDao>{
	
	private static final long serialVersionUID = 1L;

	public static final StudentDao studentDao = new StudentDao();
	
	public static List<StudentDao> getAll() {
		return studentDao.find("select * from student");
	}

	public static void delete(int id) {
		studentDao.deleteById(id);
	}
	
}
