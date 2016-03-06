package org.zw.singleton.jeeframework.app.sms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.zw.singleton.jeeframework.app.sms.utils.SmsClientSend;
import org.zw.singleton.jeeframework.common.utils.properties.GetPropertiesKey;

/**
 * http://www.dxton.com/
 * 短信通接口
  * @类名:SMSService
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月4日-下午5:09:51
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class SMSService{

//	@Override
//	public HashMap<String, Object> sendSMS(String phone,
//			String templateID, String verificationcode, String expireMinutes) {
//		
//		HashMap<String, Object> result = null;
//		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
//		
//		//*沙盒环境（用于应用开发调试）：restAPI.init("sandboxapp.cloopen.com", "8883");*
//		//*生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com", "8883");       *
//		restAPI.init("sandboxapp.cloopen.com", "8883");
//		//restAPI.init("app.cloopen.com", "8883");
//		
//		//*初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN     *
//		//*ACOUNT SID和AUTH TOKEN在登陆官网后，在“应用-管理控制台”中查看开发者主账号获取*
//		//*参数顺序：第一个参数是ACOUNT SID，第二个参数是AUTH TOKEN。                   *
//		restAPI.setAccount("8a48b5514cfa209e014cfdaf7277020d",
//				"5242370ac1734551b3f9f56f6894f8a7");
//		
//		//*初始化应用ID                                                                 *
//		//*测试开发可使用“测试Demo”的APP ID，正式上线需要使用自己创建的应用的App ID     *
//		//*应用ID的获取：登陆官网，在“应用-应用列表”，点击应用名称，看应用详情获取APP ID*
//		//restAPI.setAppId("8a48b5514cfa209e014cfdb0f8f60210");
//		restAPI.setAppId("8a48b5514d2d8602014d2da0ce180031");
//		
//		
//		result = restAPI.sendTemplateSMS(phone, "1", new String[] {
//				verificationcode, expireMinutes });
//		System.out.println("SDKTestGetSubAccounts result=" + result);
//		if ("000000".equals(result.get("statusCode"))) {
//			// 正常返回输出data包体信息（map）
//			HashMap<String, Object> data = (HashMap<String, Object>) result
//					.get("data");
//			Set<String> keySet = data.keySet();
//			for (String key : keySet) {
//				Object object = data.get(key);
//				System.out.println(key + " = " + object);
//			}
//		} else {
//			// 异常返回输出错误码和错误信息
//			System.out.println("错误码=" + result.get("statusCode") + " 错误信息= "
//					+ result.get("statusMsg"));
//		}
//		return result;
//	}
	/**
	 * 短信接口
	 * @方法说明:
	 * @方法名称:sendSMS
	 * @param phone
	 * @param templateID
	 * @param verificationcode
	 * @param expireMinutes	5分钟
	 * @return  
	 * @作者:张威
	 * @返回值:HashMap<String,Object>
	 */
	public void sendSMS(String phone,
		String templateID, String verificationcode, String expireMinutes) {
		List<String> data = new ArrayList<String>();
		data.add("url");
		data.add("password");
		data.add("account");
		data.add("userid");
		Map<String, Object> value = GetPropertiesKey.getValue(data,"sms.properties");
		SmsClientSend sms = new SmsClientSend();
		String url= (String) value.get("url");
		String userid= (String) value.get("userid");
		String account= (String) value.get("account");
		String password= (String) value.get("password");
		String msg = "您好,您的验证码为 ，"+expireMinutes+"分钟内有效。";
		System.out.println("发送的短信内容为："+msg);
		String rst = sms.sendSms(url, userid, account, password, phone, msg);
		System.out.println("短信接口返回："+rst);
	}
	
//	public static void main(String[] args) {
//		SMSService s = new SMSService();
//		s.sendSMS("", "1","1111", "5");
//	}
}
