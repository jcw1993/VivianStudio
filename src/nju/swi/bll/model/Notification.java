package nju.swi.bll.model;

import java.util.Date;

import nju.swi.dao.NotificationDao;
import nju.swi.util.DateUtil;

public class Notification {
	
	private int id;
	private String title;
	private String content;
	private Date createdTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Notification() {}
	
	public Notification(NotificationDao dao) {
		id = dao.getInt("id");
		title = dao.getStr("title");
		content = dao.getStr("content");
		createdTime = DateUtil.timestampToDate(dao.getTimestamp("created_time"));
	}
	
	public NotificationDao toDao() {
		NotificationDao dao = new NotificationDao();
		if(id > 0) {
			dao.set("id", id);
		}
		dao.set("title", title);
		dao.set("content", content);
		dao.set("created_time", createdTime);
 		return dao;
	}
}
