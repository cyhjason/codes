package com.cyh.core.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cyh.core.sql.where.C;

/**
 * SQL查询条件封装约束类
 * @author 
 *
 */
public class WherePrams {
	
	private Boolean isWhere = false;
	
	private Boolean isStart = false;
	
	private Integer index = 0;

	private String  pram;
	
	private String  limit;
	
	private String  orderBy;
	
	private List<Serializable> parms = new ArrayList<Serializable>();
	
	private List<Serializable> limitParms = new ArrayList<Serializable>();
	
	public WherePrams(){
		this.pram = "";
	}
	
	public WherePrams(String file, String where, Serializable value){
		
		if(null == file && null == where && value == where){
			return;
		}
		
		if (null == value) {
			if (where.equals("=")) {
				where = " is";
			}else{
				where = " not ";
			}
			this.pram = " where " + file + where + " null";
		}else{
			if ("like".equals(where)) {
				this.pram = " where " + file + " " +  where + " '%" + value + "%'";
			}else{
				this.pram = " where " + file + " " +  where + " '" + value + "'";
			}
		}
	}
	
	/**
	 * and条件
	 * @param file
	 * @param where
	 * @param value
	 * @return
	 */
	public WherePrams and(String file, String where, Serializable value){
		String whereKey = "";
		if(!isWhere){
			whereKey += " where ";
			isWhere = true;
		}else{
			whereKey += " and ";
		}
		
		if (null == value) {
			if (where.equals("=")) {
				where = " is";
			} else {
				where = " not ";
			}
			this.pram = whereKey + file + where + " null";
		} else {
			if ("like".equals(where)) {
				this.pram += whereKey + file + " " + where + " '%" + value + "%'";
			}else{
				this.pram += whereKey + file + " " + where + " '" + value + "'";
			}
		}
		return this;
	}
	
	public WherePrams and(String file, C c, Serializable value){
		String where = C.getSqlWhere(c);
		return and(file, where, value);
	}
	
	/**
	 * or条件
	 * @param file
	 * @param where
	 * @param value
	 * @return
	 */
	public WherePrams or(String file, String where, Serializable value){
		String whereKey = "";
		if(!isWhere){
			whereKey += " where ";
			isWhere = true;
		}else{
			if(index != 0){
				whereKey += " or ";
			}
		}
		index++;
		
		if (null == value) {
			if (where.equals("=")) {
				where = " is";
			} else {
				where = " not ";
			}
			this.pram = whereKey + file + where + " null";
		} else {
			if ("like".equals(where)) {
				this.pram += whereKey + file + " " + where + " '%" + value + "%'";
			}else{
				this.pram += whereKey + file + " " + where + " '" + value + "'";
			}
		}
		return this;
	}
	
	public WherePrams or(String file, C c, Serializable value){
		String where = C.getSqlWhere(c);
		return or(file, where, value);
	}
	
	public WherePrams orStart(){
		if(isWhere){
			this.pram += " and (";
			isStart = true;
		}
		return this;
	}
	
	public WherePrams orEnd(){
		if(isStart){
			this.pram += ") ";
		}
		return this;
	}
	
	/**
	 * 分页
	 * @param startNum
	 * @param length
	 * @return
	 */
	public WherePrams limit(int startNum, int length) {
		this.limit = " limit " + startNum + " , " + length + " ";
		return this;
	}
	
	/**
	 * 排序
	 * @param order
	 * @return
	 */
	public WherePrams orderBy(String order){
		if(this.orderBy != null){
			this.orderBy += "," + order;
		}else{
			this.orderBy = order;
		}
		return this;
	}

	@Override
	public String toString() {
		return "WherePrams [pram=" + pram + "]";
	}
	
	/**
	 * 获取prams
	 * @return
	 */
	public String getPrams(){
		String p = "";
		p += null == this.pram ? "" : this.pram;
		return p;
	}
	
	/**
	 * 获取prams
	 * @return
	 */
	public String getWherePrams(){
		String p = "";
		p += null == this.pram ? "" : this.pram;
		p += null == this.orderBy ? "" : (" order by " + this.orderBy);
		p += null == this.limit ? "" : this.limit;
		return p;
	}
	
	public Serializable[] listParmsByFmt(){
		parms.addAll(limitParms);
		return parms.toArray(new Serializable[parms.size()]);
	}
	
	public Serializable[] listParms(){
		int length = getWherePrams().indexOf("?");
		if(-1 == length){
			return new Serializable[0];
		}
		parms.addAll(limitParms);
		return parms.toArray(new Serializable[parms.size()]);
	}
}
