package com.cyh.sy.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cyh.sy.entity.Company;
import com.cyh.sy.entity.bean.QueryCondition;
import com.cyh.sy.service.ICompanyService;
import com.cyh.sy.web.view.DatatablesView;

/**
 * @描述：企业Controller
 * @作者：cyh
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:07:29
 */
@Controller
public class CompanyController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ICompanyService companyService;
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/com/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") Integer id, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("###ID:" + id);
		// model.addAttribute(userService.getUserById(id));
		return "/test/show.jsp";
	}

	/**
	 * 进入用户列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/list")
	public String list(HttpServletRequest request, Model model) {
		return "company";
	}
	
	/**
	 * 查询用户记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/com/getData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request, QueryCondition query) {
		DatatablesView<Company> dataTable = companyService.getCompanyByCondition(query);
		dataTable.setDraw(query.getDraw());
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	/**
	 * 获取制定用户列表列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/com/getDataByType/{type}", produces = "text/json;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String list(@PathVariable("type") Integer type, Model model){
		List<Company> list = companyService.getCompanyByType(type);
		return JSON.toJSONString(list);
	}
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception e, HttpServletRequest request) {
		request.setAttribute("exception", e);
		return "/pages/error/404.html";
	}
}