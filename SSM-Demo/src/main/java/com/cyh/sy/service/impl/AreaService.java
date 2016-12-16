package com.cyh.sy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyh.core.beans.WherePrams;
import com.cyh.core.sql.where.C;
import com.cyh.sy.common.DateUtil;
import com.cyh.sy.dao.AreaDao;
import com.cyh.sy.entity.Area;
import com.cyh.sy.entity.bean.QueryCondition;
import com.cyh.sy.service.IAreaService;
import com.cyh.sy.web.view.DatatablesView;

/**
 * @描述：国家信息service
 * @作者：CYH
 * @版本：V1.0
 * @创建时间：：2016-12-14 下午3:42:45
 */
@Service("areaService")
public class AreaService implements IAreaService{
	
	@Resource
	private AreaDao areaDao;
	
	public DatatablesView<Area> getAreaByCondition(QueryCondition query) {
		DatatablesView<Area> dataView = new DatatablesView<Area>();
		
		//构建查询条件
		WherePrams where = areaDao.structureConditon(query);
		
		Long count = areaDao.count(where);
		List<Area> list = areaDao.list(where);
		
		dataView.setRecordsTotal(count.intValue());
		dataView.setData(list);
		
		return dataView;
	}
	
	public List<Area> getAllArea(){
		return areaDao.list();
	}
	
	public Area getAreaById(long areaId){
		return areaDao.get(areaId);
	}
	
	public int addArea(Area area){
		return areaDao.addLocal(area);
	}
	
	public int editArea(Area area){
		area.setUpdateTime(DateUtil.getNowTime());
		WherePrams where = new WherePrams();
		where.and("areaId", C.EQ, area.getAreaId());
		return areaDao.updateLocal(area,where);
	}
	
	public int removeArea(long areaId){
		return areaDao.del(areaId);
	}

}
