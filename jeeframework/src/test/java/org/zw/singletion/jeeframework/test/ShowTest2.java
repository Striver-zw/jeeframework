package org.zw.singletion.jeeframework.test;



import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.zw.singleton.jeeframework.common.utils.spider.Spider;
import org.zw.singleton.jeeframework.modules.appinterface.appuser.service.AppUserService;
import org.zw.singleton.jeeframework.modules.appinterface.bookdesc.entity.AppBookdesc;
import org.zw.singleton.jeeframework.modules.appinterface.bookdesc.service.AppBookdescService;
import org.zw.singleton.jeeframework.modules.appinterface.bookinfo.entity.AppBookinfo;
import org.zw.singleton.jeeframework.modules.appinterface.bookinfo.service.AppBookinfoService;
import org.zw.singleton.jeeframework.modules.appinterface.bookintem.entity.AppBookintem;
import org.zw.singleton.jeeframework.modules.appinterface.bookintem.service.AppBookintemService;
import org.zw.singleton.jeeframework.modules.appinterface.booktype.entity.AppBooktype;
import org.zw.singleton.jeeframework.modules.appinterface.booktype.service.AppBooktypeService;
import org.zw.singleton.jeeframework.modules.appinterface.joke.entity.AppJoke;
import org.zw.singleton.jeeframework.modules.appinterface.joke.service.AppJokeService;
import org.zw.singleton.jeeframework.modules.appinterface.riddleitem.entity.AppRiddleitem;
import org.zw.singleton.jeeframework.modules.appinterface.riddleitem.service.AppRiddleitemService;
import org.zw.singleton.jeeframework.modules.appinterface.riddletype.entity.AppRiddletype;
import org.zw.singleton.jeeframework.modules.appinterface.riddletype.service.AppRiddletypeService;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

import com.show.api.ShowApiRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


//public class ShowTest2 extends  BaseTest {

//	@Autowired
//	private AppJokeService aj;
//
//	
//	 @Test
//	public void insetS6() {
//		
//		 for (int i = 90; i < 100; i++) {
//			
//		
//				String res = new ShowApiRequest("https://route.showapi.com/341-1", "4786",
//						"c6852f2dfc4d45d5ae183632733f16c4").addTextPara("time", "2015-07-10")
//								.addTextPara("page", ""+i)
//								// .addTextPara("limit", "40")
//								.post();
//				JSONObject obj = JSONObject.fromObject(res);
//				String showapi_res_body = obj.getString("showapi_res_body");
//				System.out.println(showapi_res_body);
//				obj = JSONObject.fromObject(showapi_res_body);
////				obj = obj.getJSONObject("pagebean");
//				JSONArray array = obj.getJSONArray("contentlist");
//				System.out.println(array.size());
//				if (array.size() > 0) {
//					for (int j = 0; j < array.size(); j++) {
//						AppJoke bean = (AppJoke) JSONObject.toBean((JSONObject) array.get(j),
//								AppJoke.class);
////						 System.out.println(bean.getTitle());
////						rsd.saveAppRiddleitem(bean);
////						 if(bean.getImg()!=null){
////								String imgeUrl = bean.getImg();
//////								imgeUrl = imgeUrl.replaceAll("www.yi18.net","www.1ccf.com");
////								System.out.println(imgeUrl);
////								Spider.downImage("D:\\del\\Java_Project\\jeeframework\\src\\main\\webapp\\appfilter\\appinterface\\joke", imgeUrl);
////								String fileImage = imgeUrl.substring(imgeUrl.lastIndexOf("/"));
////								fileImage = "jeeframework/appinterface/joke"+fileImage;
////								System.out.println(fileImage);
////								bean.setImg(fileImage);
////							}
//						 aj.saveAppJoke(bean);
//					}
//				}
//		 }
//
//	}

//}
