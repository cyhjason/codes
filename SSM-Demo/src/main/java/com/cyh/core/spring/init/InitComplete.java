package com.cyh.core.spring.init;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 初始化完毕后输出项目访问路径
 * @author
 * @time 
 * @email 
 *
 */
@Component
public class InitComplete implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
//		Logger logger = Logger.getAnonymousLogger();
//		logger.info("CCIC-SY系统：Spring初始化...");
		
//		Object source = arg0.getSource();
//		if (source.getClass().getName().equals("org.springframework.web.context.support.XmlWebApplicationContext")) {
//			XmlWebApplicationContext application = (XmlWebApplicationContext) source;
//			
//			String line = System.getProperty("line.separator");
//			
//			logger.info(line + "项目路径：" + application.getApplicationName() + line + line);
//		}
	}
}
