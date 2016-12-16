package com.cyh.core.sql.where;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.cyh.core.annotation.FieldName;
import com.cyh.core.annotation.ID;
import com.cyh.core.annotation.PUBVALUE;
import com.cyh.core.annotation.TableName;
import com.cyh.core.annotation.TempField;
import com.cyh.core.beans.Po;
import com.cyh.core.beans.Pram;

/**
 * Sql生成工具类，采用泛型支持
 * @author 
 * @time 
 * @email 
 * @param <T> 要生成Sql的实体类
 */
public class SqlUtil<T extends Po> {
	
	/**
	 * 获取对应数据库表名称
	 * @param po
	 * @return
	 */
	public String getTableName(Class<T> po){
		if(po.isAnnotationPresent(TableName.class)){
			return po.getAnnotation(TableName.class).name();
		}else{
			String tName = toTableString(po.getSimpleName());
			String poName = tName.substring(tName.length() - 2, tName.length());
			if("po".equals(poName)){
				tName = tName.substring(0,tName.length() - 3);
			}
			return tName;
		}
	}

	/**
	 * 获取实体类的某个字段
	 * @param t
	 * @param fieldName
	 * @return
	 */
	public Field getField(Class<?> t, String fieldName){
		Field[] fields = t.getDeclaredFields();
		for (Field field : fields) {
			if (field.getName().equals(fieldName)) {
				return field;
			}
		}
		return null;
	}
	
	/**
	 * 通过Class获取生成对应Sql查询的字段  如实体属性和数据库字段名称一样，则无需调用
	 * @param po
	 * @return
	 */
	public List<Pram> getParmListOfSelect(Class<T> po){
		List<Pram> list = new ArrayList<Pram>();
		Class<? extends Po> thisClass = po;
	    Field[] fields = thisClass.getDeclaredFields();
	    	try {
	    		Object o = thisClass.newInstance();
	    		for(Field f : fields){
	    			if (!f.isAnnotationPresent(TempField.class)) {
	    				String fName = f.getName();
	    				//判断是否是boolean类型
		    			String getf = "get";
		    			String fieldType = f.getGenericType().toString();
		    			if (fieldType.indexOf("boolean") != -1 || fieldType.indexOf("Boolean") != -1) {
		    				getf = "is";
						}
		    			if (f.isAnnotationPresent(FieldName.class)) {
		    				String fieldName = f.getAnnotation(FieldName.class).name();
		    				Method get = thisClass.getMethod(getf + fName.substring(0, 1).toUpperCase() + fName.substring(1));
		    				Object getValue = get.invoke(o);
		    				Pram pram = new Pram(fieldName + " as " + fName, getValue);
							list.add(pram);
		    			}else{
		    				String fieldName = fName;
//		    				String fieldName = toTableString(fName);
		    				Method get = thisClass.getMethod(getf + fName.substring(0, 1).toUpperCase() + fName.substring(1));
		    				Object getValue = get.invoke(o);
		    				Pram pram = new Pram(fieldName + " as " + fName, getValue);
		    				//如果是ID属性，标记类型
		    				if (f.isAnnotationPresent(ID.class)) {
		    					pram.setType(PUBVALUE.TABLE_ID_TYPE_UUID);
		    				}
							list.add(pram);
						}
					}
	    		}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}
		return list;
	}
	
	/**
	 * 通过class获取对应PO类的 字段和值
	 * @param po
	 * @return
	 */
	public List<Pram> getParmListofStatic(Po po){
		Class<? extends Po> thisClass = po.getClass();
		return this.parmSet(thisClass, po);
	}
	
	/**
	 * 通过Class获取生成对应Sql字段
	 * @param po
	 * @return
	 */
	public List<Pram> getParmList(Class<T> po){
		List<Pram> list = null;
		Class<? extends Po> thisClass = po;
		try {
			Object o = thisClass.newInstance();
			list =  this.parmSet(thisClass, o);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 通过PO获取生成对应Sql字段
	 * @param po
	 * @return
	 */
	public List<Pram> getParmList(T po){
		Class<? extends Po> thisClass = po.getClass();
		return this.parmSet(thisClass, po);
	}
	
	private List<Pram> parmSet(Class<? extends Po> thisClass, Object po){
		List<Pram> list = new ArrayList<Pram>();
		Field[] fields = thisClass.getDeclaredFields();
		for(Field f : fields){
    		if(!f.getName().equalsIgnoreCase("ID") && !f.isAnnotationPresent(TempField.class)){
    			String fName = f.getName();
    			
    			//判断是否是boolean类型
    			String getf = "get";
    			String fieldType = f.getGenericType().toString();
    			if (fieldType.indexOf("boolean") != -1 || fieldType.indexOf("Boolean") != -1) {
    				getf = "is";
				}
    			try {
					if (f.isAnnotationPresent(FieldName.class)) {
						String fieldName = f.getAnnotation(FieldName.class).name();
						Method get = thisClass.getMethod(getf + fName.substring(0, 1).toUpperCase() + fName.substring(1));
						Object getValue = get.invoke(po);
						Pram pram = new Pram(fieldName, getValue);
						list.add(pram);
					}else{
						String fieldName = fName;
						Method get = thisClass.getMethod(getf + fName.substring(0, 1).toUpperCase() + fName.substring(1));
						Object getValue = get.invoke(po);
						Pram pram = new Pram(fieldName , getValue);
						//如果是ID属性，标记类型
						if (f.isAnnotationPresent(ID.class)) {
							pram.setType(PUBVALUE.TABLE_ID_TYPE_UUID);
						}
						list.add(pram);
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
    		}
		}
		return list;
	}
	
	/**
	 * 通过PO获取生成属性不为空的字段，排除ID 
	 * @param po
	 * @return
	 */
	public List<Pram> getParmListNotNull(T po){
		Class<? extends Po> thisClass = po.getClass();
		List<Pram> list = new ArrayList<Pram>();
		Field[] fields = thisClass.getDeclaredFields();
		for(Field f : fields){
    		if(!f.getName().equalsIgnoreCase("ID") && !f.isAnnotationPresent(TempField.class) && !f.isAnnotationPresent(ID.class)){
    			String fName = f.getName();
    			
    			//判断是否是boolean类型
    			String getf = "get";
    			String fieldType = f.getGenericType().toString();
    			if (fieldType.indexOf("boolean") != -1 || fieldType.indexOf("Boolean") != -1) {
    				getf = "is";
				}
    			try {
					if (f.isAnnotationPresent(FieldName.class)) {
						String fieldName = f.getAnnotation(FieldName.class).name();
						Method get = thisClass.getMethod(getf + fName.substring(0, 1).toUpperCase() + fName.substring(1));
						Object getValue = get.invoke(po);
						if(getValue != null && !"".equals(getValue)){
							Pram pram = new Pram(fieldName, getValue);
							list.add(pram);
						}
					}else{
						String fieldName = fName;
						Method get = thisClass.getMethod(getf + fName.substring(0, 1).toUpperCase() + fName.substring(1));
						Object getValue = get.invoke(po);
						if(getValue != null && !"".equals(getValue)){
							Pram pram = new Pram(fieldName , getValue);
							list.add(pram);
						}
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
    		}
		}
		return list;
	}
	
	/**
	 * 获取PO中指定属性的值
	 * @param po
	 * @param fileName
	 * @return
	 */
	public Serializable getFileValue(Po po, String fileName){
		try {
			Class<? extends Po> cla = po.getClass();
			Method method = cla.getMethod("get" + fileName.substring(0, 1).toUpperCase() + fileName.substring(1));
			Object o = po;
			Object invoke = method.invoke(o);
			return null == invoke ? null : (Serializable)invoke;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
	/**
	 * 设置PO中指定属性的值
	 * @param po
	 * @param fileName
	 * @param fileValue
	 * @return
	 */
	public static boolean setFileValue(Po po, String fileName, Serializable fileValue){
		Class<? extends Po> thisClass = po.getClass();
		try {
			if (null != fileValue) {
				try {
					Method method = null;
					if (fileValue instanceof String) {
						method = thisClass.getMethod("set" + fileName.substring(0, 1).toUpperCase() + fileName.substring(1), String.class);
					}else if(fileValue instanceof Integer){
						method = thisClass.getMethod("set" + fileName.substring(0, 1).toUpperCase() + fileName.substring(1), Integer.class);
					}else if(fileValue instanceof Long ){
						method = thisClass.getMethod("set" + fileName.substring(0, 1).toUpperCase() + fileName.substring(1), Long.class);
					}else if(fileValue instanceof Double){
						method = thisClass.getMethod("set" + fileName.substring(0, 1).toUpperCase() + fileName.substring(1), Double.class);
					}else if(fileValue instanceof Float){
						method = thisClass.getMethod("set" + fileName.substring(0, 1).toUpperCase() + fileName.substring(1), Float.class);
					}else if(fileValue instanceof Short){
						method = thisClass.getMethod("set" + fileName.substring(0, 1).toUpperCase() + fileName.substring(1), Short.class);
					}else if(fileValue instanceof BigInteger){
						BigInteger big = new BigInteger(fileValue.toString()); 
						fileValue = big.longValue();
						method = thisClass.getMethod("set" + fileName.substring(0, 1).toUpperCase() + fileName.substring(1), Long.class);
					}else {
						fileValue = fileValue.toString();
						method = thisClass.getMethod("set" + fileName.substring(0, 1).toUpperCase() + fileName.substring(1), String.class);
					}
					
					method.invoke(po, fileValue);
				} catch (NoSuchMethodException e) {
					try {
						Method method = thisClass.getMethod(
								"set" + fileName.substring(0, 1).toUpperCase() + fileName.substring(1), Boolean.TYPE);
						if (fileValue instanceof Integer) {
							method.invoke(po, new Integer("" + fileValue) > 0 ? true : false);
						} 
					} catch (NoSuchMethodException e2) {
						e2.printStackTrace();
					}
				}
			}
			return true;
		} catch (SecurityException e) {
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 驼峰标识转下划线标识
	 * @param text
	 * @return
	 */
	public String toTableString(String text){
		String tName = text.substring(0, 1).toLowerCase();
		for(int i = 1; i < text.length(); i++){
			if(!Character.isLowerCase(text.charAt(i))){
				tName += "_";
			}
			tName += text.substring(i, i + 1);
		}
		return tName.toLowerCase();
	}

	public String getTableNameByClazz(Class<? extends Po> po) {
		// TODO Auto-generated method stub
		if(po.isAnnotationPresent(TableName.class)){
			return po.getAnnotation(TableName.class).name();
		}else{
			String tName = toTableString(po.getSimpleName());
			if("po".equals(tName.substring(tName.length() - 3, tName.length() - 1))){
				tName = tName.substring(0,tName.length() - 3);
			}
			return tName;
		}
	}
	
	/**
	 * 获取指定PO 主键
	 * @param po
	 * @return
	 */
	public Pram getPkId(List<Pram> prams){
		if(prams == null || prams.size() <= 0)
			return null;
		
		for (Pram pram : prams) {
			if (pram.getType() != null && PUBVALUE.TABLE_ID_TYPE_UUID == pram.getType()) {
				return pram;
			}
		}
		return null;
	}
	
	/**
	 * 获取指定PO 主键
	 * @param po
	 * @return
	 */
	public String getPkIdName(List<Pram> prams){
		if(prams == null || prams.size() <= 0)
			return null;
		
		for (Pram pram : prams) {
			if (pram.getType() != null && PUBVALUE.TABLE_ID_TYPE_UUID == pram.getType()) {
				return pram.getFile();
			}
		}
		return null;
	}
}