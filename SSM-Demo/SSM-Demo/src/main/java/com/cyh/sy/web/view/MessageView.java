package com.cyh.sy.web.view;

/**
 * @描述：消息提醒View
 * @作者：cyh
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:06:38
 */
public class MessageView {  
	
	private String  id;
  
    private Integer status;
    
    private String  msg;
    
    public MessageView() {  
          
    }
    
    public MessageView(Integer status) {
		super();
		this.status = status;
	}
    
	public MessageView(Integer status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public MessageView(String id, String msg) {
		super();
		this.id = id;
		this.msg = msg;
	}
	
	public MessageView(String id, Integer status) {
		super();
		this.id = id;
		this.status = status;
	}

	public MessageView(String id, Integer status, String msg) {
		super();
		this.id = id;
		this.status = status;
		this.msg = msg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

} 