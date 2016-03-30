package org.zw.singleton.jeeframework.common.utils.datavalue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  正则表达式
 *  http://www.runoob.com/java/java-regular-expressions.html
  * @类名:DataRegular
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月19日-上午11:12:10
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class DataRegular {

	/**
	 * 	使用正则获取数字
	 * @方法说明:
	 * @方法名称:getIntArray
	 * @param data 需要截取的数据
	 * @param flag 是否截取特殊字符
	 * @param i 截取的个数
	 * @return
	 * @作者:
	 * @返回值:int[]
	 */
	public static int[] getIntArray(String data, boolean flag, int i) {
		int[] d = new int[i];
		String[] split;
		String a = "";
		if (flag) {
			try {
				split = data.split("-");
				Pattern p = Pattern.compile("[0-9]");
				for (int j = 0; j < i; j++) {
					Matcher m = p.matcher(split[j]);
					while (m.find()) {
						a = a + m.group();
					}
					d[j] = Integer.parseInt(a);
					a="";
				}
			} catch (Exception e) {
				d = null;
				e.printStackTrace();
			}
			return d;
		} else {
			Pattern p = Pattern.compile("[0-9]");
			Matcher m = p.matcher(data);
			while (m.find()) {
				a = a + m.group();
			}
			d[0] = Integer.parseInt(a);
			return d;
		} 
	}
	
	
	public static void main(String[] args) {
//		int[] intArray = getIntArray("1000元-2000元",true,1);
//		intArray = getIntArray("挂1245gg就47", false, 2);
//		System.out.println(intArray[0]);
		testDome();
		testDomeData();
	}
	
	/**
	 * 常用的正则表达式匹配
	 * @方法说明:
	 * @方法名称:testDome
	 * @作者:zw
	 * @返回值:void
	 */
	public static void testDome(){
		String data = "zw.singleton.lifeassistant.pojo.pageSelectAdmainUser";
		//以什么开始
		if("pagefing".matches("^page+.*")){
			System.out.println("pagefing");
		}else{
			System.out.println(".+^page+."+"------------");
		}
		//一什么结尾
		if("pagefing".matches(".+page$")){
			System.out.println("^[page]$");
		}else{
			System.out.println(".+^page+."+"------------");
		}
		//包含某字符
		Pattern pattern = Pattern.compile(".*page.*");		
		if(pattern.matcher(data).matches()){
			System.out.println(".+ByPage$");
		}else{
			System.out.println(".+ByPage$"+"------------");
		}
		
	}
	
	/**
	 * 使用正则截取数据
	 * @方法说明:
	 * @方法名称:testDomeData
	 * @作者:zw
	 * @返回值:void
	 */
	public static void testDomeData() {
		// 匹配html标签
		String str = "<p class='xxxx'> Content\n\r内容\t\n\n</p>";
		Matcher m11 = Pattern.compile("<p.*?>([\\s\\S]*?)</p>").matcher(str);
		while (m11.find()) {
			System.out.println(m11.group(1));
		}
		// 匹配特殊标识之间的网址
		String s = "[p][img]http://image72.360doc.com/DownloadImg/2014/05/1615/41661464_1.gif[/img]"
				+ "芙丽芳丝的[/p][p][img]https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1316219042,1966573633&fm=58[/img]"
				+ "[/p][p]相传，怀孕的时候头发会因为孕期荷尔蒙的变化而变得更加健康！怀孕前，你有没有对一头乌黑亮丽的秀发有所期待？[/p][p]然而，凡事却总有例外……有没有宝妈发现这个常态在自己身上并没有得到很好的体现，反而头发掉得更厉害呢？一梳就是一把头发，家里地板到处都是发丝，每天不扫一下都不行。反正那画面太“美”，臣妾不敢看啊！[/p][p]所以，怀孕以后你的头发是更美腻了？还是掉得更犀利了？[/p][p]活动时间[/p]";
		
		Pattern p = Pattern.compile("\\[img\\]http[s]{0,1}.*?\\[/img]");
		Matcher m = p.matcher(s);
		while (m.find()) {
			System.out.println("---");
			System.out.println(m.group());
		}

	}
	
}
