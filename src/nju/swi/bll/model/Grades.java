package nju.swi.bll.model;

import java.util.Date;

import nju.swi.dao.GradesDao;
import nju.swi.util.DateUtil;

public class Grades {
	private int id;
	private int levelId;
	private String title;
	private String url;
	private Date createdTime;
	
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
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	public Grades() {}
	
	public Grades(GradesDao dao) {
		id = dao.getInt("id");
		levelId = dao.getInt("level_id");
		title = dao.getStr("title");
		url = dao.getStr("url");
		createdTime = DateUtil.timestampToDate(dao.getTimestamp("created_time"));
	}
	
	public GradesDao toDao() {
		GradesDao dao = new GradesDao();
		if(id > 0) {
			dao.set("id", id);
		}
		dao.set("level_id", levelId);
		dao.set("title", title);
		dao.set("url", url);
		dao.set("created_time", DateUtil.dateToTimestamp(createdTime));
		return dao;
	}
}
