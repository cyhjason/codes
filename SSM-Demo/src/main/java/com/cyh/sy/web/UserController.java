package com.cyh.sy.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cyh.sy.common.Constants;
import com.cyh.sy.common.info.EmailUtils;
import com.cyh.sy.entity.Company;
import com.cyh.sy.service.ICompanyService;
import com.cyh.sy.web.view.MessageView;

/**
 * @描述：用户Controller
 * @作者：cyh
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:08:43
 */
@Controller
public class UserController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ICompanyService companyService;
	
	/**
	 * 用户登陆
	 * @param request
	 * @param company
	 * @param model
	 * @return
	 */
	@RequestMapping("/account/sign")
	public ModelAndView sign(HttpServletRequest request, Company company, Model model){   
		company = companyService.getCompanyByNamePassword(company);
		if(company != null){
			request.getSession().setAttribute(Constants.CURRENT_USER, company);
			return new ModelAndView("redirect:/com/list");
		}else{
			model.addAttribute("msg", "登陆失败，请重新登陆!");
			return new ModelAndView("login");
		}
	}
	
	/**
	 * 用户退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/account/out")
	public String out(HttpServletRequest request){   
		request.getSession().setAttribute("company", null);
		return "login";
	}
	
	/**
	 * 用户激活
	 * @param request
	 * @return
	 */
	@RequestMapping("/account/activate/service")
	public String active(HttpServletRequest request, Model model){   
		
		String id = request.getParameter("id");
		String checkCode = request.getParameter("checkCode");
		Company company = companyService.getCompanyById(Long.parseLong(id));
		int result = companyService.activeUser(company, checkCode);
		if(result == 1){
			request.getSession().setAttribute("company", company);
			
			model.addAttribute("result", result);
			model.addAttribute("msg", "激活成功!");
			
			return "redirect:/com/list";
//			return "redirect:/com/list";
		}else{
			return Constants.PAGE_404;
		}
	}
	
	/**
	 * 用户找回密码
	 * @param request
	 * @return
	 */
	@RequestMapping("/account/resetPassword/service")
	public String forgetPassword(HttpServletRequest request){   
		request.getSession().setAttribute("company", null);
		return "login";
	}
	
	/**
	 * 用户注册用户名验证
	 * @param company
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/account/reusername", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String reUsername(String username) {
		Company company = companyService.getCompanyByName(username);
		String result;
		if (company != null) {
			result = "{\"valid\":false}";
		}else{
			result = "{\"valid\":true}";
		}
		return result;
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping("/account/reg")
	public String register(){ 
		return "register";
	}
	
	/**
	 * 用户注册
	 * @param company
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/add")
	public String add(Company company, ModelMap model) {
		String password = company.getPassword();
		int result = companyService.addCompany(company);
		if (result == 1) {
			company.setPassword(password);
			company = companyService.getCompanyByNamePassword(company);
			
			//开启激活邮件发送
			new SendMailThread(company).run();
			
			model.addAttribute("result", result);
			model.addAttribute("msg", company.getUsername() + " 注册成功!");
			log.info(Constants.SYS_NAME + "用户：" + company.getUsername() + " 注册成功!");
		}
		return "register";
	}
	
	/**
	 * 用户修改
	 * @param company
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/com/update", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(Company company, ModelMap model) {
		int status = companyService.editCompany(company);
		if (status == 1) {
			log.info(Constants.SYS_NAME + "用户：" + company.getUsername() + " 注册成功!");
		}
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 用户删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/com/del/{id}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(@PathVariable("id") long id, Model model) {
		int status = companyService.removeCompany(id);
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 发送激活邮件线程
	 * @author CYH
	 *
	 */
	class SendMailThread implements Runnable{
		
		private Company company;
		
		public SendMailThread(Company company){
			this.company = company;
		}

		@Override
		public void run() {
			//发送激活邮件
			EmailUtils.sendAccountActivateEmail(company);
		}
	}
	
}