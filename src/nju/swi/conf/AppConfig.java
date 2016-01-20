package nju.swi.conf;

import nju.swi.controller.AdminController;
import nju.swi.controller.HomeController;
import nju.swi.controller.StudentController;
import nju.swi.dao.GradesDao;
import nju.swi.dao.HomeworkDao;
import nju.swi.dao.MaterialDao;
import nju.swi.dao.NotificationDao;
import nju.swi.dao.StudentDao;
import nju.swi.dao.StudentHomeworkDao;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;


public class AppConfig extends JFinalConfig {
	
	private static final String jdbcUrl = "jdbc:mysql://localhost:3306/vivian_studio?autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
	private static final String userName = "devuser";
	private static final String password = "qyff2011";
	
	public static final String[] INVITATION_CODE = new String[] {"chuyi", "chuer", "chusan"};
	
//	private static final String jdbcUrl = "jdbc:mysql://rds4xf83282v1od67t1n.mysql.rds.aliyuncs.com:3306/r4up03p34l621t69?autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
//	private static final String userName = "r4up03p34l621t69";
//	private static final String password = "njuswi";
	
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setUploadedFileSaveDirectory("/Users/jinchengwei/Desktop/vivian_studio_upload/");
//		me.setUploadedFileSaveDirectory("/upload");
	}

	public void configRoute(Routes me) {
		me.add("/", HomeController.class);
		me.add("/student", StudentController.class);
		me.add("/admin", AdminController.class);
	}

	public void configPlugin(Plugins me) {
		C3p0Plugin c3p0Plugin = new C3p0Plugin(jdbcUrl, userName, password);
		me.add(c3p0Plugin);
		ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(c3p0Plugin);
		me.add(activeRecordPlugin);
		activeRecordPlugin.addMapping("student", "id", StudentDao.class);
		activeRecordPlugin.addMapping("material", "id", MaterialDao.class);
		activeRecordPlugin.addMapping("homework", "id", HomeworkDao.class);
		activeRecordPlugin.addMapping("student_homework", StudentHomeworkDao.class);
		activeRecordPlugin.addMapping("notification", NotificationDao.class);
		activeRecordPlugin.addMapping("grades", GradesDao.class);
		me.add(new EhCachePlugin());
	}

	public void configInterceptor(Interceptors me) {
	}

	public void configHandler(Handlers me) {
	}
}