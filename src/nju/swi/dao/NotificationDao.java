package nju.swi.dao;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class NotificationDao extends Model<NotificationDao> {
	
	private static final long serialVersionUID = 1L;

	public static NotificationDao dao = new NotificationDao();
	
	public static List<NotificationDao> getAll() {
		return dao.find("select * from notification order by created_time desc");
	}

	public static void delete(int id) {
		dao.deleteById(id);
	}
	
}
