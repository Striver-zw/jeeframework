package org.zw.singleton.jeeframework.common.utils.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
/**
 * 获取移动端请求数据
  * @类名:BaseDataCourier
  * @类描述:
  * @作者:
  * @创建时间:2015年9月17日-下午2:10:18
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright (c)-2015
 */

public class BaseDataController {
	private static final long serialVersionUID = 1840781866260208879L;

	protected String rel;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String appname;
	protected String version;
	protected String from;
	protected String udid;
	protected JSONObject reqPayloadBody = new JSONObject();
	protected JSONObject respObj = new JSONObject();
	
	
	public BaseDataController( HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.request=request;
		this.response = response;
		populateRequestData();
	}
	
	
	public BaseDataController() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}
	
	
	public JSONObject getReqPayloadBody() {
		return reqPayloadBody;
	}

	public void setReqPayloadBody(JSONObject reqPayloadBody) {
		this.reqPayloadBody = reqPayloadBody;
	}



	protected void setResponse(HttpServletResponse response) {
		// 设置编码
		// response.setContentType（"text/html; charset=utf-8"）; html
		// response.setContentType（"text/plain; charset=utf-8"）; 文本
		// response.setContentType（"text/javascript; charset=utf-8"）; json数据
		// response.setContentType（"application/xml; charset=utf-8"）; xml数据
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// 设置浏览器不要缓存
		response.setHeader("Cache-Control", "no-store"); // HTTP1.1
		response.setHeader("Pragma", "no-cache"); // HTTP1.0
		response.setDateHeader("Expires", 0);
		// logger.info("BaseAction");
	}

	protected String urlEncoder(String url) {
		if (url == null) {
			return null;
		}
		try {
			return URLEncoder.encode(url, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	/**
	 * 得到数据流转换
	 * @方法说明:
	 * @方法名称:getPostPayload
	 * @return
	 * @throws IOException
	 * @作者:张威
	 * @返回值:	JSONObject
	 */
	public JSONObject getPostPayload() throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = null;
		reader = request.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line).append('\n');
		}
		return JSONObject.fromObject(sb.toString());
	}
	
	
	
	/**
	 * 得到前端网页数据
	 * @方法说明:callback=jQuery110205832927878946066_1453191465117&{%22from%22:%222%22,%22uuid%22:%222%22}&_=1453191465118
	 * @方法名称:getPostPayload
	 * @return
	 * @throws IOException
	 * @作者:zw
	 * @返回值:JSONObject
	 */
	public JSONObject getPostPayloadbrooss(HttpServletRequest request) throws IOException {
		String requestURI = request.getQueryString();
//		System.out.println(requestURI);
		String[] split = requestURI.split("&");
		String decode = null;
		if(split!=null&&split.length>0){
			for (int i = 0; i < split.length; i++) {
				if(split[i].indexOf("{")!=-1){
					decode = java.net.URLDecoder.decode(split[i],"UTF-8");
				}
			}
			return JSONObject.fromObject(decode.toString());
		}
		return null;
	}
	

	/**
	 * 
	 * @方法说明:
	 * @方法名称:populateRequestData
	 * @throws Exception
	 * @作者:张威
	 * @返回值:void
	 */
	public void populateRequestData() throws Exception {
		JSONObject reqPayload = getPostPayload();
		if (null != reqPayload) {
			this.reqPayloadBody = reqPayload.getJSONObject("reqBody");
			this.uid=reqPayload.optString("uid");
			this.udid=reqPayload.optString("udid");
			this.appname = reqPayload.optString("appname");
			this.version = reqPayload.optString("version");
			this.from = reqPayload.optString("from");
			this.usertoken = reqPayload.optString("usertoken");
		}
	}
	
	/**
	 * 判断是否传了id
	 * @方法说明:
	 * @方法名称:isRequestNull
	 * @return
	 * @作者:张威
	 * @返回值:boolean
	 */
	public boolean isRequestNull(){
		if(!"".equals(uid) && uid != null) return true;
		return false;
	}
	
	/**
	 * 判断传入参数是否为空
	 * @方法说明:
	 * @方法名称:isParameterNull
	 * @param parameter
	 * @return
	 * @作者:zw
	 * @返回值:boolean
	 */
	public boolean isParameterNull(String parameter){
		System.out.println(parameter.length());
		if("".equals(parameter) || parameter == null) return false;
		if(" ".equals(parameter) || parameter == " ") return false;
		return true;
	}
	
	/**
	 * 返回错误信息
	 * @方法说明:
	 * @方法名称:isJudgeNull
	 * @param map
	 * @param type
	 * @return
	 * @作者:zw
	 * @返回值:Map<String,Object>
	 */
	public Map<String, Object> isJudgeNull(Map<String, Object> map,int type){
		map.put("status",0);
//		map.put("msg", Constant.BASE_ERROR_PARAMETER);
		if(type ==1){
			map.put("data", new ArrayList<Map<String,Object>>());
		}else{
			map.put("data", new HashMap<String,Object>());
		}
		return map;
	}
	private String uid;
	private String usertoken;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsertoken() {
		return usertoken;
	}

	public void setUsertoken(String usertoken) {
		this.usertoken = usertoken;
	}
	
}
