package com.cyh.sy.common.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * @描述：任务调度管理类
 * @作者：cyh
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午10:54:10
 *
 */
@Component
public class TaskManager {

	
	@Scheduled(cron = "0 0/10 * * * ?")
	public void task1(){
		System.out.println("我每10分钟都要执行一次，不管是刮风还是下雨");
	}
	
	@Scheduled(cron = "0 0 2 * * ?")
	public void task2(){
		System.out.println("我每天凌晨两点执行");
	}
	
	@Scheduled(cron = "0 0 0 1 1 3")
	public void task3(){
		System.err.println("如果现在是2016年的话，我会在未来的3年后也就是2019年一月一日凌晨0点钟执行，且只一次，假如错过了那么我将永远失去执行的机会");
	}
	
	@Scheduled(cron = "0 0 0 1 1 3/4")
	public void task4(){
		System.err.println("如果现在是2016年的话，我会在未来的3年后也就是2019年一月一日凌晨0点钟执行，假如错过了我会等待一年然后再执行一次");
	}
	
}
