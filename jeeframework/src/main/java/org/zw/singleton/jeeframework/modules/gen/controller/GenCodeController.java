/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-16 23:04:56
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.gen.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.directwebremoting.util.SystemOutLoggingOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zw.singleton.jeeframework.common.generatedcode.ConnectionDataBase;
import org.zw.singleton.jeeframework.common.generatedcode.TemplateJava;
import org.zw.singleton.jeeframework.common.utils.random.IdGen;
import org.zw.singleton.jeeframework.modules.basis.shiro.utils.ShiroPrincipal;
import org.zw.singleton.jeeframework.modules.gen.entity.GenCode;
import org.zw.singleton.jeeframework.modules.gen.entity.SqlInfo;
import org.zw.singleton.jeeframework.modules.gen.service.GenCodeService;
import org.zw.singleton.jeeframework.modules.sys.entity.SysUser;


/**  
  * @className:GenCodeController
  * @description:代码生成
  * @author: singleton_zw
  * @createDate: 2016-02-16 23:04:56
  * @updateAuthor:
  * @updateDate:
  * @updateDesc:
  * @version:
  * @Copyright
*/
@Controller
@RequestMapping(value = "/genCode")
public class GenCodeController {

	@Autowired
	private GenCodeService genCodeService;

//	@ResponseBody
//	@RequiresPermissions("*")
	@RequestMapping(value = { "genCodeList.do","genCodeList" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String list(HttpServletRequest request,HttpServletResponse response,Model model){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("codelist", ConnectionDataBase.getTableInfos());
		List<GenCode> pageSelect = genCodeService.pageSelect(new GenCode());
//		System.err.println(pageSelect.size());
		List<SqlInfo> tableInfos = ConnectionDataBase.getTableInfos();
		List<SqlInfo> tableInfoslist = new ArrayList<SqlInfo>();
		for(SqlInfo taInfo : tableInfos){
			for (GenCode g :pageSelect) {
				if(taInfo.getTableName().contains(g.getTableName())){
					taInfo.setStatus(1);
				}else{
					taInfo.setStatus(0);
				}
			}
			tableInfoslist.add(taInfo);
		}
//		System.err.println(tableInfoslist);
		model.addAttribute("codelist", tableInfoslist);
		return "gen/gencodeList";
	}
	/**
	 * 
	 * @MethodsDescription:
	 * @MethodName:list2
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @Author:singleton-zw
	 * @Return:String
	 */
//	@ResponseBody
	@RequestMapping(value = { "list2" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String list2(HttpServletRequest request,HttpServletResponse response,Model model){
//		Map<String,Object> map = new HashMap<String,Object>();
//		List<GenCode> pageSelect = genCodeService.pageSelect(new GenCode());
		return "gen/list";
	}
	
	@ResponseBody
	@RequestMapping(value = { "list" }, method = { RequestMethod.POST, RequestMethod.GET })
	public List<GenCode> list3(HttpServletRequest request,HttpServletResponse response,Model model){
		Map<String,Object> map = new HashMap<String,Object>();
		List<GenCode> pageSelect = genCodeService.pageSelect(new GenCode());
		return pageSelect;
	}
	
//	@ResponseBody
	@RequestMapping(value = { "getdata" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String getdata(String oper,String id,HttpServletRequest request,HttpServletResponse response,Model model){
		System.err.println(oper+"--------------"+id);
		return "gen/list";
	}
	
	/**
	 * 
	 * @MethodsDescription:
	 * @MethodName:listinfo
	 * @param tableName
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @Author:singleton-zw
	 * @Return:String
	 */
	@RequestMapping(value = { "sqlInfo" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String listinfo(String tableName,HttpServletRequest request,HttpServletResponse response,Model model){
//		Map<String,Object> map = new HashMap<String,Object>();
		List<SqlInfo> tableInfos = ConnectionDataBase.getTableInfos();
		SqlInfo s = new SqlInfo();
		for (int i = 0; i < tableInfos.size(); i++) {
			if(tableInfos.get(i).getTableName().contains(tableName)) s = tableInfos.get(i);
		}
//		System.err.println(s);
		model.addAttribute("sqlInfo", s);
		return "gen/sqlInfo";
	}
//	@ResponseBody
////	@RequiresPermissions("*")
//	@RequestMapping(value = { "/genCodeList.do" }, method = { RequestMethod.POST, RequestMethod.GET })
//	public Map<String,Object> list(HttpServletRequest request,HttpServletResponse response){
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("codelist", ConnectionDataBase.getTableInfos());
//		return map;
//	}
	
	/**
	 * @MethodsDescription:生成代码
	 * @MethodName:add
	 * @param model
	 * @return
	 * @Author:singleton-zw
	 * @Return:String
	 */
	@RequestMapping(value="add",method = { RequestMethod.POST, RequestMethod.GET })
	public String add(String tableName,Model model) {
		model.addAttribute("tableName", tableName);
		model.addAttribute("userName", ShiroPrincipal.getPrincipalSys().getLoginName());
		return "gen/from";
	}
	
	/**
	 * 
	 * @MethodsDescription:
	 * @MethodName:save
	 * @param genCode
	 * @param model
	 * @return
	 * @Author:singleton-zw
	 * @Return:String
	 */
	
	@RequestMapping(value="save",method = { RequestMethod.POST, RequestMethod.GET })
	public String save(GenCode genCode,Model model) {
//		System.err.println(genCode);
		boolean b = TemplateJava.get(genCode.getTemplateName(), genCode.getAuthor(), genCode.getDesc(),genCode.getTableName(),genCode.getAlias());
		if(b){
//			System.out.println("生成成功");
			genCode.setId(IdGen.getUUID());
			genCode.setCreatedate(new Date());
			genCodeService.saveGenCode(genCode);
			return "redirect:genCodeList";
		}else{
			System.out.println("表不存在");
		}
		return "";
	}


}