package com.cyh.sy.web.upload;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

/**
 * @描述：文件上传进度监听
 * @作者：cyh
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:06:04
 */
@Component
public class FileUploadProgressListener implements ProgressListener {
	
    private HttpSession session;
    
    @Override
    public void update(long bytesRead, long contentLength, int items) {
    	//设置上传进度
        ProgressBean progress = new ProgressBean(bytesRead, contentLength, items); 
        //将上传进度保存到session中
        session.setAttribute("progress", progress); 
    }
    
    public void setSession(HttpSession session){
        this.session = session;
    }

}