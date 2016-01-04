package nju.swi.bll.manager;

public class ManagerFactory {

	private static StudentManager studentManager = new StudentManager();
	private static MaterialManager materialManager = new MaterialManager();
	private static NotificationManager notificationManager = new NotificationManager();
	private static GradesManager gradesManager = new GradesManager();
	private static HomeworkManager homeworkManager = new HomeworkManager();
	private static StudentHomeworkManager studentHomeworkManager = new StudentHomeworkManager();
	
	public static StudentManager getStudentManager() {
		return studentManager;
	}
	
	public static MaterialManager getMaterialManager() {
		return materialManager;
	}
	
	public static NotificationManager getNotificationManager() {
		return notificationManager;
	}
	
	public static HomeworkManager getHomeworkManager() {
		return homeworkManager;
	}
	
	public static GradesManager getGradesManager() {
		return gradesManager;
	}
	
	public static StudentHomeworkManager getStudentHomeworkManager() {
		return studentHomeworkManager;
	}
	
}
