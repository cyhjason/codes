package com.cyh.core.sql.exception;

/**
 * 内部异常类：表示数据库中自增ID达到了Long类型，而实体类中ID为Integer类型时发生的类型转换异常
 * 解决方案：实体类中将int提升为long
 * @author 
 * @time 
 * @email 
 */
public class IdTransformationException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public IdTransformationException(String message) {
		 super(message);
	}

}
