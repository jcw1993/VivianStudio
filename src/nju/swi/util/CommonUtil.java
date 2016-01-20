package nju.swi.util;

import org.apache.commons.lang3.StringUtils;

public class CommonUtil {
	
	public static int ensureInteger(Integer arg, int value) {
		if(null == arg || arg < 0) {
			return value;
		}
		return arg;
	}
	
	public static String getFileSuffix(String fileName) {
		if(StringUtils.isBlank(fileName)) {
			return null;
		}
		if(!fileName.contains(".")) {
			return null;
		}
		
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}

}
