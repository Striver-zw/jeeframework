/**
 * 菜单插件 2016年2月16日20:28:02 
 * 开发者 ：singleton_zw，只提供三级菜单 可扩展的
 */
$(document).ready(function(){
//	console.log("000");
	$.ajax({
		type: "POST",
        url: "/jeeframework/sysMenu/sysMenuList.do",
        cache:false,
        contentType : "application/x-www-form-urlencoded; charset=utf-8",  
        success: function(data){
        	if(data.sysList!=null){
        		var m1s;
        		var m1f = 0;
        		var m2f = 0;
        		//判断是否为数组
//        		console.log($.isArray(list));
        		for(var i in data.sysList){//一级菜单
        			if("0"==data.sysList[i].parentId){
        				var m1= data.sysList[i];
//        				console.log(m1.name);
        				m1s ="<li class=''>" +
        					"<a href='"+m1.href+"' class='dropdown-toggle'>" +
        					"<i class='menu-icon fa "+m1.icon+"'></i>" +
        					"<span class='menu-text'>"+m1.name+" </span>" +
        					"<b class='arrow fa fa-angle-down'></b>" +
        					"</a>";
//        				delete data.sysList[i];
        				data.sysList.splice(i,1);
//        				console.log("一级"+data.sysList.length)
        				for(var j in data.sysList){//二级菜单
        					if(m1.id==data.sysList[j].parentId){
        						if(m1f==0){
        							m1s = m1s +"<b class='arrow'></b><ul class='submenu'>";
        							m1f =1;
        						}
        						var m2= data.sysList[j];
//                				console.log("　"+m2.name);
        						m1s =m1s+"<li class=''>" +
        								"<a href='"+m2.href+"' class='dropdown-toggle'>" +
        								"<i class='menu-icon fa "+m2.icon+"'></i>" +
        								m2.name;
        						data.sysList.splice(j,1);
//        						console.log("二级"+data.sysList.length)
        						for(var k in data.sysList){//三级菜单
                					if(m2.id==data.sysList[k].parentId){
                						//第一次加入
                						if(m2f==0){
                							m1s = m1s+"<b class='arrow fa fa-angle-down'></b>" +//有下级菜单
                									"</a><b class='arrow'></b><ul class='submenu'>";
                							m2f =1;
                						}
                						var m3= data.sysList[k];
//                        				console.log("　　"+m3.name);
                						m1s =m1s+"<li class=''>" +
        								"<a href='"+m3.href+"'>" +
        								"<i class='menu-icon fa "+m3.icon+"'></i>" +
        								m3.name+
        								"</a><b class='arrow'></b>";
//                						data.sysList.splice(k,1);
//                						console.log("三级"+data.sysList.length)
                					}
                				}//三级菜单结束
        						m2f =0;
        					}
        				}//二级菜单结束
        				m1f =0;
        				//每一级 都要加入</li></ul>这对标签
        				m1s =m1s+"</li></ul></li></ul></li>";
//        				console.log("　　"+m1s);
        				$(".nav-list").append(m1s);
        			}
        		}//一级菜单结束
        		
//        		for(var i =0 ;i < data.sysList.length;i++){
//        			console.log(i);
//        			
//        		}
        	}
        }
	});
})
//$(document).ready(function(){
//	console.log("000");
//	$.ajax({
//		type: "POST",
//		url: "SysMenu/sysMenuList.do",
//		cache:false,
//		contentType : "application/x-www-form-urlencoded; charset=utf-8",  
//		success: function(data){
////        	console.log(data)
//			if(data.sysList!=null){
////        		$.each(data.sysList,function(i,sysMenu){
////        			console.log(sysMenu.name);
////        		});
//				for(var i in data.sysList){
//					if("0"==data.sysList[i].parentId){
//						//一级菜单
//						var m1= data.sysList[i];
//						console.log(m1.name);
//						for(var j in data.sysList){
//							if(m1.id==data.sysList[j].parentId){
//								//二级菜单
//								var m2= data.sysList[j];
//								console.log("　"+m2.name);
//								for(var k in data.sysList){
//									if(m2.id==data.sysList[k].parentId){
//										//三级菜单
//										var m3= data.sysList[k];
//										console.log("　　"+m3.name);
//									}
//								}
//							}
//						}
//					}
//					
//				}
//				console.log(data.sysList.length)
////        		for(var i =0 ;i < data.sysList.length;i++){
////        			console.log(i);
////        			
////        		}
//			}
//		}
//	});
//})
//
//var hh ="<li><a href='#' class='dropdown-toggle'><i class='icon-desktop'></i>" +
//        				"<span class='menu-text'> UI 组件 </span><b class='arrow icon-angle-down'></b>" +
//        				"</a><ul class='submenu'><li><a href='nestable-list.html'>" +
//        				"<i class='icon-double-angle-right'></i>" +
//        				"可拖拽列表" +
//        				"</a></li><li><a href='#' class='dropdown-toggle'>" +
//        				"<i class='icon-double-angle-right'></i>" +
//        				"三级菜单" +
//        				"<b class='arrow icon-angle-down'></b>" +
//        				"</a><ul class='submenu'><li>" +
//        				"<a href='#'><i class='icon-leaf'></i>" +
//        				"第一级" +
//        				"</a></li><li>" +
//        				"<a href='#' class='dropdown-toggle'>" +
//        				"<i class='icon-pencil'></i>" +
//        				"第四级" +
//        				"<b class='arrow icon-angle-down'></b>" +
//        				"</a><ul class='submenu'><li>" +
//        				"<a href='#'><i class='icon-plus'></i>" +
//        				"添加产品" +
//        				"</a></li><li><a href='#'>" +
//        				"<i class='icon-eye-open'></i>" +
//        				"查看商品" +
//        				"</a></li></ul></li></ul>" +
//        				"</li></ul></li>"