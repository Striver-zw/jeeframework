package org.zw.singleton.jeeframework.common.annotations;

import java.util.List;

/**
 * http://blog.csdn.net/bao19901210/article/details/17201173
  * @类名:Tr
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月25日-下午4:29:31
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class Test {

    @SuppressWarnings({ "unchecked", "rawtypes" })  
    public static void main(String[] args) {  
        Parent c = new Child();  
        List<SortableField> list = c.init();//获取泛型中类里面的注解  
        //输出结果  
        for(SortableField l : list){  
            System.out.println("字段名称："+l.getName()+"\t字段类型："+l.getType()+  
                    "\t注解名称："+l.getMeta().name()+"\t注解描述："+l.getMeta().description());  
        }  
    }  
}
