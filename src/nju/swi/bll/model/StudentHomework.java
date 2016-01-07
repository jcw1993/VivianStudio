package nju.swi.bll.model;

import java.util.Date;

import nju.swi.dao.StudentHomeworkDao;
import nju.swi.util.DateUtil;

public class StudentHomework {
	
	private int id;
	private int studentId;
	private byte[] data;
	private String title;
	private String url;
	private Date createdTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public StudentHomework() {}
	
	public StudentHomework(StudentHomeworkDao dao) {
		id = dao.getInt("id");
		studentId = dao.getInt("student_id");
		title = dao.getStr("title");
		url = dao.getStr("url");
		createdTime = DateUtil.timestampToDate(dao.getTimestamp("created_time"));
	}
	
	public StudentHomeworkDao toDao() {
		StudentHomeworkDao dao = new StudentHomeworkDao();
		if(id > 0) {
			dao.set("id", id);
		}
		dao.set("student_id", studentId);
		dao.set("title", title);
		dao.set("url", url);
		dao.set("created_time", DateUtil.dateToTimestamp(createdTime));
		return dao;
	}

}
