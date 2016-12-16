package com.cyh.sy.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.cyh.sy.common.DateUtil;

/**
 * @描述：文件上传Controller
 * @作者：cyh
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:07:41
 */
@Controller
public class FileUploadController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 上传测试
	 * @param model
	 * @return
	 */
	@RequestMapping("/com/file")
	public String file(Model model) {
		return "test/fileUpload";
	}
	
	/**
	 * 异步上传处理
	 * @param request
	 * @param response
	 * @param file
	 * @return 返回上传文件相对路径及名称
	 * @throws IOException
	 */
    @RequestMapping(value="/file/upload", produces = "text/json;charset=UTF-8")
	@ResponseBody
    public String uploadFileHandler(HttpServletRequest request, 
    		@RequestParam("file") MultipartFile file){
    	
    	String type = request.getParameter("type");
    	String typeStr = "goods";
    	if("1".equals(type)){
    		typeStr = "company";
    	}
    	
    	//上传文件目录定义
        String path = "/upload/" + typeStr + "/image/" + DateUtil.getNowDay()+"/";
        
        if (file.getSize() > 0) {
        	//获取绝对路径
            String uploadPath = request.getSession().getServletContext().getRealPath(path);
            
            //修改文件名称
            String fileName = file.getOriginalFilename();
            if(fileName.indexOf(".")>=0){  
                int indexdot = fileName.indexOf(".");  
                String suffix = fileName.substring(indexdot);  
                fileName = System.currentTimeMillis() + String.valueOf((int)((Math.random()*9+1)*100000)) + suffix;
            }  
      
            try {
            	//创建目标文件
            	File targetFile = new File(uploadPath, fileName);
            	if (!targetFile.exists()) {
        			targetFile.mkdirs();
        		}
            	
            	file.transferTo(targetFile);
                //FileUtils.copyInputStreamToFile(file.getInputStream(), f);
                return JSON.toJSONString(path+fileName);
            } catch (Exception e) {
            	
            }
        }
        return null;
    }
    
    /**
     * 重新定义ueditor
     * @param request
     * @param response
     */
//    @RequestMapping(value="/file/config")
//    public void config(HttpServletRequest request, HttpServletResponse response) {
//        response.setContentType("application/json");
//        String rootPath = request.getSession().getServletContext().getRealPath("/");
// 
//        try {
//            String exec = new ActionEnter(request, rootPath).exec();
//            PrintWriter writer = response.getWriter();
//            writer.write(exec);
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
	
}