package nju.swi.bll.model;

import java.util.Date;

import nju.swi.dao.StudentDao;
import nju.swi.util.DateUtil;

public class Student {
	private int id;
	private int levelId;
	private String name;
	private String mail;
	private String password;
	private String qq;
	private String sex;
	private String phone;
	private String address;
	private String openId;
	private Date registerDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Student(){}
	
	public Student(StudentDao dao) {
		id = dao.getInt("id");
		name = dao.getStr("name");
		mail = dao.getStr("mail");
		password = dao.getStr("password");
		phone = dao.getStr("phone");
		address = dao.getStr("address");
		openId = dao.getStr("open_id");
		levelId = dao.getInt("level_id");
		sex = dao.getStr("sex");
		qq = dao.getStr("qq");
		registerDate = DateUtil.timestampToDate(dao.getTimestamp("register_date"));
	}
	
	public StudentDao toDao() {
		StudentDao dao = new StudentDao();
		if(id > 0) {
			dao.set("id", id);
		}
		dao.set("level_id", levelId);
		dao.set("name", name);
		dao.set("sex", sex);
		dao.set("mail", mail);
		dao.set("password", password);
		dao.set("phone", phone);
		dao.set("address", address);
		dao.set("open_id", openId);
		dao.set("qq", qq);
		dao.set("register_date", registerDate);
		return dao;
	}
}
