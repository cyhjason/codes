package com.cyh.sy.entity.bean;

/**
 * 
 * @描述：查询条件Bean
 * @作者：cyh
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午10:59:24
 *
 */
public class QueryCondition {  
  
    private Long    id;  
    
    private Integer draw;
    
    private Integer start;   
    
    private Integer length;  
    
    private Integer type;
    
    private String  startTime;
    
    private String  endTime;
    
    private String  keyword;
    
    private Integer status;
    
    //商品查询专用
    private Long    goodsId;
    
    private Long    originId;
    
    private Long    areaId;
    
    private Long    goodsTypeId;
    
    private Integer goodsStatus;
    
    //商品二维码专用
    private String path;
    
    private String qrcodePath;
    
    private String qrcodeUrl;
    
    public QueryCondition() {  
          
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getOriginId() {
		return originId;
	}

	public void setOriginId(Long originId) {
		this.originId = originId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(Long goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getQrcodePath() {
		return qrcodePath;
	}

	public void setQrcodePath(String qrcodePath) {
		this.qrcodePath = qrcodePath;
	}

	public String getQrcodeUrl() {
		return qrcodeUrl;
	}

	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}

	public Integer getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	@Override
	public String toString() {
		return "QueryCondition [id=" + id + ", draw=" + draw + ", start="
				+ start + ", length=" + length + ", type=" + type
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", keyword=" + keyword + ", status=" + status + ", goodsId="
				+ goodsId + ", originId=" + originId + ", areaId=" + areaId
				+ ", goodsTypeId=" + goodsTypeId + ", goodsStatus="
				+ goodsStatus + ", path=" + path + ", qrcodePath=" + qrcodePath
				+ ", qrcodeUrl=" + qrcodeUrl + "]";
	}

} 