package org.zw.singletion.jeefeamework.down;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoadThread extends Thread{
	 // 定义字节数组（用于取水的那个竹筒）的长度  
    private final int BUFF_LEN = 100;  
    // 定义下载的起始点  
    private long start;  
    // 定义下载的结束点  
    private long end;  
    // 下载资源对应的输入流  
    private InputStream inputStream;  
    // 下载资源对应的输出流  
    private RandomAccessFile randomAccessFile;  
      
    // 构造器：传入起始下载点，结束下载点，输入流，输出流  
    public DownLoadThread (long start,long end,InputStream inputStream,RandomAccessFile randomAccessFile) {  
        // 打印一下该线程的起始下载点和结束下载点的位置信息  
        System.out.println(start+" >------> "+end);  
        this.start = start;  
        this.end = end;  
        this.inputStream = inputStream;  
        this.randomAccessFile = randomAccessFile;  
    }  
      
    @Override  
    public void run() {  
        try {  
            // 记录指针向前移动start个字符  
            inputStream.skip(start);  
            // 记录指针定位到start位置处  
            randomAccessFile.seek(start);  
            // 定义读取输入流内容的缓存数组（竹筒）  
            byte[] buff = new byte[BUFF_LEN];  
            // 本线程负责下载的资源大小  
            long contentLen = end - start;  
            // 定义最多需要几次就可以完成本线程的下载任务，方便控制线程的退出  
            long readMaxTimes = contentLen/BUFF_LEN + 4;  
            // 实际读取的字节数  
            int reallyReadCount = 0;  
            for (int i = 0; i < readMaxTimes; i++) {  
                // 读取数据  
                reallyReadCount = inputStream.read(buff);  
                // 如果读取的字节数小于0，说明读取完毕，则退出循环  
                if (reallyReadCount < 0) {  
                    break;  
                }  
                // 写入数据  
                randomAccessFile.write(buff, 0, reallyReadCount);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 使用finally块来关闭当前线程的输入流和输出流      
            try {  
                if (inputStream != null) {  
                    inputStream.close();  
                }  
                if (randomAccessFile != null) {  
                    randomAccessFile.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}