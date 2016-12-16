package com.cyh.sy.entity;

import com.cyh.core.annotation.ID;
import com.cyh.core.annotation.TableName;
import com.cyh.core.annotation.TempField;
import com.cyh.core.beans.Po;

/**
 * @描述：企业信息实体
 * @作者：CYH
 * @版本：V1.0
 * @创建时间：：2016-12-14 下午3:42:29
 */
@TableName(name="sy_company")
public class Company extends Po {
	
	@ID
	private Long   companyId;				//企业ID
	
	@TempField
	private String companyIdStr;			//企业ID，字符串
	
	private String username;				//用户名称
	
	private String password;				//登陆密码
	
	private String companyName;				//企业名称
	
	private Integer companyType;			//用户类型：1、管理员；2、生产商；3、出口商、4、进口商；5、代理商、6、经销商；
	
	private String companyContactsName;		//联系人姓名	
	
	private String companyContactsTel;		//联系人电话
	
	private String companyContactsEmail;	//联系人邮箱	
	
	private String companyContactsMobile;	//联系人手机
	
	private String companyWorkAddress;		//企业办公地址
	
	private String companyRegisterAddress;	//企业注册地址
	
	private String companyLegal;			//企业法人
	
	private String companyLegalTel;			//企业法人手机
	
	private String companyLicenseImg;		//企业营业执照
	
	private String companyComment;			//备注说明
	
	private String createTime;				//创建时间
	
	private String lastOpTime;				//最后一次操作时间
	
	private Integer companyStatus;			//企业状态：1-未激活；2-正常；3-禁用
	
	public Company() {
		super();
	}
	
	public Company(Long companyId) {
		this.companyId = companyId;
	}
	
	public Company(Long companyId, String username) {
		this.username = username;
		this.companyId = companyId;
	}
	
	public Company(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyIdStr = companyId.toString();
		this.companyId = companyId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCompanyType() {
		return companyType;
	}

	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}

	public String getCompanyContactsName() {
		return companyContactsName;
	}

	public void setCompanyContactsName(String companyContactsName) {
		this.companyContactsName = companyContactsName;
	}

	public String getCompanyContactsTel() {
		return companyContactsTel;
	}

	public void setCompanyContactsTel(String companyContactsTel) {
		this.companyContactsTel = companyContactsTel;
	}

	public String getCompanyContactsEmail() {
		return companyContactsEmail;
	}

	public void setCompanyContactsEmail(String companyContactsEmail) {
		this.companyContactsEmail = companyContactsEmail;
	}

	public String getCompanyContactsMobile() {
		return companyContactsMobile;
	}

	public void setCompanyContactsMobile(String companyContactsMobile) {
		this.companyContactsMobile = companyContactsMobile;
	}

	public String getCompanyWorkAddress() {
		return companyWorkAddress;
	}

	public void setCompanyWorkAddress(String companyWorkAddress) {
		this.companyWorkAddress = companyWorkAddress;
	}

	public String getCompanyRegisterAddress() {
		return companyRegisterAddress;
	}

	public void setCompanyRegisterAddress(String companyRegisterAddress) {
		this.companyRegisterAddress = companyRegisterAddress;
	}

	public String getCompanyLegal() {
		return companyLegal;
	}

	public void setCompanyLegal(String companyLegal) {
		this.companyLegal = companyLegal;
	}

	public String getCompanyLegalTel() {
		return companyLegalTel;
	}

	public void setCompanyLegalTel(String companyLegalTel) {
		this.companyLegalTel = companyLegalTel;
	}

	public String getCompanyLicenseImg() {
		return companyLicenseImg;
	}

	public void setCompanyLicenseImg(String companyLicenseImg) {
		this.companyLicenseImg = companyLicenseImg;
	}

	public String getCompanyComment() {
		return companyComment;
	}

	public void setCompanyComment(String companyComment) {
		this.companyComment = companyComment;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastOpTime() {
		return lastOpTime;
	}

	public void setLastOpTime(String lastOpTime) {
		this.lastOpTime = lastOpTime;
	}

	public Integer getCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(Integer companyStatus) {
		this.companyStatus = companyStatus;
	}

	public String getCompanyIdStr() {
		return companyIdStr;
	}

	public void setCompanyIdStr(String companyIdStr) {
		this.companyIdStr = companyIdStr;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyIdStr="
				+ companyIdStr + ", username=" + username + ", password="
				+ password + ", companyName=" + companyName + ", companyType="
				+ companyType + ", companyContactsName=" + companyContactsName
				+ ", companyContactsTel=" + companyContactsTel
				+ ", companyContactsEmail=" + companyContactsEmail
				+ ", companyContactsMobile=" + companyContactsMobile
				+ ", companyWorkAddress=" + companyWorkAddress
				+ ", companyRegisterAddress=" + companyRegisterAddress
				+ ", companyLegal=" + companyLegal + ", companyLegalTel="
				+ companyLegalTel + ", companyLicenseImg=" + companyLicenseImg
				+ ", companyComment=" + companyComment + ", createTime="
				+ createTime + ", lastOpTime=" + lastOpTime
				+ ", companyStatus=" + companyStatus + "]";
	}
}