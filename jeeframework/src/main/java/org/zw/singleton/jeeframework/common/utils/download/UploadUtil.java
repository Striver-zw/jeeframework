package org.zw.singleton.jeeframework.common.utils.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 文件上传
  * @类名:UploadImageUtil
  * @类描述:
  * @作者:张威
  * @创建时间:2015年9月25日-下午5:20:22
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright (c)-2015
 */
public class UploadUtil {
	
	/**
	 * commons-fileupload-1.3.1 进行上传
	 * @方法说明:
	 * @方法名称:saveImage
	 * @param request 请求
	 * @param pathimage 保存的路径
	 * @作者:zw
	 * @返回值:void
	 */
	public static void saveImage(HttpServletRequest request,String pathimage){
		String path = request.getRealPath("/");
		path+="/"+pathimage;
		File file = new File(path);
		
		if(!file.exists())file.mkdirs();
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<?> items = upload.parseRequest(request);
			if(items!=null){
				Iterator<?> iterator = items.iterator();
				while(iterator.hasNext()){
					FileItem item = (FileItem) iterator.next();
					if(item.isFormField()){
						continue;
					}else{
						String name = item.getName();
						long size = item.getSize();
						int pos = name.lastIndexOf(".");
						String ext = name.substring(pos,name.length());
						name = UUID.randomUUID().toString()+ext;
						File saveFile = new File(path,name);
						try {
							item.write(saveFile);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	 * MultipartFile multipartFile
	 * 处理上传的图片
	 * 单个文件
	 * @方法说明:
	 * @方法名称:doImage
	 * @param multipartFile springmvc的响应
	 * @param request
	 * @param pathimage 保存路径
	 * @return
	 * @throws Exception
	 * @作者:zw
	 * @返回值:String[][]
	 */
	@SuppressWarnings({ "resource", "unused" })
	public static String[][] doImage(MultipartFile multipartFile,HttpServletRequest request,String pathimage)throws Exception{
		String[][] imageArr = new String[3][3];
		int i=0;
	        if (multipartFile.getOriginalFilename().length() > 0 && multipartFile.getSize()>0) {  
	            String fileName = multipartFile.getOriginalFilename();  
	            String suffix = fileName.substring(fileName.indexOf("."), fileName.length());
	            String newFileName = new Date().getTime()+suffix;
	            try {  
	                String uploadFileUrl = pathimage;  
	                File file = saveFileFromInputStream(multipartFile.getInputStream(), request.getSession().getServletContext().getRealPath("/")+"/"+uploadFileUrl, newFileName);  
	                if (file.exists()) {  
	                    FileInputStream fis = new FileInputStream(file); 
	                    String[] imageParam = new String[3]; 
	                    imageParam[0]=uploadFileUrl+"/"+newFileName;
	                    imageParam[1] = suffix.substring(suffix.indexOf(".")+1);
	                    long fileLen = file.length();
	                    DecimalFormat df = new DecimalFormat("#.00");
	                    imageParam[2] = df.format((double)fileLen/1024*1024)+"M";
	                    imageArr[i]=imageParam;
	                } else{ 
	                    throw new FileNotFoundException("error:" + fileName);  
	                }
	                i++;
	            } catch (Exception e) {  
	            	throw e; 
	            }  
	        }  
	    return imageArr;
	}
	
	/**
	 * MultipartHttpServletRequest multipartRequest 多个文件
	 * 处理上传的图片
	 * @param multipartRequest
	 * @throws Exception
	 */
	@SuppressWarnings({ "resource", "unused" })
	public static String[][] doImage(MultipartHttpServletRequest multipartRequest,HttpServletRequest request,String pathimage)throws Exception{
		String[][] imageArr = new String[3][3];
		 //获取多个file  
		int i=0;
	    for (Iterator<?> it = multipartRequest.getFileNames(); it.hasNext();) {  
	        String key = (String) it.next();  
	        MultipartFile imgFile = multipartRequest.getFile(key);
	        if (imgFile.getOriginalFilename().length() > 0 && imgFile.getSize()>0) {  
	            String fileName = imgFile.getOriginalFilename();  
	            String suffix = fileName.substring(fileName.indexOf("."), fileName.length());
	            String newFileName = new Date().getTime()+suffix;
	            try {  
	                String uploadFileUrl = pathimage;  
	                File file = saveFileFromInputStream(imgFile.getInputStream(), request.getSession().getServletContext().getRealPath("/")+"/"+uploadFileUrl, newFileName);  
	                if (file.exists()) {  
	                    FileInputStream fis = new FileInputStream(file); 
	                    String[] imageParam = new String[3]; 
	                    imageParam[0]=uploadFileUrl+"/"+newFileName;
	                    imageParam[1] = suffix.substring(suffix.indexOf(".")+1);
	                    long fileLen = file.length();
	                    DecimalFormat df = new DecimalFormat("#.00");
	                    imageParam[2] = df.format((double)fileLen/1024*1024)+"M";
	                    imageArr[i]=imageParam;
	                } else{ 
	                    throw new FileNotFoundException("error:" + fileName);  
	                }
	                i++;
	            } catch (Exception e) {  
	            	throw e; 
	            }  
	        }  
	    }  
	    return imageArr;
	}
	
	/**
	 * 
	 * @方法说明:
	 * @方法名称:saveFileFromInputStream
	 * @param stream
	 * @param path
	 * @param filename
	 * @return
	 * @throws IOException
	 * @作者:张威
	 * @返回值:	File
	 */
	 //保存文件  
	@SuppressWarnings("unused")
	public static File saveFileFromInputStream(InputStream stream, String path,  
	        String filename) throws IOException {  
	    File file = new File(path + "/" + filename);  
	    FileOutputStream fs = new FileOutputStream(file);  
	    byte[] buffer = new byte[1024 * 1024];  
	    int bytesum = 0;  
	    int byteread = 0;  
	    while ((byteread = stream.read(buffer)) != -1) {  
	        bytesum += byteread;  
	        fs.write(buffer, 0, byteread);  
	        fs.flush();  
	    }  
	    fs.close();  
	    stream.close();  
	    return file;  
	}  
	
	/**
	 * 删除
	 * @方法说明:
	 * @方法名称:deleteFlie
	 * @param path
	 * @throws Exception
	 * @作者:张威
	 * @返回值:	void
	 */
	public static void deleteFlie(String path)throws Exception{
		File f = new File(path);
		f.delete();
	}

}
