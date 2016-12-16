package com.cyh.sy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyh.core.beans.WherePrams;
import com.cyh.core.sql.where.C;
import com.cyh.sy.service.ICompanyService;
import com.cyh.sy.web.view.DatatablesView;
import com.cyh.sy.common.DateUtil;
import com.cyh.sy.common.MD5;
import com.cyh.sy.common.info.GenerateLinkUtils;
import com.cyh.sy.dao.CompanyDao;
import com.cyh.sy.entity.Company;
import com.cyh.sy.entity.bean.QueryCondition;

/**
 * @描述：企业信息service
 * @作者：CYH
 * @版本：V1.0
 * @创建时间：：2016-12-14 下午3:43:02
 */
@Service("companyService")
public class CompanyService implements ICompanyService{
	
	@Resource  
	private CompanyDao companyDao;
	
	public List<Company> getAllCompany(){
		List<Company> list = companyDao.list();
		return list;
	}
	
	public DatatablesView<Company> getCompanyByCondition(QueryCondition query){
		DatatablesView<Company> dataView = new DatatablesView<Company>();
		
		//构建查询条件
		WherePrams where = companyDao.structureConditon(query);
		
		Long count = companyDao.count(where);
		List<Company> list = companyDao.list(where);
		
		dataView.setRecordsTotal(count.intValue());
		dataView.setData(list);
		
		return dataView;
	}
	
	public List<Company> getCompanyByType(Integer type){
		WherePrams where = new WherePrams();
		where.and("companyType", C.EQ, type);
		
		List<Company> list = companyDao.list(where);
		return list;
	}
	
	public Company getCompanyById(long companyId){
		return companyDao.get(companyId);
	}
	
	public Company getCompanyByNamePassword(Company company){
		WherePrams where = new WherePrams();
		where.and("username", C.EQ,company.getUsername());
		where.and("password", C.EQ, MD5.md5(company.getPassword()));
		
		List<Company> list = companyDao.list(where);
		for (Company com : list) {
			return com;
		}
		return null;
	}
	
	public Company getCompanyByName(String username){
		WherePrams where = new WherePrams();
		where.and("username", C.EQ, username);
		List<Company> list = companyDao.list(where);
		for (Company com : list) {
			return com;
		}
		return null;
	}
	
	public int addCompany(Company company){
		company.setPassword(MD5.md5(company.getPassword()));
		return companyDao.addLocal(company);
	}
	
	public int editCompany(Company company){
		company.setLastOpTime(DateUtil.getNowTime());
		WherePrams where = new WherePrams();
		where.and("companyId", C.EQ, company.getCompanyId());
		return companyDao.updateLocal(company,where);
	}
	
	public int removeCompany(long companyId){
		return companyDao.del(companyId);
	}
	
	public int activeUser(Company company, String checkCode){
		boolean active = GenerateLinkUtils.verifyCheckcode(company, checkCode);
		
		int result = 0;
		if(active){
			Company com = new Company(company.getCompanyId());
			com.setCompanyStatus(1);
			WherePrams where = new WherePrams();
			where.and("companyId", C.EQ, company.getCompanyId());
			result = companyDao.updateLocal(com, where);
		}
		return result;
	}
	
	public int forgetPassword(String id, String username, String checkCode){
		
		return 0;
	}
	
}