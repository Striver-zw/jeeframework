package org.zw.singleton.jeeframework.common.utils.download;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 保存图片
 * 类型 base64位的数据
  * @类名:SaveImage
  * @类描述:
  * @作者:
  * @创建时间:2015年9月15日-上午11:18:08
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright (c)-2015
 */
public class SaveImage {

	/**
	 * 把字节数组保存为一个文件
	 * @param b
	 * @param outputFile
	 * @return File
	 */
	public static File getFileFromBytes(String outputFile, String imageName, String imageStr) {
		byte[] b = Base64.decode(imageStr);
		File ret = null;
		BufferedOutputStream stream = null;
		try {
			ret = new File(outputFile);
			if (!ret.exists()) {
				ret.mkdir();
			}
			stream = new BufferedOutputStream(new FileOutputStream(ret + "/" + imageName));
			if (b != null) {
				stream.write(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

}
