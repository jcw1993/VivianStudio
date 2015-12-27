package nju.swi.bll.model;

import java.util.Date;

import nju.swi.dao.MaterialDao;
import nju.swi.util.DateUtil;

public class Material {

	private int id;
	private String title;
	private String url;
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
	
	public Material(){}
	
	public Material(MaterialDao dao) {
		id = dao.getInt("id");
		title = dao.getStr("title");
		url = dao.getStr("url");
		createdTime = DateUtil.timestampToDate(dao.getTimestamp("created_time"));
	}
	
	public MaterialDao toDao() {
		MaterialDao dao = new MaterialDao();
		if(id > 0) {
			dao.set("id", id);
		}
		dao.set("title", title);
		dao.set("url", url);
		dao.set("created_time", DateUtil.dateToTimestamp(createdTime));
		return dao;
	}
}
