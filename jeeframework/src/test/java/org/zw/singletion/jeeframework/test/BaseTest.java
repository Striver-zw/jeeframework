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
import org.zw.singleton.jeeframework.modules.appinterface.riddleitem.entity.AppRiddleitem;
import org.zw.singleton.jeeframework.modules.appinterface.riddleitem.service.AppRiddleitemService;
import org.zw.singleton.jeeframework.modules.appinterface.riddletype.entity.AppRiddletype;
import org.zw.singleton.jeeframework.modules.appinterface.riddletype.service.AppRiddletypeService;
import org.zw.singleton.jeeframework.modules.basis.page.Page;
import org.zw.singleton.jeeframework.modules.sys.entity.SysUser;
import org.zw.singleton.jeeframework.modules.sys.service.SysUserService;

import com.show.api.ShowApiRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@ContextConfiguration(locations={"/application-mvc.xml","/application-shiro.xml"})
public class BaseTest extends  AbstractJUnit4SpringContextTests {

//////
//	private AppUserService appUserService;
	@Autowired
	private SysUserService s;
//
////////	
////////	
	@Test
	public void insetY(){
		SysUser user = s.getByLoginName("zw", "123");
		System.out.println(user);
//		
////		appUserService.pageSelect(new AppUser());
////		scheduleJobService.initScheduleJob();
////		Appuser appuser = new Appuser();
////		appuser.setPhone(111);
////		appuser.setUserpassword("aa");
////		Appuser loginUser = appuserService.loginAppuser(appuser);
////		System.out.println(loginUser.getId());
////		System.out.println(sysUserService.toString());
////		SysUser s = new SysUser();
////		s.setId(1);
////		SysUser sysUser = sysUserService.get(s);
////		System.out.println(sysUser.getSysName());
////		System.out.println(sysUser.getSysDouble());
////		System.out.println(sysUser.getSysFloat());
////		System.out.println(sysUser.getSysInt());
//////		try {
////////			System.out.println(admainUserService.selectTotalRecord()+"");
//////			Page<AdmainUser> page = new Page<AdmainUser>();
//////			Page<AdmainUser> page2 = admainUserService.pageSelect(page);
//////			System.out.println(page2.getDataList().size());
//////		} catch (Exception e) {
//////			// TODO Auto-generated catch block
//////			e.printStackTrace();
//////		}
	}
//	
////	public static void logi(){
////		// 获得当前类名
////				String clazz = Thread.currentThread() .getStackTrace()[1].getClassName();
////				// 获得当前方法名
////				String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
////				System.out.println(method);
////	}
////	
////	public static void main(String[] args) {
////		GenericClass<BaseTest> g = new GenericClass<BaseTest>();
////		g.getMether(BaseTest);
////	}
//	
//	@Autowired
//	private AppBooktypeService appBooktypeService;
//	
//	@Test
//	public void insetS(){
//		String res = new ShowApiRequest("https://route.showapi.com/92-93", "4786", "c6852f2dfc4d45d5ae183632733f16c4")
//				// .addTextPara("page","")
//				// .addTextPara("limit","")
//				// .addTextPara("keyword","")
//				.post();
//		// System.out.println(res);
//		JSONObject obj = JSONObject.fromObject(res);
//		String showapi_res_body = obj.getString("showapi_res_body");
//		System.out.println(showapi_res_body);
//		obj = JSONObject.fromObject(showapi_res_body);
//		JSONArray jsonArray = obj.getJSONArray("bookClass");
//		System.out.println(jsonArray.size());
//		for (int i = 0; i < jsonArray.size(); i++) {
//			JSONObject js = (JSONObject) jsonArray.get(i);
//			AppBooktype appBooktype = new AppBooktype();
//			appBooktype.setId(js.optString("id"));
//			appBooktype.setName(js.optString("name"));
//			appBooktypeService.saveAppBooktype(appBooktype);
//		}
////
////System.err.println("=====================================================");
////
//
////
//
//	}
//	@Autowired
//	private AppBookdescService desc;
//	@Test
//	public void insetS1() {
//		String res = new ShowApiRequest("https://route.showapi.com/92-92", "4786", "c6852f2dfc4d45d5ae183632733f16c4")
//				.addTextPara("page", "2").addTextPara("limit", "40").addTextPara("id", "11")
//				.addTextPara("type", "id").post();
//		// System.out.println(res);
//		JSONObject obj = JSONObject.fromObject(res);
//		String showapi_res_body = obj.getString("showapi_res_body");
//		System.out.println(showapi_res_body);
//		obj = JSONObject.fromObject(showapi_res_body);
//		JSONArray jsonArray = obj.getJSONArray("bookList");
//		System.out.println(jsonArray.size());
//		if(jsonArray.size()>0){
//			for (int i = 0; i < jsonArray.size(); i++) {
//				AppBookdesc bean = (AppBookdesc) JSONObject.toBean((JSONObject) jsonArray.get(i), AppBookdesc.class);
//				bean.setTypeId(11);
//				String imgeUrl;
//				if(bean.getImg()!=null){
//					imgeUrl = bean.getImg();
//					imgeUrl = imgeUrl.replaceAll("www.yi18.net","www.1ccf.com");
//					System.out.println(imgeUrl);
//					Spider.downImage("D:\\del\\Java_Project\\jeeframework\\src\\main\\webapp\\appfilter\\appinterface\\books\\20160109", imgeUrl);
//					String fileImage = imgeUrl.substring(imgeUrl.lastIndexOf("/"));
//					fileImage = "jeeframework/appinterface/books/20160109"+fileImage;
//					System.out.println(fileImage);
//					bean.setImg(fileImage);
//				}
//				desc.saveAppBookdesc(bean);
//			}
//		}
//	}
//	
//	 @Test
//	    public void test() {
//			Spider.downImage("D:\\del\\Java_Project\\jeeframework\\src\\main\\webapp\\appfilter\\appinterface\\books\\20160102", "http://www.1ccf.com/img/book/0000239.jpg");
////	        String path = "http://www.hackvip.com/desk/d/0/3/2006110911245141091.jpg";
////	        try {
////	            new DownThread().resourceDownLoad(path);
////	        } catch (Exception e) {
////	            e.printStackTrace();
////	        }
//	    }
//	 
//	 @Autowired
//	 private AppBookinfoService aps;
//	 
//	 @Test
//		public void insetS2() {
//			List<AppBookdesc> pageSelect = desc.pageSelect(new AppBookdesc());
//			System.out.println(pageSelect.size());
//			//1835
//			for (int i = 400; i <440; i++) {
//				AppBookdesc bookdesc = pageSelect.get(i);
//				String res = new ShowApiRequest("https://route.showapi.com/92-91", "4786", "c6852f2dfc4d45d5ae183632733f16c4")
//						.addTextPara("id", bookdesc.getId()).post();
//				System.out.println(bookdesc.getId());
//				JSONObject obj = JSONObject.fromObject(res);
//				String showapi_res_body = obj.getString("showapi_res_body");
////				System.out.println(showapi_res_body);s
//				obj = JSONObject.fromObject(showapi_res_body);
//				JSONObject object = obj.getJSONObject("bookDetails");
//				String bookclass = object.getString("bookclass");
//				int bh = Integer.parseInt(bookclass);
//				String id = object.getString("id");
//				int hh = Integer.parseInt(id);
//				System.out.println(bookclass);
//				JSONArray array = object.getJSONArray("list");
//				if(array.size()>0){
//					for (int j = 0; j < array.size(); j++) {
//						JSONObject ob = (JSONObject) array.get(j);
//						AppBookinfo ap = new AppBookinfo(ob.getString("id"), ob.getString("title"), bh,hh);
////						System.out.println(ap.toString());
//						aps.saveAppBookinfo(ap);
//					}
//				}
//				System.out.println(array.size());
//			}
//		}
//	 @Autowired
//	 private AppBookinfoService as;
//	 @Autowired
//	 private AppBookintemService gh;
//	 @Test
//		public void insetS3() {
//			List<AppBookinfo> pageSelect = as.pageSelect(new AppBookinfo());
//			System.out.println(pageSelect.size());
//			//1835
////				for (int i = 415; i <430; i++) {
//			for (int i = 700; i <715; i++) {
////			for (int i = 615; i <630; i++) {
////				for (int i = 600; i <615; i++) {
////				for (int i = 1000; i <1015; i++) {
////				for (int i = 230; i <240; i++) {
//				AppBookinfo bookdesc = pageSelect.get(i);
//				String res = new ShowApiRequest("https://route.showapi.com/92-32", "4786", "c6852f2dfc4d45d5ae183632733f16c4")
//						.addTextPara("id", bookdesc.getId()).post();
//				System.out.println(bookdesc.getId());
//				JSONObject obj = JSONObject.fromObject(res);
//				String showapi_res_body = obj.getString("showapi_res_body");
//				System.out.println(showapi_res_body);
//				obj = JSONObject.fromObject(showapi_res_body);
//				JSONObject object = obj.getJSONObject("bookDetails");
//				AppBookintem bean = (AppBookintem) JSONObject.toBean(object, AppBookintem.class);
//				System.out.println(bean.getTitle());
//				gh.saveAppBookintem(bean);
//		}
//	 }
//	 @Autowired
//	 private AppRiddletypeService rs;
//	 @Test
//	 public void insetS4() {
//	
//			 String res = new ShowApiRequest("https://route.showapi.com/151-3", "4786", "c6852f2dfc4d45d5ae183632733f16c4")
////					 .addTextPara("id", bookdesc.getId())
//					 .post();
//			 JSONObject obj = JSONObject.fromObject(res);
//			 String showapi_res_body = obj.getString("showapi_res_body");
//			 System.out.println(showapi_res_body);
//			 obj = JSONObject.fromObject(showapi_res_body);
//			 JSONArray array = obj.getJSONArray("typeList");
//			 System.out.println(array.size());
//			 for (int i = 0; i <array.size(); i++) {
//				 AppRiddletype bean = (AppRiddletype) JSONObject.toBean((JSONObject) array.get(i), AppRiddletype.class);
//				 bean.setTypeId(i+1);
////				 System.out.println(bean.getTypeId());
//				 rs.saveAppRiddletype(bean);
//			}
//
//	 }
	 
//	 @Autowired
//	 private AppRiddleitemService rsd;
//	 @Test
//	public void insetS5() {
//		List<AppRiddletype> pageSelect = rs.pageSelect(new AppRiddletype());
//		System.out.println(pageSelect.size());
//		for (int i = 26; i < 27; i++) {
//			AppRiddletype riddletype = pageSelect.get(i);
//			System.out.println(riddletype.getId());
//			for (int j1 = 10; j1 < 10; j1++) {
//				System.err.println(j1);
//				String res = new ShowApiRequest("https://route.showapi.com/151-4", "4786",
//						"c6852f2dfc4d45d5ae183632733f16c4").addTextPara("typeId", riddletype.getId())
//								.addTextPara("page", "" + j1)
//								// .addTextPara("limit", "40")
//								.post();
//				JSONObject obj = JSONObject.fromObject(res);
//				String showapi_res_body = obj.getString("showapi_res_body");
//				System.out.println(showapi_res_body);
//				obj = JSONObject.fromObject(showapi_res_body);
//				obj = obj.getJSONObject("pagebean");
//				JSONArray array = obj.getJSONArray("contentlist");
//				System.out.println(array.size());
//				if (array.size() > 0) {
//					for (int j = 0; j < array.size(); j++) {
//						AppRiddleitem bean = (AppRiddleitem) JSONObject.toBean((JSONObject) array.get(j),
//								AppRiddleitem.class);
////						 System.out.println(bean.getAnswer());
//						rsd.saveAppRiddleitem(bean);
//					}
//				}
//			}
//		}
//
//	}
////	 @Test
//	 public void insetS5h(String ig) {
//		 List<AppRiddletype> pageSelect = rs.pageSelect(new AppRiddletype());
//		 System.out.println(pageSelect.size());
//		 for (int i = 1; i < 2; i++) {
//			 AppRiddletype riddletype = pageSelect.get(i);
//			 System.out.println(riddletype.getId());
//			 String res = new ShowApiRequest("https://route.showapi.com/151-4", "4786", "c6852f2dfc4d45d5ae183632733f16c4")
//					 .addTextPara("typeId", riddletype.getId())
//					 .addTextPara("page", ig)
////					 .addTextPara("limit", "40")
//					 .post();
//			 JSONObject obj = JSONObject.fromObject(res);
//			 String showapi_res_body = obj.getString("showapi_res_body");
//			 System.out.println(showapi_res_body);
//			 obj = JSONObject.fromObject(showapi_res_body);
//			 obj = obj.getJSONObject("pagebean");
//			 JSONArray array = obj.getJSONArray("contentlist");
//			 System.out.println(array.size());
//			 if(array.size()>0){
//				 for (int j = 0;j<array.size(); j++) {
//					 AppRiddleitem bean = (AppRiddleitem) JSONObject.toBean((JSONObject) array.get(j), AppRiddleitem.class);
////				 System.out.println(bean.getAnswer());
//					 rsd.saveAppRiddleitem(bean);
//				 }
//			 }
//		 }
//		 for (int i = 2; i < 3; i++) {
//			 AppRiddletype riddletype = pageSelect.get(i);
//			 System.out.println(riddletype.getId());
//			 String res = new ShowApiRequest("https://route.showapi.com/151-4", "4786", "c6852f2dfc4d45d5ae183632733f16c4")
//					 .addTextPara("typeId", riddletype.getId())
//					 .addTextPara("page", ig)
////					 .addTextPara("limit", "40")
//					 .post();
//			 JSONObject obj = JSONObject.fromObject(res);
//			 String showapi_res_body = obj.getString("showapi_res_body");
//			 System.out.println(showapi_res_body);
//			 obj = JSONObject.fromObject(showapi_res_body);
//			 obj = obj.getJSONObject("pagebean");
//			 JSONArray array = obj.getJSONArray("contentlist");
//			 System.out.println(array.size());
//			 if(array.size()>0){
//				 for (int j = 0;j<array.size(); j++) {
//					 AppRiddleitem bean = (AppRiddleitem) JSONObject.toBean((JSONObject) array.get(j), AppRiddleitem.class);
////				 System.out.println(bean.getAnswer());
//					 rsd.saveAppRiddleitem(bean);
//				 }
//			 }
//		 }
//		 for (int i = 3; i < 4; i++) {
//			 AppRiddletype riddletype = pageSelect.get(i);
//			 System.out.println(riddletype.getId());
//			 String res = new ShowApiRequest("https://route.showapi.com/151-4", "4786", "c6852f2dfc4d45d5ae183632733f16c4")
//					 .addTextPara("typeId", riddletype.getId())
//					 .addTextPara("page", ig)
////					 .addTextPara("limit", "40")
//					 .post();
//			 JSONObject obj = JSONObject.fromObject(res);
//			 String showapi_res_body = obj.getString("showapi_res_body");
//			 System.out.println(showapi_res_body);
//			 obj = JSONObject.fromObject(showapi_res_body);
//			 obj = obj.getJSONObject("pagebean");
//			 JSONArray array = obj.getJSONArray("contentlist");
//			 System.out.println(array.size());
//			 if(array.size()>0){
//				 for (int j = 0;j<array.size(); j++) {
//					 AppRiddleitem bean = (AppRiddleitem) JSONObject.toBean((JSONObject) array.get(j), AppRiddleitem.class);
////				 System.out.println(bean.getAnswer());
//					 rsd.saveAppRiddleitem(bean);
//				 }
//			 }
//		 }
//		 for (int i = 5; i < 6; i++) {
//			 AppRiddletype riddletype = pageSelect.get(i);
//			 System.out.println(riddletype.getId());
//			 String res = new ShowApiRequest("https://route.showapi.com/151-4", "4786", "c6852f2dfc4d45d5ae183632733f16c4")
//					 .addTextPara("typeId", riddletype.getId())
//					 .addTextPara("page", ig)
////					 .addTextPara("limit", "40")
//					 .post();
//			 JSONObject obj = JSONObject.fromObject(res);
//			 String showapi_res_body = obj.getString("showapi_res_body");
//			 System.out.println(showapi_res_body);
//			 obj = JSONObject.fromObject(showapi_res_body);
//			 obj = obj.getJSONObject("pagebean");
//			 JSONArray array = obj.getJSONArray("contentlist");
//			 System.out.println(array.size());
//			 if(array.size()>0){
//				 for (int j = 0;j<array.size(); j++) {
//					 AppRiddleitem bean = (AppRiddleitem) JSONObject.toBean((JSONObject) array.get(j), AppRiddleitem.class);
////				 System.out.println(bean.getAnswer());
//					 rsd.saveAppRiddleitem(bean);
//				 }
//			 }
//		 }
//		 
//	 }


}
