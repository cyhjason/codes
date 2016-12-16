package com.cyh.sy.entity;

import java.io.Serializable;

/**
 * @描述：国家信息实体
 * @作者：CYH
 * @版本：V1.0
 * @创建时间：：2016-12-14 下午3:41:31
 */
@SuppressWarnings("serial")
public class Area implements Serializable{
	
	private Long   areaId;					//国家ID
	
	private String areaIdStr;				
	
	private String areaNameCn="";			//国家中文名称
	
	private String areaNameEn;				//国际英文名称
	
	private String createTime;				//创建时间
	
	private String updateTime;				//修改时间
	
	public Area() {
		super();
	}
	
	public Area(String areaNameCn, String areaNameEn) {
		this.areaNameCn = areaNameCn;
		this.areaNameEn = areaNameEn;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaIdStr = areaId.toString();
		this.areaId = areaId;
	}

	public String getAreaIdStr() {
		return areaIdStr;
	}

	public void setAreaIdStr(String areaIdStr) {
		this.areaIdStr = areaIdStr;
	}

	public String getAreaNameCn() {
		return areaNameCn;
	}

	public void setAreaNameCn(String areaNameCn) {
		this.areaNameCn = areaNameCn;
	}

	public String getAreaNameEn() {
		return areaNameEn;
	}

	public void setAreaNameEn(String areaNameEn) {
		this.areaNameEn = areaNameEn;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaIdStr=" + areaIdStr
				+ ", areaNameCn=" + areaNameCn + ", areaNameEn=" + areaNameEn
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}
	
}