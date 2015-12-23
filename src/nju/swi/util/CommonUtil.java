package nju.swi.util;

public class CommonUtil {
	
	public static int ensureInteger(Integer arg, int value) {
		if(null == arg || arg < 0) {
			return value;
		}
		return arg;
	}

}
