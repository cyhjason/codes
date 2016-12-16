package com.cyh.core.beans;

import java.io.Serializable;

import com.cyh.core.sql.where.C;

public class Method {

	/**
	 * where条件
	 * @param pram
	 * @return
	 */
//	public static WherePrams where(String pram){
//		return new WherePrams(pram);
//	}
	/**
	 * where重写
	 * @param pram
	 * @return
	 */
	public static WherePrams where(String file, String where, Serializable value){
			return new WherePrams(file , where , value);
	}
	public static WherePrams where(String file, C c, Serializable value){
		String where = C.getSqlWhere(c);
		return where(file, where, value);
	}
	public static WherePrams createDefault(){
		return new WherePrams(null, null, null);
	}
	
}
