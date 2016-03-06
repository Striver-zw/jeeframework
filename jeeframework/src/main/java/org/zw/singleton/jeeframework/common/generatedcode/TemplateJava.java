package org.zw.singleton.jeeframework.common.generatedcode;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zw.singleton.jeeframework.common.constant.FinalData;
import org.zw.singleton.jeeframework.common.utils.datavalue.DataUnescape;
import org.zw.singleton.jeeframework.modules.basis.base.MybatisDao;
/**
 * 生成java文件
  * @类名:TemplateJava
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月24日-下午2:29:15
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class TemplateJava {
	
	private static String FAG_DATA = "\r\n\n";
	private static String FAG_DATA_BASE = "import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;";
	private static String FAG_DATA_BASEDAO = "import org.zw.singleton.jeeframework.modules.basis.base.CrudDao;";
	private static String FAG_DATA_BASEDAO_A = "import org.zw.singleton.jeeframework.modules.basis.base.MybatisDao;";
//	private static String FAG_DATA_BASEDAO_A = "import org.springframework.stereotype.Repository;";
	private static String FAG_DATA_BASEDAO_SERVICE = "import org.springframework.beans.factory.annotation.Autowired;"
			+ "\nimport org.springframework.stereotype.Service;";
	private static String FAG_DATA_BASEDAO_AUT = "import org.springframework.beans.factory.annotation.Autowired;";
	private static String FAG_DATA_BASEDAO_CONTROLLER = "import org.springframework.stereotype.Controller;\n"+
			"import org.springframework.web.bind.annotation.RequestBody;\n"
			+ "import org.springframework.web.bind.annotation.RequestMapping;\n"
			+ "import org.springframework.web.bind.annotation.RequestMethod;\n"
			+ "import org.springframework.web.bind.annotation.ResponseBody;";
	private static String FAG_DATA_BASEDAO_PAGE = "import org.zw.singleton.jeeframework.modules.basis.page.Page;";
	private static String FAG_DATA_BASEDAO_UTIL = "import java.util.List;";
	private static String FAG_DATA_BASEDAO_MAP = "import java.util.HashMap;\nimport java.util.Map;";
	private static String FAG_DATA_BASEDAO_HTTP = "import javax.servlet.http.HttpServletRequest;\nimport javax.servlet.http.HttpServletResponse;";
	private static String FAG_DATA_DATE = "import java.util.Date;";
	private static String SHIRO_PERMISSIONS = "import org.apache.shiro.authz.annotation.RequiresPermissions;";
	
	/**
	 * 系统的注释
	 * @方法说明:
	 * @方法名称:getInstructions
	 * @param author 生成人的名字
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String getInstructions(String author){
		return "/**  \n"
				+ "  * Code Generator Author :singleton_zw\n"
				+ "  * Code Generator version: 2.0\n"
				+ "  * QQ群: 123456789\n"
				+ "  * author："+author+"\n"
				+ "  * CreateDate: "+getDate()+"\n"
				+ "  * Copyright &copy; 2015-2016\n"
				+ "*/";
	}
	
	/**
	 * 类上的注释
	 * @方法说明:
	 * @方法名称:getAnnotation
	 * @param caname
	 * @param author
	 * @param desc
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String getAnnotation(String caname,String author,String desc){
		return "/**  \n"
				+ "  * @className:"+caname+"\n"
				+ "  * @description:"+desc+"\n"
				+ "  * @author: "+author+"\n"
				+ "  * @createDate: "+getDate()+"\n"
				+ "  * @updateAuthor:\n"
				+ "  * @updateDate:\n"
				+ "  * @updateDesc:\n"
				+ "  * @version:\n"
				+ "  * @Copyright\n"
				+ "*/";
	}

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
	 * 生成bean 
	 * @方法说明:
	 * @方法名称:templateBean
	 * @param packname 包名
	 * @param author 生产者
     * @param tableNameBean 需要生成的表
	 * @param desc 模块描述
     * @param alias 生成别名
	 * @作者:zw
	 * @返回值:void
	 */
	static String beanclass = null;
	static String beanfile = null;
	static String tableName = null;
	static String model = null;
	static List<String> columnList = new ArrayList<String>();
	@SuppressWarnings("unchecked")
	public static boolean templateBean(String packname,String author,String desc,String tableNameBean,String alias) {
		List<Map<String, Object>> ma = ConnectionDataBase.getTableInfo();
		model = packname ;
		//生成实体目录
		packname = packname+".entity";
		beanfile= packname;
		for (int i = 0; i < ma.size(); i++) {
			Map<String, Object> map = ma.get(i);
			if(tableNameBean.equals(map.get("table"))){
				System.out.println(tableNameBean);
				
				if("".equals(alias)||alias==null){
					beanclass =  DataUnescape.camelLowerCase((String) map.get("table"));
					tableName = (String) map.get("table");
				}else{
					beanclass =  DataUnescape.camelLowerCase(alias);
					tableName = (String) map.get("table");
				}
				List<Map<String, Object>> object = (List<Map<String, Object>>) map.get("ColumnList");
				StringBuffer s = new StringBuffer();			
				StringBuffer s1 = new StringBuffer();
				for (int j = 0; j < object.size(); j++) {
					Map<String, Object> map2 = object.get(j);
					//id在父类中有
					if("id".equals((String)map2.get("CoulumnName"))){
	//					System.out.println(id+"--");
					}else{
						s1.append(content((String)map2.get("Column"),(String)map2.get("CoulumnName"),(String)map2.get("RemaRks")));
					}
					columnList.add((String)map2.get("CoulumnName"));
				}
				//生成get和set
				for (int j = 0; j < object.size(); j++) {
					Map<String, Object> map2 = object.get(j);
					if("id".equals((String)map2.get("CoulumnName"))){
					}else{
						s1.append(content2((String)map2.get("Column"),(String)map2.get("CoulumnName")));
					}
				}
				s1.append("\n}");
				if(isDate){
					s.append(getInstructions(author)+"\npackage "+FinalData.CODEMODELPACK+packname+";"+FAG_DATA
							+FAG_DATA_DATE+FAG_DATA+FAG_DATA_BASE+FAG_DATA+getAnnotation(beanclass,author,desc)+"\npublic class "+beanclass+" extends BaseEntity<"+beanclass+"> {"+FAG_DATA);
				}else{
					s.append(getInstructions(author)+"\npackage "+FinalData.CODEMODELPACK+packname+";"+FAG_DATA
							+ FAG_DATA_BASE+FAG_DATA+getAnnotation(beanclass,author,desc)+"\npublic class "+beanclass+" extends BaseEntity<"+beanclass+"> {"+FAG_DATA);
				}
				s.append(s1);
				//生成
				String fileName = FinalData.CODEMODEL+ packname.replaceAll("\\.", "/")+ "/";
				System.err.println(fileName);
				setCode(fileName, s,beanclass,1);
				isDate = false;
				//生成dao
				templateDao(model,author,desc,beanclass);
				return true;
			}
		}
		return false;
		
	}

	
	/**
	 * 生成dao文件
	 * @方法说明:
	 * @方法名称:templateDao
	 * @param packname
	 * @param author
	 * @param desc
	 * @param clazz
	 * @作者:zw
	 * @返回值:void
	 */
	static String daofiles = null;
	public static void templateDao(String packname,String author,String desc,String clazz) {
		packname = packname+".dao";
		daofiles = packname;
		StringBuffer s = new StringBuffer();
		s.append(getInstructions(author)+"\npackage "+FinalData.CODEMODELPACK+packname+";"+FAG_DATA
				+FAG_DATA_BASEDAO
				+"\nimport "+FinalData.CODEMODELPACK+beanfile+"."+beanclass+";\n"+FAG_DATA_BASEDAO_A
				+FAG_DATA+getAnnotation(clazz+"Dao",author,desc)+"\n"
				+"@MybatisDao\n"
				+"public interface "+clazz+"Dao extends CrudDao<"+clazz+"> {"+FAG_DATA+"}");
		String fileName = FinalData.CODEMODEL+ packname.replaceAll("\\.", "/")+ "/";
		setCode(fileName, s,clazz,2);
		//生成Service
		templateService(model,author,desc,beanclass);
	}

	/**
	 * 生成service文件
	 * @方法说明:
	 * @方法名称:templateService
	 * @param packname
	 * @param author
	 * @param desc
	 * @param clazz
	 * @作者:zw
	 * @返回值:void
	 */
	static String servicefiles = null;
	public static void templateService(String packname,String author,String desc,String clazz) {
		packname = packname+".service";
		servicefiles = packname;
		String h = DataUnescape.toLowerCaseFirstOne(clazz);
		StringBuffer s = new StringBuffer();
		s.append(getInstructions(author)+"\npackage "+FinalData.CODEMODELPACK+packname+";"+FAG_DATA
				+"import "+FinalData.CODEMODELPACK+beanfile+"."+beanclass+";\n"+FAG_DATA_BASEDAO_SERVICE
				+"\nimport "+FinalData.CODEMODELPACK+daofiles+"."+beanclass+"Dao"+";\n"
				+FAG_DATA_BASEDAO_PAGE+"\n"
				+ FAG_DATA_BASEDAO_UTIL+"\n"
				+FAG_DATA+getAnnotation(clazz+"Service",author,desc)+"\n"
				+"@Service\n"
				+"public class "+clazz+"Service {\n\n\t@Autowired\n\t"
				+ "private "+clazz+"Dao "+DataUnescape.toLowerCaseFirstOne(clazz)+"Dao;\n\n\t"
				+ "public int save"+clazz+"("+clazz+" "+h+") {\n\t\t"
				+ "return this."+h+"Dao.saveMode("+h+");\n\t"
				+ "}\n\n\tpublic Page<"+clazz+"> pageSelect(Page<"+clazz+"> page) {\n\t\t"
				+"page.setDataList(this."+h+"Dao.findSelectPage(page));\n\t\t"
				+ "return page;\n\t}\n\n\t"
				+ "public List<"+clazz+"> pageSelect("+clazz+" entity) {\n\t\t"
				+ "return this."+h+"Dao.findSelect(entity);\n\t}\n\n\t"
				+ "public "+clazz+" get("+clazz+" "+h+") {\n\t\t"
				+ "return this."+h+"Dao.getMode("+h+");\n\t}\n\n\t"
				+ "public int update"+clazz+"("+clazz+" "+h+") {\n\t\t"
				+ "return this."+h+"Dao.updateMode("+h+");\n\t}\n\n\t"
			    + "public int delete"+clazz+"("+clazz+" "+h+") {\n\t\t"
			    + "return this."+h+"Dao.deleteMode("+h+");\n\t}\n\n\t"
						+ ""+FAG_DATA+"}");
		String fileName = FinalData.CODEMODEL+ packname.replaceAll("\\.", "/")+ "/";
		setCode(fileName, s,clazz,3);
		templateController(model,author,desc,beanclass);
	}
	
	/**
	 * 生成Controller
	 * @方法说明:
	 * @方法名称:templateController
	 * @param packname
	 * @param author
	 * @param desc
	 * @param clazz
	 * @作者:张威
	 * @返回值:void
	 */
	public static void templateController(String packname,String author,String desc,String clazz) {
		packname = packname+".controller";
//		String h = DataUnescape.toLowerCaseFirstOne(clazz);
		StringBuffer s = new StringBuffer();
		s.append(getInstructions(author)+"\npackage "+FinalData.CODEMODELPACK+packname+";"+FAG_DATA
				+"import "+FinalData.CODEMODELPACK+beanfile+"."+beanclass+";\n"+FAG_DATA_BASEDAO_AUT
				+"\n"+FAG_DATA_BASEDAO_CONTROLLER
				+"\nimport "+FinalData.CODEMODELPACK+servicefiles+"."+beanclass+"Service"+";\n"
				+FAG_DATA_BASEDAO_PAGE+"\n"
				+SHIRO_PERMISSIONS+"\n"
				+ FAG_DATA_BASEDAO_UTIL+"\n"
				+FAG_DATA_BASEDAO_MAP+"\n"
				+FAG_DATA_BASEDAO_HTTP+"\n"
				+FAG_DATA+getAnnotation(clazz+"Controller",author,desc)+"\n"
				+"@Controller\n"
				+"@RequestMapping(value = \"/"+clazz+"\")\n"
				+"public class "+clazz+"Controller {\n\n\t@Autowired\n\t"
				+ "private "+clazz+"Service "+DataUnescape.toLowerCaseFirstOne(clazz)+"Service;\n\n\t"
				+ "@ResponseBody\n\t"
				+ "@RequiresPermissions(\"*\")\n\t"
				+ "@RequestMapping(value = { \"/"+DataUnescape.toLowerCaseFirstOne(clazz)+"List.do\" }, method = { RequestMethod.POST, RequestMethod.GET })\n\t"
				+"public Map<String,Object> list(@RequestBody "+clazz+" "+DataUnescape.toLowerCaseFirstOne(clazz)+",HttpServletRequest request,HttpServletResponse response){\n\t\t"
						+ "Map<String,Object> map = new HashMap<String,Object>();	\n\t\t"
						+ "return map;\n\t"
						+ "}\n"
				+ ""+FAG_DATA+"}");
		String fileName = FinalData.CODEMODEL+ packname.replaceAll("\\.", "/")+ "/";
		setCode(fileName, s,clazz,4);
	}
	
	
	/**
	 * 类型转换
	 * @方法说明:
	 * @方法名称:getColumnType
	 * @param ct
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static boolean isDate = false;
	public static String getColumnType(String ct){
		if(ct.contains("DATE")||ct.contains("DATETIME")||ct.contains("DATETIME")){
			ct = "Date";
			isDate = true;
		}else if(ct.contains("INT")){
			ct = "Integer";
		}else if(ct.contains("FLOAT")){
			ct = "Float";
		}else if(ct.contains("DOUBLE")){
			ct = "Double";
		}
		else{
			ct = "String";
		}
		return ct;
	}
	/**
	 *  代码生成
	 * @方法说明:
	 * @方法名称:getCode
	 * @param ta
	 * @param data
	 * @param pageName
	 * @作者:zw
	 * @返回值:void
	 */
	public static void setCode(String fileName,StringBuffer data,String clazz,int i){
		try {
			File f = new File(fileName);
			if(!f.exists() && !f .isDirectory()){    
			    f.mkdirs();    
			}
			if(i==1){
				f = new File(fileName+ "/" + clazz+".java");
			}else if(i==2){
				f = new File(fileName+ "/" + clazz+"Dao.java");
			}else if(i==3){
				f = new File(fileName+ "/" + clazz+"Service.java");
			}else if(i==4){
				f = new File(fileName+ "/" + clazz+"Controller.java");
			}
			FileWriter fw = new FileWriter(f);
			fw.write(data.toString());
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 拼接属性的方法
	 * @方法说明:
	 * @方法名称:content
	 * @param c 类型
	 * @param n 字段名
	 * @param r 注释
	 * @return
	 * @作者:zw
	 * @返回值:StringBuffer
	 */
	public static StringBuffer content(String c,String n,String r){
		StringBuffer s = new StringBuffer();
//		s.append("\t/** "+r+"*/\n");
		s.append("\tprivate "+getColumnType(c)+" "+DataUnescape.camelUpperCase(n)+";\t//"+r+" \n");
		return s;
	}
	/**
	 * 拼接set 和get方法
	 * @方法说明:
	 * @方法名称:content2
	 * @param c 类型
	 * @param n 字段名
	 * @return
	 * @作者:zw
	 * @返回值:StringBuffer
	 */
	public static StringBuffer content2(String c,String n){
		StringBuffer s = new StringBuffer();
		c = getColumnType(c);
		String n1 = DataUnescape.camelLowerCase(n);
		String n2 = DataUnescape.camelUpperCase(n);
		s.append("\n\tpublic "+ c+" get"+n1+"() {"
				+ "\n\t\t return "+n2+";"+"\n\t}"
				);
		s.append("\n\tpublic void set"+n1+"("+c+" "+n2+") {"
				+ "\n\t\t this."+n2+" = "+n2+";\n\t}"
				);
		return s;
	}

	/**
	 * 生成所有代码
	 * @方法说明:
	 * @方法名称:get
	 * @param packname 生成目录
	 * @param author 生产者
	 * @param desc 模块介绍
	 * @param tableNameBean 表名
	 * @param alias 别名（两套代码）
	 * @return
	 * @作者:张威
	 * @返回值:boolean
	 */
	public static boolean get(String packname,String author,String desc,String tableNameBean,String alias) {
		boolean bean = templateBean(packname, author, desc,tableNameBean,alias);
		if(bean){
//			在xml中直接引用的别名
//			ConfigurationXml.saveXml(FinalData.APPLICATIONMVC,FinalData.CODEMODELPACK+packname+".entity."+beanclass);
			TemplateXML.template(FinalData.CODEMODELPACK+packname,tableName,alias,columnList);
		}
		return bean;
	}
//	public static void main(String[] args) {
//		get("sys", "zw", "系统用户","sys_user");
//	}
}
