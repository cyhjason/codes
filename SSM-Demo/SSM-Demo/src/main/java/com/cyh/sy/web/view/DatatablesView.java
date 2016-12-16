package com.cyh.sy.web.view;

import java.util.List;

/**
 * @描述：DataTables数据封装View
 * @作者：cyh
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:06:31
 */
public class DatatablesView<T> {  
  
    private List<T> data; //data 与datatales 加载的“dataSrc"对应  
    
    private int recordsTotal;   
    
    private int recordsFiltered;  
    
    private int draw;
    
    public DatatablesView() {  
          
    }

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}  
  
} 