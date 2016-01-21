package nju.swi.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

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


	public static byte[] getBytes(InputStream is) throws IOException {
	    int len;
	    int size = 1024;
	    byte[] buf;

	    if (is instanceof ByteArrayInputStream) {
	      size = is.available();
	      buf = new byte[size];
	      len = is.read(buf, 0, size);
	    } else {
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      buf = new byte[size];
	      while ((len = is.read(buf, 0, size)) != -1)
	        bos.write(buf, 0, len);
	      buf = bos.toByteArray();
	    }
	    return buf;
	  }
}
