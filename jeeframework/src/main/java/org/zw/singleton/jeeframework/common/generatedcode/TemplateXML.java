package org.zw.singleton.jeeframework.common.generatedcode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zw.singleton.jeeframework.common.constant.FinalData;
import org.zw.singleton.jeeframework.common.utils.datavalue.DataUnescape;

/**
 * 生成 mappings 文件
  * @类名:TemplateXML
  * @类描述:
  * @作者:张威
  * @创建时间:2016年1月5日-下午2:45:15
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2016
 */
public class TemplateXML {
	
	public static String PUBLIC_DATA = "\t<!--\n\t\t生成时间："+getDate()+""
			+ "\n\t\t代码器版本号：2.0\n\t-->\n\n";
	private static String beanclass;
	
	/**
	 * 时间
	 * @方法说明:
	 * @方法名称:getDate
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String getDate(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(new Date());
	}

	/**
	 * 生成mapper xml模板
	 * @方法说明:
	 * @方法名称:template
	 * @param packname
	 * @param tableName
	 * @param Columns
	 * @param clazz
	 * @return
	 * @作者:zw
	 * @返回值:StringBuffer
	 */
	public static void template(String packname,String tableName,String alias,List<String> Columns){
		String id = null;
		if("".equals(alias) || alias == null){
			beanclass =  DataUnescape.camelLowerCase(tableName);
		}else{
			beanclass =  DataUnescape.camelLowerCase(alias);	
		}
		StringBuffer s = new StringBuffer();
		s.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n"
				+ "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\""
				+ " \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n\n"
				+ PUBLIC_DATA
				+ "<mapper namespace=\""+packname+".dao."+beanclass+"Dao\">\n\n\t"
				+ "<sql id=\""+beanclass+"Columns\">\n\t\t"
			    + "SELECT\n\t\t\t");
				for (int i = 0; i < Columns.size(); i++) {
					if(i<Columns.size()-1){
						s.append("s."+Columns.get(i)+" AS \""+DataUnescape.camelUpperCase(Columns.get(i))+"\",\n\t\t\t");
					}else{
						s.append("s."+Columns.get(i)+" AS \""+DataUnescape.camelUpperCase(Columns.get(i))+"\"\n\t\t");
					}
				}
		s.append("FROM "+tableName+" s\n\t"
				+ "</sql>\n\n\t"
				+ "<insert id=\"saveMode\" parameterType=\""+beanclass+"\" >\n\t\t"
				+ "INSERT INTO "+tableName+"(\n\t\t\t");
				for (int i = 0; i < Columns.size(); i++) {
					if(i<Columns.size()-1){
						s.append(Columns.get(i)+",\n\t\t\t");
					}else{
						s.append(Columns.get(i)+"\n\t\t");
					}
				}
		s.append(")VALUES(\n\t\t\t");
				for (int i = 0; i < Columns.size(); i++) {
					if(i<Columns.size()-1){
						s.append("#{"+DataUnescape.camelUpperCase(Columns.get(i))+"},\n\t\t\t");
					}else{
						s.append("#{"+DataUnescape.camelUpperCase(Columns.get(i))+"}\n\t\t)\n\t</insert>\n\n\t<!-- <![CDATA[   ]]>  -->\n\t<!-- 分页查询 --> \n\t");
					}
				}
		s.append("<select id=\"findSelectPage\" resultType=\""+beanclass+"\">\n\t\t"
				+ "<include refid=\""+beanclass+"Columns\"/>\n\t</select>\n\n\t"
				+ "<select id=\"findSelect\" resultType=\""+beanclass+"\" parameterType=\""+beanclass+"\">\n\t\t"
				+ "<include refid=\""+beanclass+"Columns\"/>\n\t</select>\n\n\t"
				+ "<update id=\"updateMode\">\n\t\t"
				//带参数
//				+ "<update id=\"update"+clazz+"\" parameterType=\""+clazz+"\">\n\t\t"
				+ "UPDATE "+tableName+" SET \n\t\t\t");
				for (int i = 0; i < Columns.size(); i++) {
					if(i<Columns.size()-1){
						s.append(Columns.get(i)+" = #{"+DataUnescape.camelUpperCase(Columns.get(i))+"},\n\t\t\t");
						id = Columns.get(i);
					}else{
						s.append(Columns.get(i)+" = #{"+DataUnescape.camelUpperCase(Columns.get(i))+"}\n\t");
						id = Columns.get(i);
					}
				}
				boolean f = false;
				for (int i = 0; i < Columns.size(); i++) {
					if("id".equals(Columns.get(i))||Columns.get(i)=="id"){
						s.append("	WHERE "+Columns.get(i)+" = #{"+Columns.get(i)+"}");
						id = Columns.get(i);
						f = true;
					}
					//有可能有多个id
		//			if("id".equals(Columns.get(i))||Columns.get(i)=="id"||Columns.get(i).indexOf("id")!=-1){
		//				s.append("	WHERE "+Columns.get(i)+" = #{"+Columns.get(i)+"}");
		//				f = true;
		//			}
				}
				//没有id就去
				if(!f){
					s.append("	WHERE "+Columns.get(0)+" = #{"+DataUnescape.camelUpperCase(Columns.get(0))+"}");
					id = Columns.get(0);
				}
				s.append("\n\t</update>\n\n\t");
				//带参数
//		s.append("<delete id=\"delete"+clazz+"\"  parameterType=\""+clazz+"\">");
		s.append("<delete id=\"deleteModeId\">\n\t\t"
				+ "DELETE FROM "+tableName+" WHERE "+id+" = #{"+id+"}\n\t</delete>\n\n\t");
		s.append("<select id=\"getMode\" resultType=\""+beanclass+"\">\n\t\t"
				//带参数
//				s.append("<select id=\"get"+clazz+"\" resultType=\""+clazz+"\" parameterType=\""+clazz+"\">\n\t\t"
				+ "<include refid=\""+beanclass+"Columns\"/>\n\t\t\t"
				+ "WHERE s."+id+" = #{"+id+"}\n\t</select>");
		s.append("\n</mapper>");
		String fileName = FinalData.PROJECTPATH +"/src/main/resources/mappings/"+ packname.replaceAll("\\.", "/")+ "/";
		getCode(beanclass, s, fileName);	
	}
	
//	public static void main(String[] args) {
//		List<String> cl = new ArrayList<String>();
//		cl.add("id");
//		cl.add("name");
//		cl.add("age");
//		cl.add("add");
//		cl.add("phone");
////		getCode(null, template("k","sys",cl,"Sys"), null);
////		template("zw.singleton.jeeframework.modules.sys","SysUser",cl);
//	}
	public static void getCode(String ta,StringBuffer data,String pageName){
		try {
			File f = new File(pageName);
			if(!f.exists() && !f .isDirectory()){    
			    f.mkdirs();    
			}
			f = new File(f.toString()+ "/" + ta+".xml");
			FileWriter fw = new FileWriter(f);
			fw.write(data.toString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
