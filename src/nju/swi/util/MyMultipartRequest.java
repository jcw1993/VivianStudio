package nju.swi.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpUtils;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

@SuppressWarnings("deprecation")
public class MyMultipartRequest {
	
	private HashMap<Object, Object> paramPairs = new HashMap<Object, Object>();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MyMultipartRequest(HttpServletRequest request) throws IOException {
		// 设置utf8
		MultipartParser parser = new MultipartParser(request, 1048576,
				true, true, "UTF-8");
		if (request.getQueryString() != null) {
			Hashtable queryParameters = HttpUtils.parseQueryString(request
					.getQueryString());
			Object paramName;
			Vector newValues;
			for (Enumeration queryParameterNames = queryParameters.keys(); queryParameterNames
					.hasMoreElements(); paramPairs.put(paramName, newValues)) {
				paramName = queryParameterNames.nextElement();
				String values[] = (String[]) queryParameters.get(paramName);
				newValues = new Vector();
				for (int i = 0; i < values.length; i++)
					newValues.add(values[i]);
			}

		}
		Part part;
		while ((part = parser.readNextPart()) != null) {
			String name = part.getName();
			if (part.isParam()) {
				ParamPart paramPart = (ParamPart) part;
				String value = paramPart.getStringValue();
				List<String> existingValues = (List<String>) paramPairs.get(name);
				if (existingValues == null) {
					existingValues = new ArrayList<String>();
					paramPairs.put(name, existingValues);
				}
				existingValues.add(value);
			} else if (part.isFile()) {
				FilePart filePart = (FilePart) part;
				String fileName = filePart.getFileName();
				paramPairs.put("fileName", fileName);
				paramPairs.put("fileData", CommonUtil.getBytes(filePart.getInputStream()));
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Object getPara(String paramName) {
		Object object = paramPairs.get(paramName);
		if(object instanceof List) {
			List<String> valueList = (List<String>) object;
			if(valueList.size() == 1) {
				return valueList.get(0);
			}else {
				return valueList;
			}
		}
		return object;
	}
	
	public Integer getParaToInt(String paramName) {
		Object object = this.getPara(paramName);
		if(object instanceof String) {
			String value = (String)object;
			try {
				return Integer.parseInt(value);
			} catch (Exception e) {
				// do nothing
			}
		}
		return null;
	}

}
