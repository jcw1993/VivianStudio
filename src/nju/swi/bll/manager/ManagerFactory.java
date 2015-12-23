package nju.swi.bll.manager;

public class ManagerFactory {

	private static StudentManager studentManager = new StudentManager();
	
	public static StudentManager getStduentManager() {
		return studentManager;
	}
	
}
