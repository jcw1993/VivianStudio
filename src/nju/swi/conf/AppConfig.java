package nju.swi.conf;

import nju.swi.controller.HomeController;
import nju.swi.controller.StudentController;
import nju.swi.dao.HomeworkDao;
import nju.swi.dao.MaterialDao;
import nju.swi.dao.StudentDao;

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
	
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setUploadedFileSaveDirectory("/Users/jinchengwei/Desktop/vivian_studio_upload/");
	}

	public void configRoute(Routes me) {
		me.add("/", HomeController.class);
		me.add("/student", StudentController.class);
	}

	public void configPlugin(Plugins me) {
		C3p0Plugin c3p0Plugin = new C3p0Plugin(jdbcUrl, userName, password);
		me.add(c3p0Plugin);
		ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(c3p0Plugin);
		me.add(activeRecordPlugin);
		activeRecordPlugin.addMapping("student", "id", StudentDao.class);
		activeRecordPlugin.addMapping("material", "id", MaterialDao.class);
		activeRecordPlugin.addMapping("homework", "id", HomeworkDao.class);
		me.add(new EhCachePlugin());
	}

	public void configInterceptor(Interceptors me) {
	}

	public void configHandler(Handlers me) {
	}
}