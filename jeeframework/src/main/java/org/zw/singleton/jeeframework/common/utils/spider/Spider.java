package org.zw.singleton.jeeframework.common.utils.spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 搜索引擎（蜘蛛）
 * 
 * @author zw Date 2015年2月6日
 * @version 1.0
 */
public class Spider {

	private static StringBuffer buff;
	private static InputStreamReader in;
	private static BufferedReader buf;
	private static InputStream inputStream;
	public static void main(String[] args) {
		System.out.println(getPageHtmlSource("http://www.cnblogs.com/huozhicheng/archive/2010/04/08/2533199.html","utf-8"));
	}

	/**
	 * 获取源代码
	 * 
	 * @param srcLink
	 *            网站
	 * @param encode
	 *            编码
	 * @return
	 */
	public static String getPageHtmlSource(String srcLink, String econding) {
		try {
			// 1、建立与网页服务器的连接
			URL uri = new URL(srcLink);
			// 打开连接
			URLConnection urlConnection = uri.openConnection();
			// 设置属性
			urlConnection.setRequestProperty("User-Agent", "sousuo");
			// 获取数据(输入流)
			inputStream = urlConnection.getInputStream();
			// 把字节流换成字符流
			in = new InputStreamReader(inputStream, econding);
			// 创建缓冲输入流
			buf = new BufferedReader(in);
			// 存储一行的数据
			String line = null;
			buff = new StringBuffer();
			while ((line = buf.readLine()) != null) {// 判断一行有没有数据
				buff.append(line + "\r\n");// 行输入
			}
			// System.out.println(srcLink);
			// System.out.println(buff.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 从小关大
			try {
				if (buf != null) {
					buf.close();
					in.close();
					inputStream.close();
				}
			} catch (Exception e) {
			}
		}
		// 源代码
		return buff.toString();
	}

	// 使用jsoup解析数据
	public static String jsoup(String source) {
		Document document = Jsoup.parse(source);
		// 解析图片
		Elements elements = document.getElementsByTag("src");
		for (Element element : elements) {
			// 得到图片地址
			String attr = element.attr("src");
		}
		return "";
	}

	/**
	 * 下载网页中的图片
	 * @param filePath
	 * @param imgeUrl
	 */
	public static void downImage(String filePath, String imgeUrl) {
		if("".equals(imgeUrl) && imgeUrl.startsWith("http://")){
			
		}
		String fileImage = imgeUrl.substring(imgeUrl.lastIndexOf("/"));
		fileImage=fileImage+".jpg";
		try {
			// 创建文件目录
			File file = new File(filePath);
			//
			if (file.exists()) {
				file.mkdirs();
			}
			//获取下载链接
			URL url = new URL(imgeUrl);
			//连接网络地址
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			//获取连接输出流
			InputStream is = connection.getInputStream();
			//创建文件
			File file2 = new File(filePath+fileImage);
			//建立输入流 写入文件
			FileOutputStream fos = new FileOutputStream(file2);
			int temp = 0;
			while((temp=is.read()) != -1){
				fos.write(temp);
			}
			is.close();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
