package nju.swi.bll.model;

import java.util.Date;

import nju.swi.dao.HomeworkDao;
import nju.swi.util.DateUtil;

public class Homework {
	private int id;
	private int levelId;
	private String title;
	private String url;
	private Date uploadTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
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
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	
	public Homework() {}
	
	public Homework(HomeworkDao dao) {
		id = dao.getInt("id");
		levelId = dao.getInt("level_id");
		title = dao.getStr("title");
		url = dao.getStr("url");
		uploadTime = DateUtil.timestampToDate(dao.getTimestamp("upload_time"));
	}
	
	public HomeworkDao toDao() {
		HomeworkDao dao = new HomeworkDao();
		if(id > 0) {
			dao.set("id", id);
		}
		dao.set("level_id", levelId);
		dao.set("title", title);
		dao.set("url", url);
		dao.set("upload_time", DateUtil.dateToTimestamp(uploadTime));
		return dao;
	}
}
