package com.cyh.sy.common;

/**
 * 
 * @描述：常量信息池
 * @作者：cyh
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午10:55:10
 *
 */
public class Constants {

	/**
	 * 该类不能被实例化
	 */
	private Constants() {
		throw new IllegalAccessError();
	}
	
	/**
	 * 原始编码
	 */
	public static final String ENCOD = "ISO-8859-1";
	
	/**
	 * 解析编码：UTF-8
	 */
	public static final String ENCODING = "UTF-8";
	
	/**
	 * 解析编码：GB2312
	 */
	public static final String ENCODING_2312 = "GB2312";
	
	/**
	 * 当前登录用户
	 */
	public static final String CURRENT_USER = "currentUser";
	
	/**
	 * 页面空格
	 */
	public static final String NBSP = "&nbsp;";
	
	/**
	 * 时间格式 : 年-月-日
	 */
	public static final String FORMAT1 = "yyyy-MM-dd";
	
	/**
	 * 时间格式 : 年-月-日
	 */
	public static final String FORMAT1_ = "yyyyMMdd";

	/**
	 * 时间格式 : 年-月-日 时:分      24小时制  HH小写为12小时制
	 */
	public static final String FORMAT2 = "yyyy-MM-dd HH:mm";

	/**
	 * 时间格式 : 年-月-日 时:分:秒   24小时制
	 */
    public static final String FORMAT3 = "yyyy-MM-dd HH:mm:ss";

	/**
	 * Double的默认值
	 */
	public static final String DOUBLE_DEFAULT = "0.0";
	
	/**
	 * Integer默认值
	 */
	public static final String INTEGER_DEFAULT = "0";
	
	/**
	 * 分隔符  “-”
	 */
	public static final String GE_ZI_FU = "-";
	
	/**
	 * 分隔符  “-”
	 */
	public static final String GE_ZI_FU_XIA = "_";
	
	/**
	 * 路径分隔负 “/”
	 */
	public static final String XIE_GAN = "/";
	
	/**
	 * 路径分隔负 “\\”
	 */
	public static final String XIE_GE = "\\";
	
	/**
	 * String的默认值空  “”
	 */
	public static final String KONG = "";
	
	/**
	 * 成功标志
	 */
	public static final String SUCCESS = "success";
	
	/**
	 * 出错标志
	 */
	public static final String FAILURE = "failure";

	/**
	 * 出错标志
	 */
	public static final String ERROR = "error";
	
	/**
	 * 404页面
	 */
	public static final String PAGE_404 = "/pages/error/404/html";
	
	public static final String SYS_NAME = "CCIC-SY系统：";
	
	public static final String COMPRESS_ZIP = "zip";
	
	public static final String IMAGE_JPG = "jpg";
	// 二维码尺寸
	public static final int QRCODE_SIZE = 300;
	// LOGO宽度
	public static final int QRCODE_WIDTH = 60;
	// LOGO高度
	public static final int QRCODE_HEIGHT = 60;
	
}
