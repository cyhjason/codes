package com.cyh.sy.common.file;

import java.io.*;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;

/**
 * 
 * @描述：文件压缩
 * @作者：cyh
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午10:47:12
 *
 */
public class FileCompress {
	
	public FileCompress() {
		
	}
	
	/**
	 * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
	 * @param sourceFilePath :待压缩的文件路径
	 * @param zipFilePath :压缩后存放路径
	 * @param fileName :压缩后文件的名称
	 * @return
	 */
	public static boolean fileCompressZip(String sourceFilePath, String zipFilePath, String fileName){
		boolean flag = false;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		
		File sourceFile = new File(sourceFilePath);
		if(sourceFile.exists() == false){
			System.out.println("待压缩的文件目录："+sourceFilePath+"不存在.");
		}else{
			try {
				File zipFile = new File(zipFilePath + "/" + fileName +".zip");
				if(zipFile.exists()){
					System.out.println(zipFilePath + "目录下存在名字为:" + fileName +".zip" +"打包文件.");
				}else{
					File[] sourceFiles = sourceFile.listFiles();
					if(null == sourceFiles || sourceFiles.length<1){
						System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
					}else{
						fos = new FileOutputStream(zipFile);
						zos = new ZipOutputStream(new BufferedOutputStream(fos));
						byte[] bufs = new byte[1024*10];
						for(int i=0;i<sourceFiles.length;i++){
							//创建ZIP实体，并添加进压缩包
							ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
							zos.putNextEntry(zipEntry);
							//读取待压缩的文件并写进压缩包里
							fis = new FileInputStream(sourceFiles[i]);
							bis = new BufferedInputStream(fis, 1024*10);
							int read = 0;
							while((read=bis.read(bufs, 0, 1024*10)) != -1){
								zos.write(bufs,0,read);
							}
						}
						flag = true;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally{
				//关闭流
				try {
					if(null != bis) bis.close();
					if(null != zos) zos.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		return flag;
	}
	
	public static void main(String[] args){
		String sourceFilePath = "D:\\Program Files\\Tomcat-7.0.12\\webapps\\sy\\upload\\qrcode\\20161115\\12345";
		String zipFilePath = sourceFilePath.substring(0, sourceFilePath.lastIndexOf("\\"));
		String fileName = sourceFilePath.substring(sourceFilePath.lastIndexOf("\\")+1);
		boolean flag = FileCompress.fileCompressZip(sourceFilePath, zipFilePath, fileName);
		if(flag){
			System.out.println("文件打包成功!");
		}else{
			System.out.println("文件打包失败!");
		}
	}
	
	/**
	 * 删除文件夹及文件夹下面的所有文件
	 */
	public void deleteFile(File oldPath) {
		if (oldPath.isDirectory()) {
			File[] files = oldPath.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isFile()) {
						file.delete();
					} else {
						deleteFile(file);
						file.delete();
					}
				}
			}
		}
		oldPath.delete();
	}
}