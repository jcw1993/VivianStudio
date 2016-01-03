package nju.swi.bll.manager;

public class ManagerFactory {

	private static StudentManager studentManager = new StudentManager();
	private static MaterialManager materialManager = new MaterialManager();
	private static NotificationManager notificationManager = new NotificationManager();
	
	public static StudentManager getStduentManager() {
		return studentManager;
	}
	
	public static MaterialManager getMaterialManager() {
		return materialManager;
	}
	
	public static NotificationManager getNotificationManager() {
		return notificationManager;
	}
	
}
