package org.zw.singleton.jeeframework.common.utils.datavalue;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.lang.exception.NestableRuntimeException;
import org.apache.commons.lang.text.StrBuilder;
import org.apache.commons.lang3.StringEscapeUtils;
/**
 * 1.http://blog.csdn.net/chenleixing/article/details/43456987
 * 2.http://www.oschina.net/code/snippet_999605_24793
 * 3.
  * @类名:DataUnescape
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月14日-下午2:04:24
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class DataUnescape {
	
	public static void main(String[] args) {
        
        
        System.out.println("测试2----------------------");
        System.out.println(underscoreLowerCase("HelloWorld"));
        System.out.println(underscoreUpperCase("HelloWorld"));
        System.out.println(camelUpperCase("bys_user_app"));
        System.out.println(camelLowerCase("bys_user_app"));
        System.out.println(pageName("zw.singleton.jeeframework.modules.basis.entity"));
        //hello_world
//        HELLO_WORLD
//        bysUserApp
//        BysUserApp
	}
	/**
	 * 包名替换
	 * zw.singleton.jeeframework.modules.basis.entity
	 * zw/singleton/jeeframework/modules/basis/entity
	 * @方法说明:
	 * @方法名称:pageName
	 * @param pa
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String pageName(String pa){
		return pa.replaceAll("\\.", "/");
	}
	 
	 /**
	  * 将驼峰式命名的字符串转换为下划线大写方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。</br>
	  * 例如：HelloWorld->HELLO_WORLD
	  * @param name 转换前的驼峰式命名的字符串
	  * @return 转换后下划线大写方式命名的字符串
	  * @return
	  * @作者:zw
	  * @返回值:String
	  */
	 public static String underscoreUpperCase(String name) {
	     StringBuilder result = new StringBuilder();
	     if (name != null && name.length() > 0) {
	         // 将第一个字符处理成大写
	         result.append(name.substring(0, 1).toUpperCase());
	         // 循环处理其余字符
	         for (int i = 1; i < name.length(); i++) {
	             String s = name.substring(i, i + 1);
	             // 在大写字母前添加下划线
	             if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
	                 result.append("_");
	             }
	             // 其他字符直接转成大写
	             result.append(s.toUpperCase());
	         }
	     }
	     return result.toString();
	 }
	 
	 /**
     * 将驼峰式命名的字符串转换为下划线大写方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。</br>
	  * 例如：HelloWorld->HELLO_WORLD
	  * @param name 转换前的驼峰式命名的字符串
	  * @return 转换后下划线大写方式命名的字符串
	  * @方法说明:
	  * @方法名称:underscoreName2
	  * @param name
	  * @return
	  * @作者:zw
	  * @返回值:String
	  */
	 public static String underscoreLowerCase(String name) {
		 StringBuilder result = new StringBuilder();
		 if (name != null && name.length() > 0) {
			 // 将第一个字符处理成大写
			 result.append(name.substring(0, 1).toLowerCase());
			 // 循环处理其余字符
			 for (int i = 1; i < name.length(); i++) {
				 String s = name.substring(i, i + 1);
				 // 在大写字母前添加下划线
				 if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
					 result.append("_");
				 }
				 // 其他字符直接转成大写
				 result.append(s.toLowerCase());
			 }
		 }
		 return result.toString();
	 }
	  
	 /**
	  * 
	  * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。</br>
	  * 例如：HELLO_WORLD->bysUserApp
	  * @param name 转换前的下划线大写方式命名的字符串
	  * @return 转换后的驼峰式命名的字符串
	  * @return
	  * @作者:zw
	  * @返回值:String
	  */
	 public static String camelUpperCase(String name) {
	     StringBuilder result = new StringBuilder();
	     // 快速检查
	     if (name == null || name.isEmpty()) {
	         // 没必要转换
	         return "";
	     } else if (!name.contains("_")) {
	         // 不含下划线，仅将首字母小写
	         return name.substring(0, 1).toLowerCase() + name.substring(1);
	     }
	     // 用下划线将原始字符串分割
	     String camels[] = name.split("_");
	     for (String camel :  camels) {
	         // 跳过原始字符串中开头、结尾的下换线或双重下划线
	         if (camel.isEmpty()) {
	             continue;
	         }
	         // 处理真正的驼峰片段
	         if (result.length() == 0) {
	             // 第一个驼峰片段，全部字母都小写
	             result.append(camel.toLowerCase());
	         } else {
	             // 其他的驼峰片段，首字母大写
	             result.append(camel.substring(0, 1).toUpperCase());
	             result.append(camel.substring(1).toLowerCase());
	         }
	     }
	     return result.toString();
	 }
	 
	 /**
	  * 
	  * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。</br>
	  * 例如：HELLO_WORLD->BysUserApp
	  * @param name 转换前的下划线大写方式命名的字符串
	  * @return 转换后的驼峰式命名的字符串
	  * @return
	  * @作者:zw
	  * @返回值:String
	  */
	 public static String camelLowerCase(String name) {
	     StringBuilder result = new StringBuilder();
	     // 快速检查
	     if (name == null || name.isEmpty()) {
	         // 没必要转换
	         return "";
	     } else if (!name.contains("_")) {
	         // 不含下划线，仅将首字母小写
	         return name.substring(0, 1).toUpperCase() + name.substring(1);
	     }
	     // 用下划线将原始字符串分割
	     String camels[] = name.split("_");
	     for (String camel :  camels) {
	         // 跳过原始字符串中开头、结尾的下换线或双重下划线
	         if (camel.isEmpty()) {
	             continue;
	         }
	         result.append(camel.substring(0, 1).toUpperCase());
            result.append(camel.substring(1).toLowerCase());
	     }
	     return result.toString();
	 }

	/**
	 * 把首字母大写 弊端是首字母一定是小写
	 * @方法说明:
	 * @方法名称:firstLetterToUpper
	 * @param str
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String firstLetterToUpper(String str) {
		char[] array = str.toCharArray();
		array[0] -= 32;
		return String.valueOf(array);
	}

	/**
	 *  首字母转小写
	 * @方法说明:
	 * @方法名称:toLowerCaseFirstOne
	 * @param s
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String toLowerCaseFirstOne(String s){
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	/**
	 * 首字母转大写
	 * @方法说明:
	 * @方法名称:toUpperCaseFirstOne
	 * @param s
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}
	/**
	 * 转义成为中文  也可以不转义 这里没有转义字符
	 * @方法说明:
	 * @方法名称:g
	 * @param data
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String unescapeJava(String data){
		return StringEscapeUtils.unescapeJava(data);
	}
//	
//	public static void main(String[] args) {
//		System.out.println(unescapeJava("\u79fb\u52a8\u4e92\u8054\u7f51\u5e94\u7528"));
//	}
	/**
	 * 以下是源码
	 * @方法说明:
	 * @方法名称:unescapeJava
	 * @param out
	 * @param str
	 * @throws IOException
	 * @作者:zw
	 * @返回值:void
	 */
	public static void unescapeJava(Writer out, String str) throws IOException {
	    if(out == null) {
	        throw new IllegalArgumentException("The Writer must not be null");
	    } else if(str != null) {
	        int sz = str.length();
	        StrBuilder unicode = new StrBuilder(4);
	        boolean hadSlash = false;
	        boolean inUnicode = false;

	        for(int i = 0; i < sz; ++i) {
	            char ch = str.charAt(i);
	            if(inUnicode) {
	                unicode.append(ch);
	                if(unicode.length() == 4) {
	                    try {
	                        int nfe = Integer.parseInt(unicode.toString(), 16);
	                        out.write((char)nfe);
	                        unicode.setLength(0);
	                        inUnicode = false;
	                        hadSlash = false;
	                    } catch (NumberFormatException var9) {
	                        throw new NestableRuntimeException("Unable to parse unicode value: " + unicode, var9);
	                    }
	                }
	            } else if(hadSlash) {
	                hadSlash = false;
	                switch(ch) {
	                    case '\"':
	                        out.write(34);
	                        break;
	                    case '\'':
	                        out.write(39);
	                        break;
	                    case '\\':
	                        out.write(92);
	                        break;
	                    case 'b':
	                        out.write(8);
	                        break;
	                    case 'f':
	                        out.write(12);
	                        break;
	                    case 'n':
	                        out.write(10);
	                        break;
	                    case 'r':
	                        out.write(13);
	                        break;
	                    case 't':
	                        out.write(9);
	                        break;
	                    case 'u':
	                        inUnicode = true;
	                        break;
	                    default:
	                        out.write(ch);
	                }
	            } else if(ch == 92) {
	                hadSlash = true;
	            } else {
	                out.write(ch);
	            }
	        }

	        if(hadSlash) {
	            out.write(92);
	        }

	    }
	}
}
