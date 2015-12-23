package nju.swi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.log.Logger;

public class BaseController extends Controller{
	
	private static Logger logger = Logger.getLogger(BaseController.class);
	private static Gson gson = new Gson();

	@Override
	public void renderJsp(String jspPath) {
		super.renderJsp(getJsp(jspPath));
	}
	
	protected <T> T parseJson(Class<T> c) {
		String jsonStr = HttpKit.readIncommingRequestData(getRequest());
		return gson.fromJson(jsonStr, c);
	}
	
	protected <T> T parseJson2(Class<T> c) {
		StringBuilder sb;
        InputStream inputStream;
        sb = new StringBuilder();
        inputStream = null;
        String s;
        try
        {
            inputStream = getRequest().getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            for(String line = null; (line = reader.readLine()) != null;)
                sb.append(line).append("\n");

            s = sb.toString();
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }finally {
        	if(inputStream != null) {
        		try
                {
                    inputStream.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        
        return gson.fromJson(s, c);
	}
	
	@Override
	public Integer getParaToInt(String name) {
		int result = 0;
		String paraValue = super.getPara(name);
		if(StringUtils.isBlank(paraValue)) {
			return result;
		}
		try {
			result = Integer.parseInt(paraValue);
		}catch(NumberFormatException e) {
			logger.error(e.getMessage());
		}
		
		return result;
	}
	
	public double getParaToDouble(String name) {
		double result = 0.0;
		String paraValue = super.getPara(name);
		if(StringUtils.isBlank(paraValue)) {
			return result;
		}
		try {
			result = Double.parseDouble(paraValue);
		}catch(NumberFormatException e) {
			logger.error(e.getMessage());
		}
		
		return result;
	}
	
	private String getJsp(String fileName) {
		return "/WEB-INF/ui/" + fileName + ".jsp";
	}
}
