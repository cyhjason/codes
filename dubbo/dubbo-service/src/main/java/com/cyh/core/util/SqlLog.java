package com.cyh.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.log4j.Logger;

/**
 * SQL执行Log工具类
 * @author 
 * @time 
 * @email 
 */
public class SqlLog {

	private static Logger logger = Logger.getLogger(SqlLog.class);
	private static java.util.logging.Logger jlog = java.util.logging.Logger.getLogger(SqlLog.class.getName());
	public static String NL = System.getProperty("line.separator");
	private static final Properties properties =  new PropertiesUtil().getProperites("log4j.properties");
	//是否打印log
	private static final String islog = properties.getProperty("log4j.aiyi.sql.log");
	//是否格式化
	private static final String farmat = properties.getProperty("log4j.aiyi.sql.format");
	
	
	/**
	 * 正常输出log
	 * @param log
	 */
	public static void info(String log){
		if ("true".equalsIgnoreCase(islog)) {
			if ("true".equalsIgnoreCase(farmat)) {
				log = "────────┐excusSQL┌────────" + NL + formatSql(log) + NL;
			}
			jlog.log(Level.INFO, log);
		}
		
	}
	
	/**
	 * 输出一般Log
	 * @param log
	 */
	public static void infoLog(String log){
		jlog.log(Level.INFO, log);
	}
	
	public static void infoError(String log){
		jlog.log(Level.WARNING, log);
	}
	
	/**
	 * 输出错误信息
	 * @param log
	 */
	public static void error(String log){
		logger.error(log);
	}
	
	/**
	 * 输出系统异常
	 * @param e
	 */
	public static void error(Exception e){
		StackTraceElement[] stackTrace = e.getStackTrace();
		
		//包装异常信息
		String log = "=================SQLE RROR INFO=================" + NL;
		int maxClassLength = 0;
		int maxMethodLength = 0;
		List<Map<String, String>> errorInfo = new ArrayList<Map<String, String>>();
		for (StackTraceElement stack : stackTrace) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("class", stack.getClassName() + "{}");
			
			map.put("method", stack.getMethodName() + "()");
			
			map.put("line", stack.getLineNumber() + "");
			
			if (maxClassLength < (stack.getClassName() + "{}").length()) {
				maxClassLength = (stack.getClassName() + "{}").length();
			}
			if (maxMethodLength < (stack.getMethodName() + "()").length()) {
				maxMethodLength = (stack.getMethodName() + "()").length();
			}
			errorInfo.add(map);
		}
		
		//格式化异常信息
		String c = "Class";
		String m = "Method";
		for (; maxClassLength / 2  - c.length() > 0;) {
			c = " " + c;
		}
		for (; maxClassLength - c.length() > 0;) {
			c += " ";
		}
		c += "|";
		for (; maxMethodLength / 2 - m.length() > 0;) {
			m = " " + m;
		}
		for (; maxMethodLength - m.length() > 0;) {
			m += " ";
		}
		m += "|";
		log += c + m + "   Line" + NL; 
		
		for (Map<String, String> map : errorInfo) {
			String className = map.get("class");
			String methodName = map.get("method");
			for (; maxClassLength - className.length() > 0;) {
				className += " ";
			}
			for (; maxMethodLength - methodName.length() > 0;) {
				methodName += " ";
			}
			log += className + " " + methodName + " " + map.get("line") + NL;
		}
		
		//打印并记录异常
		logger.error(e);
		logger.error(log);
	}
	
	/**
	 * 格式化Sql
	 * @param sql
	 * @return
	 */
	public static String formatSql(String sql) {
//		FormatStyle.BASIC.getFormatter().format(sql);
		return null;
	}
}
