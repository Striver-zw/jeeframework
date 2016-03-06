package org.zw.singleton.jeeframework.common.utils.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

import org.zw.singleton.jeeframework.common.utils.times.CtimeDateFormat;
/**
 * 1、获取文件大小
 * 2、文件个数
 * 3、删除文件夹下所有的文件 文件夹不删除
 * 4、删除文件和目录
 * 5、创建文件夹
 * 6、创建时间级的文件夹
  * @类名:FileUtils
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月29日-上午11:21:17
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class FileUtilsJ implements Serializable{
	
	/**
	 * @说明: 
	 * @名称:serialVersionUID
	 * @类型:long
	 */
	private static final long serialVersionUID = -7822206916177737346L;
	/**
	 * 创建文件夹
	 * @方法说明:
	 * @方法名称:createFile
	 * @param file
	 * @param flag 是否多级创建
	 * @return
	 * @作者:zw
	 * @返回值:File
	 */
	public static File createFile(String path,boolean flag){
		File file = new File(path);
		try {
			if(!file.exists() && !file.isDirectory()){    
				if(flag){
					file.mkdirs(); 
				}else{
					file.mkdir(); 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
	
	/**
	 * 创建时间层级的文件夹
	 * @方法说明:
	 * @方法名称:createFileManage
	 * @return
	 * @作者:zw
	 * @返回值:File
	 */
	public static File createFileManage(){
		String dataToString = CtimeDateFormat.DataToString(new Date(), "yyyy-MM-dd");
		String replaceAll = dataToString.replaceAll("-", "/");
		File file = createFile(replaceAll, true);
		return file;
	}
	
	public static void main(String[] args) {
//		createFile(new File("d:\\a\\b"),true,null);
//		clearFiles("d:\\a");
		createFileManage();
	}
	/**
	 * 获取文件大小
	 * @方法说明:
	 * @方法名称:getFileSizes
	 * @param f
	 * @return
	 * @throws Exception
	 * @作者:zw
	 * @返回值:long
	 */
	@SuppressWarnings("resource")
	public long getFileSizes(File f) throws Exception {// 取得文件大小
		long s = 0;
		if (f.exists()) {
			FileInputStream fis = null;
			fis = new FileInputStream(f);
			s = fis.available();
		} else {
			f.createNewFile();
			System.err.println("文件不存在");
		}
		return s;
	}

	/**
	 * 获取文件夹大小
	 * @方法说明:
	 * @方法名称:getFileSize
	 * @param f
	 * @return
	 * @throws Exception
	 * @作者:zw
	 * @返回值:long
	 */
	public long getFileSize(File f) throws Exception{// 取得文件夹大小
		long size = 0;
		File flist[] = f.listFiles();
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isDirectory()) {
				size = size + getFileSize(flist[i]);
			} else {
				size = size + flist[i].length();
			}
		}
		return size;
	}

	/**
	 * 转换文件大小
	 * @方法说明:
	 * @方法名称:FormetFileSize
	 * @param fileS
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String FormetFileSize(long fileS) {// 转换文件大小
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "K";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}

	/**
	 * 递归求取目录文件个数
	 * @方法说明:
	 * @方法名称:getlist
	 * @param f
	 * @return
	 * @作者:zw
	 * @返回值:long
	 */
	public long getlist(File f) {
		long size = 0;
		File flist[] = f.listFiles();
		size = flist.length;
		for (int i = 0; i < flist.length; i++) {
			if (flist[i].isDirectory()) {
				size = size + getlist(flist[i]);
				size--;
			}
		}
		return size;
	}

	/**
	 * 得到所有文件数
	 * @方法说明:
	 * @方法名称:getFileArr
	 * @param path
	 * @return
	 * @作者:zw
	 * @返回值:long
	 */
	public static long getFileArr(String path) {
		FileUtilsJ g = new FileUtilsJ();
		// long startTime = System.currentTimeMillis();
		try {
			long l = 0;
			File ff = new File(path);
			if (ff.isDirectory()) { // 如果路径是文件夹的时候
				l = g.getFileSize(ff);
//				System.out.println("" + l);
				return l;
			} else {
				l = g.getFileSizes(ff);
//				System.out.println(path + "文件的大小为：" + g.FormetFileSize(l));
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * //删除文件夹下所有的文件 文件夹不删除
	 * @方法说明:
	 * @方法名称:delFolder
	 * @param folderPath文件夹完整绝对路径
	 * @作者:zw
	 * @返回值:void
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
//				 delFolder(path + "/" + tempList[i]);//再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * 删除文件和目录
	 * @方法说明:
	 * @方法名称:clearFiles
	 * @param workspaceRootPath
	 * @作者:zw
	 * @返回值:void
	 */
	private static void clearFiles(String workspaceRootPath){
	     File file = new File(workspaceRootPath);
	     if(file.exists()){
	          deleteFile(file);
	     }
	}
	private static void deleteFile(File file){
	     if(file.isDirectory()){
	          File[] files = file.listFiles();
	          for(int i=0; i<files.length; i++){
	               deleteFile(files[i]);
	          }
	     }
	     file.delete();
	 }

//	测试
	// public static void main(String args[]) {
	// FileUtils g = new FileUtils();
	// long startTime = System.currentTimeMillis();
	// try {
	// long l = 0;
	// String path =
	// "D:\\del\\Java_Project\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\jeeframework\\appfilter";
	// File ff = new File(path);
	// if (ff.isDirectory()) { // 如果路径是文件夹的时候
	// System.out.println("文件个数 " + g.getlist(ff));
	// System.out.println("目录");
	// l = g.getFileSize(ff);
	// System.out.println("目录的大小为：" + g.FormetFileSize(l));
	// System.out.println(path );
	// } else {
	// System.out.println(" 文件个数 1");
	// System.out.println("文件");
	// l = g.getFileSizes(ff);
	// System.out.println(path + "文件的大小为：" + g.FormetFileSize(l));
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// long endTime = System.currentTimeMillis();
	// System.out.println("总共花费时间为：" + (endTime - startTime) + "毫秒...");
	// }

}
