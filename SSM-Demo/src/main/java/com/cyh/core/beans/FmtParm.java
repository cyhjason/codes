package com.cyh.core.beans;

public class FmtParm {

	/**
	 * 预格式字段名
	 */
	private String fieldName;
	
	/**
	 * 储值表中字段名
	 */
	private String select;
	
	/**
	 * 储值表
	 */
	private Class<? extends Po> po;
	
	/**
	 * 匹配条件
	 */
	private WherePrams where;
	
	
	public FmtParm(){}
	
	public FmtParm(String fieldName, String select, Class<? extends Po> po, WherePrams where){
		this.fieldName = fieldName;
		this.select = select;
		this.po = po;
		this.where = where;
	}
	
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public Class<? extends Po> getPo() {
		return po;
	}
	public void setPo(Class<? extends Po> po) {
		this.po = po;
	}
	public WherePrams getWhere() {
		return where;
	}
	public void setWhere(WherePrams where) {
		this.where = where;
	}
}