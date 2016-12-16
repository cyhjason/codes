package com.cyh.core.beans;


/**
 * POJO字段封装类
 * @author 
 * @time 
 * @email 
 */
public class Pram {

	private String file;      //字段名称
	
	private Object value;     //字段值
	
	private Integer type = 0; //字段类型  1-代表主键

	public Pram(){
		
	}
	
	public Pram(String file, Object value){
		this.file = file;
		this.value = value;
	}
	
	public String getFile() {
		return file;
	}
	
	public void setFile(String file) {
		this.file = file;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
