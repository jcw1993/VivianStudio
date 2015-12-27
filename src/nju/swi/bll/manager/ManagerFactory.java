package nju.swi.bll.manager;

public class ManagerFactory {

	private static StudentManager studentManager = new StudentManager();
	private static MaterialManager materialManager = new MaterialManager();
	
	public static StudentManager getStduentManager() {
		return studentManager;
	}
	
	public static MaterialManager getMaterialManager() {
		return materialManager;
	}
	
}
