package org.zw.singletion.jeefeamework.down;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownThread {
	  public static void main(String[] args) {  
	        // 定义开启的线程数  
	        final int DOWNLOAD_THREAD_NUM = 4;  
	        // 定义下载文件的文件名，包括后缀  
	        final String OUTPUT_FILE_NAME = "000037.jpg";  
	        // 定义一个DOWNLOAD_THREAD_NUM大小的输入流数组  
	        InputStream[] inArrays = new InputStream[DOWNLOAD_THREAD_NUM];  
	        // 定义一个DOWNLOAD_THREAD_NUM大小的输出流数组  
	        RandomAccessFile[] outArrays = new RandomAccessFile[DOWNLOAD_THREAD_NUM];  
	          
	        try {  
	            // 创建一个URL对象，参数是我们要下载的资源的地址  
	            URL downloadUrl = new URL("http://www.yi18.net/img/book/00003.jpg");  
	            // 以该URL对象打开第一个输入流  
	            inArrays[0] = downloadUrl.openStream();  
	            // 获取该网络资源文件的长度  
	            long fileLength = getFileLength(downloadUrl);  
	            // 做一个打印  
	            System.out.println("该网络资源文件的大小："+fileLength);  
	            // 以输出的文件名创建第一个输出流对象，模式是可读，可写  
	            outArrays[0] = new RandomAccessFile(OUTPUT_FILE_NAME, "rw");  
	            // 创建一个与下载资源文件相同大小的空文件  
	            for (int i = 0; i < fileLength; i++) {  
	                outArrays[0].write(0);  
	            }  
	            // 计算每个线程应该下载的字节数  
	            long everyThreadDownloadSize = fileLength/DOWNLOAD_THREAD_NUM;  
	            // 计算整个下载资源整除后剩下的余数  
	            long otherDownloadSize = fileLength%DOWNLOAD_THREAD_NUM;  
	            // 启动各个线程下载各自规定的读取长度的资源  
	            for (int i = 0; i < DOWNLOAD_THREAD_NUM; i++) {  
	                // 刚才只初始化了第一个输入流和输出流对象，初始化剩下的输入流和输出流对象  
	                if (i != 0) {  
	                    inArrays[i] = downloadUrl.openStream();  
	                    outArrays[i] = new RandomAccessFile(OUTPUT_FILE_NAME, "rw");  
	                }  
	                // 独立配置最后一个线程的下载参数（该线程负责下载整除后余下的资源）  
	                if (i == DOWNLOAD_THREAD_NUM -1) {  
	                    new DownLoadThread(i*everyThreadDownloadSize, (i+1)*everyThreadDownloadSize+otherDownloadSize, inArrays[i], outArrays[i]);  
	                } else {  
	                    // 配置前几个线程的下载参数  
	                    new DownLoadThread(i*everyThreadDownloadSize, (i+1)*everyThreadDownloadSize, inArrays[i], outArrays[i]);  
	                }  
	            }  
	        } catch (MalformedURLException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	          
	          
	    }  
	      
	    // 根据URL获取该URL所指向的资源文件的长度  
	    private static long getFileLength(URL url) throws IOException{  
	        long length = 0;  
	        URLConnection urlConnection = url.openConnection();  
	        long size = urlConnection.getContentLength();  
	        length = size;  
	        return length;  
	    }  
}
