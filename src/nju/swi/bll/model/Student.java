package nju.swi.bll.model;

import java.util.Date;

import nju.swi.dao.StudentDao;
import nju.swi.util.DateUtil;

public class Student {
	private int id;
	private String name;
	private String mail;
	private String password;
	private Date birth;
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
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
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
	
	public Student(){}
	
	public Student(StudentDao dao) {
		id = dao.getInt("id");
		name = dao.getStr("name");
		mail = dao.getStr("mail");
		password = dao.getStr("password");
		birth = DateUtil.timestampToDate(dao.getTimestamp("birth"));
		phone = dao.getStr("phone");
		address = dao.getStr("address");
		openId = dao.getStr("open_id");
		registerDate = DateUtil.timestampToDate(dao.getTimestamp("register_date"));
	}
	
	public StudentDao toDao() {
		StudentDao dao = new StudentDao();
		if(id > 0) {
			dao.set("id", id);
		}
		dao.set("name", name);
		dao.set("mail", mail);
		dao.set("password", password);
		dao.set("birth", DateUtil.dateToTimestamp(birth));
		dao.set("phone", phone);
		dao.set("address", address);
		dao.set("opne_id", openId);
		dao.set("register_date", registerDate);
		return dao;
	}
}
