
package org.zw.singleton.jeeframework.common.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * http://www.cnblogs.com/peida/archive/2013/04/24/3036689.html
  * @类名:Dome
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月25日-下午3:51:51
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
//@Target(ElementType.TYPE)//TYPE:用于描述类、接口(包括注解类型) 或enum声明
@Retention(RetentionPolicy.RUNTIME)//在运行时有效（即运行时保留）
@Documented
public @interface Dome {

}
