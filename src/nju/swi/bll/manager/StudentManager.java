package nju.swi.bll.manager;

import java.util.ArrayList;
import java.util.List;

import nju.swi.bll.model.Student;
import nju.swi.common.GenericResult;
import nju.swi.common.NoneDataResult;
import nju.swi.common.ResultCode;
import nju.swi.dao.StudentDao;

import org.apache.commons.lang3.StringUtils;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.ehcache.CacheKit;

public class StudentManager {
	
	private static Logger logger = Logger.getLogger(StudentManager.class);
	
	private static final String ALL_STUDENT_KEY = "AllStudents";
	
	public GenericResult<List<Student>> getAll() {
		GenericResult<List<Student>> result = new GenericResult<List<Student>>();
		List<Student> allStudents = CacheKit.get(Student.class.getName(), ALL_STUDENT_KEY);
		if(null != allStudents && !allStudents.isEmpty()) {
			result.setData(allStudents);
		}else {
			try {
				List<StudentDao> studentDaos = StudentDao.getAll();
				if(null != studentDaos && !studentDaos.isEmpty()) {
					allStudents = new ArrayList<Student>();
					for(StudentDao dao : studentDaos) {
						Student student = new Student(dao);
						allStudents.add(student);
					}
				}
				CacheKit.put(Student.class.getName(), ALL_STUDENT_KEY, allStudents);
				result.setData(allStudents);
			}catch(Exception e) {
				result.setCode(ResultCode.E_DATABASE_GET_ERROR);
				logger.error("StudentManager getAll failed: " + e.getMessage());
			}
			
		}
		return result;
	}
	
	public GenericResult<Page<Student>> search(String keyword, Integer page, Integer size) {
		if(null != keyword) {
			keyword = keyword.trim();
		}
		if(null == page || page < 1) {
			page = 1;
		}
		if(null == size || size < 1) {
			size = 1;
		}
		
		GenericResult<Page<Student>> result = new GenericResult<Page<Student>>();
		GenericResult<List<Student>> allResult = getAll();
		if(allResult.getCode() == ResultCode.OK) {
			int startIndex = (page - 1) * size;
			int endIndex = startIndex + size;
			int count = 0;
			List<Student> studentList = new ArrayList<Student>();
			for(Student student : allResult.getData()) {
				if(StringUtils.isBlank(keyword) || (student.getName().contains(keyword))) {
					if(count >= startIndex) {
						studentList.add(student);
					}
					count++;
					if(count >= endIndex) {
						break;
					}
				}
			}
			Page<Student> studentPage = new Page<Student>(studentList, page, size, count / size, count);
			result.setData(studentPage);
		}else {
			result.setCode(allResult.getCode());
		}
		return result;
	}
	
	public GenericResult<Student> getById(int id) {
		GenericResult<Student> result = new GenericResult<Student>();
		GenericResult<List<Student>> allResult = getAll();
		if(allResult.getCode() == ResultCode.OK) {
			if(null != allResult.getData() && !allResult.getData().isEmpty()) {
				for(Student student : allResult.getData()) {
					if(student.getId() == id) {
						result.setData(student);
						break;
					}
				}
			}
		}else {
			result.setCode(allResult.getCode());
			result.setMessage(allResult.getMessage());
		}
		return result;
	} 
	
	public GenericResult<Integer> create(Student student) {
		GenericResult<Integer> result = new GenericResult<Integer>();
		try {
			StudentDao studentDao = student.toDao();
			studentDao.save();
			result.setData(studentDao.getInt("id"));
			CacheKit.remove(Student.class.getName(), ALL_STUDENT_KEY);
		} catch (Exception e) {
			result.setCode(ResultCode.E_DATABASE_INSERT_ERROR);
			logger.error("create user error: " + e.getMessage());
		}
		return result;
	}
	
	public NoneDataResult update(Student student) {
		NoneDataResult result = new NoneDataResult();
		try {
			student.toDao().update();
			CacheKit.remove(Student.class.getName(), ALL_STUDENT_KEY);
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ResultCode.E_DATABASE_UPDATE_ERROR);
			logger.error("update user error: " + e.getMessage());
		}
		return result;
	}
	
	public NoneDataResult delete(int id) {
		NoneDataResult result = new NoneDataResult();
		try {
			StudentDao.delete(id);
		} catch (Exception e) {
			result.setCode(ResultCode.E_DATABASE_DELETE_ERROR);
			logger.error("delete user error: " + e.getMessage());
		}
		CacheKit.remove(Student.class.getName(), ALL_STUDENT_KEY);
		return result;
	}
	
	public GenericResult<Student> search(String mail, String password) {
		GenericResult<Student> result = new GenericResult<Student>();
		if(StringUtils.isBlank(mail) || StringUtils.isBlank(password)) {
			result.setCode(ResultCode.E_INVALID_PARAMETER);
			return result;
		}
		
		GenericResult<List<Student>> allResult = getAll();
		if(allResult.getCode() == ResultCode.OK) {
			boolean mailExists = false;
			for(Student student : allResult.getData()) {
				if(student.getMail().equals(mail)) {
					mailExists = true;
					break;
				}
			}
			if(!mailExists) {
				result.setCode(ResultCode.E_MAIL_NOT_EXIST);
				result.setMessage("mail not exists");
				return result;
			}
			
			
			for(Student student : allResult.getData()) {
				if(student.getMail().equals(mail) && student.getPassword().equals(password)) {
					result.setData(student);
					break;
				}else if(student.getMail().equals(mail) && !student.getPassword().equals(password)) {
					result.setCode(ResultCode.E_PASSWORD_ERROR);
					result.setMessage("password error");
				}
			}
		}else {
			result.setCode(allResult.getCode());
			result.setMessage(allResult.getMessage());
		}
		
		return result;
	}
}
