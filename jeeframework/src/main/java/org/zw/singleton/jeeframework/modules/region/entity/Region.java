/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-17 20:02:20
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.region.entity;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @类名:Region
  * @类描述:区域
  * @作者: singleton_zw
  * @创建时间: 2016-01-17 20:02:20
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
public class Region extends BaseEntity<Region> {

	private Double regionId;	// 
	private String regionCode;	// 
	private String regionName;	//区域名字 
	private Double parentId;	//父类id 
	private Double regionLevel;	// 
	private Double regionOrder;	// 
	private String regionNameEn;	//区域汉字拼音 
	private String regionShortnameEn;	//简写 

	public Double getRegionId() {
		 return regionId;
	}
	public void setRegionId(Double regionId) {
		 this.regionId = regionId;
	}
	public String getRegionCode() {
		 return regionCode;
	}
	public void setRegionCode(String regionCode) {
		 this.regionCode = regionCode;
	}
	public String getRegionName() {
		 return regionName;
	}
	public void setRegionName(String regionName) {
		 this.regionName = regionName;
	}
	public Double getParentId() {
		 return parentId;
	}
	public void setParentId(Double parentId) {
		 this.parentId = parentId;
	}
	public Double getRegionLevel() {
		 return regionLevel;
	}
	public void setRegionLevel(Double regionLevel) {
		 this.regionLevel = regionLevel;
	}
	public Double getRegionOrder() {
		 return regionOrder;
	}
	public void setRegionOrder(Double regionOrder) {
		 this.regionOrder = regionOrder;
	}
	public String getRegionNameEn() {
		 return regionNameEn;
	}
	public void setRegionNameEn(String regionNameEn) {
		 this.regionNameEn = regionNameEn;
	}
	public String getRegionShortnameEn() {
		 return regionShortnameEn;
	}
	public void setRegionShortnameEn(String regionShortnameEn) {
		 this.regionShortnameEn = regionShortnameEn;
	}
	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionCode=" + regionCode + ", regionName=" + regionName
				+ ", parentId=" + parentId + ", regionLevel=" + regionLevel + ", regionOrder=" + regionOrder
				+ ", regionNameEn=" + regionNameEn + ", regionShortnameEn=" + regionShortnameEn + "]";
	}
}