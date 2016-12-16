package com.cyh.sy.service;

import java.util.List;

import com.cyh.sy.entity.Company;
import com.cyh.sy.entity.bean.QueryCondition;
import com.cyh.sy.web.view.DatatablesView;

/**
 * @描述：企业信息service接口
 * @作者：ChenYunhong
 * @版本：V1.0
 * @创建时间：：2016-12-14 下午3:43:31
 */
public interface ICompanyService{
	
	/**
	 * 功能描述：获取所有企业信息
	 * @return
	 */
	public List<Company> getAllCompany();
	
	/**
	 * 功能描述：根据条件获取企业信息
	 * @return
	 */
	public DatatablesView<Company> getCompanyByCondition(QueryCondition query);
	
	/**
	 * 根据制定类型获取用户
	 * @param type
	 * @return
	 */
	public List<Company> getCompanyByType(Integer type);
	
	/**
	 * 功能描述：根据ID获取企业信息
	 * @param companyId
	 * @return
	 */
	public Company getCompanyById(long companyId);
	
	/**
	 * 功能描述：根据用户名和密码获取企业信息
	 * @param company
	 * @return
	 */
	public Company getCompanyByNamePassword(Company company);
	
	/**
	 * 功能描述：根据用户名获取企业信息
	 * @param company
	 * @return
	 */
	public Company getCompanyByName(String username);
	
	/**
	 * 功能描述：添加企业信息
	 * @param company
	 * @return
	 */
	public int addCompany(Company company);
	
	/**
	 * 功能描述：修改企业信息
	 * @param company
	 * @return
	 */
	public int editCompany(Company company);
	
	/**
	 * 功能描述：删除企业信息
	 * @param userId
	 * @return
	 */
	public int removeCompany(long companyId);
	
	/**
	 * 功能描述：用户激活
	 * @param id
	 * @param checkCode
	 * @return
	 */
	public int activeUser(Company company, String checkCode);
	
	/**
	 * 功能描述：找回密码
	 * @param id
	 * @param username
	 * @param checkCode
	 * @return
	 */
	public int forgetPassword(String id, String username, String checkCode);
	
}
