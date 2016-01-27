package nju.swi.bll.manager;

import java.util.ArrayList;
import java.util.List;

import nju.swi.bll.model.Notification;
import nju.swi.common.GenericResult;
import nju.swi.common.NoneDataResult;
import nju.swi.common.ResultCode;
import nju.swi.dao.NotificationDao;

import com.jfinal.log.Logger;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.ehcache.CacheKit;

public class NotificationManager {
	
	private static Logger logger = Logger.getLogger(NotificationManager.class);
	private static final String ALL_NOTIFICATION_KEY = "AllNotification";
	
	public static final int NOTIFICATION_DEFAULT_PAGE = 10;
	
	public GenericResult<List<Notification>> getAll() {
		GenericResult<List<Notification>> result = new GenericResult<List<Notification>>();
		List<Notification> allNotification = CacheKit.get(Notification.class.getName(), ALL_NOTIFICATION_KEY);
		if(null != allNotification && !allNotification.isEmpty()) {
			result.setData(allNotification);
		}else {
			try {
				List<NotificationDao> notificationDaos = NotificationDao.getAll();
				if(null != notificationDaos && !notificationDaos.isEmpty()) {
					allNotification = new ArrayList<Notification>();
					for(NotificationDao dao : notificationDaos) {
						Notification notification = new Notification(dao);
						allNotification.add(notification);
					}
				}
				CacheKit.put(Notification.class.getName(), ALL_NOTIFICATION_KEY, allNotification);
				result.setData(allNotification);
			}catch(Exception e) {
				result.setCode(ResultCode.E_DATABASE_GET_ERROR);
				logger.error("NotificationManager getAll failed: " + e.getMessage());
			}
			
		}
		return result;
	}
	
	public GenericResult<Notification> getById(int id) {
		GenericResult<Notification> result = new GenericResult<Notification>();
		GenericResult<List<Notification>> allResult = getAll();
		if(allResult.getCode() == ResultCode.OK) {
			for(Notification notification : allResult.getData()) {
				if(notification.getId() == id) {
					result.setData(notification);
					break;
				}
			}
		}else {
			result.setCode(allResult.getCode());
		}
		return result;
	}
	
	public GenericResult<Integer> create(Notification notification) {
		GenericResult<Integer> result = new GenericResult<Integer>();
		try {
			NotificationDao notificationDao = notification.toDao();
			notificationDao.save();
			result.setData(notificationDao.getInt("id"));
			CacheKit.remove(Notification.class.getName(), ALL_NOTIFICATION_KEY);
		} catch (Exception e) {
			result.setCode(ResultCode.E_DATABASE_UPDATE_ERROR);
			logger.error("create notification error: " + e.getMessage());
		}
		return result;
	}
	
	public NoneDataResult delete(int id) {
		NoneDataResult result = new NoneDataResult();
		try {
			NotificationDao.delete(id);
		} catch (Exception e) {
			result.setCode(ResultCode.E_DATABASE_DELETE_ERROR);
			logger.error("delete notification error: " + e.getMessage());
		}
		CacheKit.remove(Notification.class.getName(), ALL_NOTIFICATION_KEY);
		return result;
	}

	public GenericResult<Page<Notification>> search(Integer page, Integer size) {
		if(null == page || page < 1) {
			page = 1;
		}
		if(null == size || size < 1) {
			size = 1;
		}
		GenericResult<Page<Notification>> result = new GenericResult<Page<Notification>>();
		GenericResult<List<Notification>> allResult = getAll();
		if(allResult.getCode() == ResultCode.OK && null != allResult.getData()) {
			int startIndex = (page - 1) * size;
			List<Notification> notificationList = new ArrayList<Notification>();
			int endIndex = Math.min(startIndex + size, allResult.getData().size());
			for(int i = startIndex; i < endIndex; i++) {
				notificationList.add(allResult.getData().get(i));
			}
			Page<Notification> notificationPage = new Page<Notification>(notificationList, page, size, allResult.getData().size() / size, allResult.getData().size());
			result.setData(notificationPage);
		}else {
			result.setCode(allResult.getCode());
		}
		return result;
	}
}
