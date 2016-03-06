package org.zw.singleton.jeeframework.modules.basis.page;

import java.util.List;

/**
 * 分页对应的实体类
  * @类名:Page
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月13日-下午8:17:41
  * @修改人:
  * @修改时间:2015年12月14日 16:25:29
  * @修改备注: 增加构造方法
  * @版本:
  * @Copyright (c)-2015
 */
public class Page<T> {
	/**
	 * 总条数
	 */
	private int totalNumber;
	/**
	 * 当前第几页
	 */
	private int currentPage;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 每页显示条数
	 */
	private int pageNumber;
//	private int pageNumber = 5;
	/**
	 * 数据库中limit的参数，从第几条开始取
	 */
	private int dbIndex;
	/**
	 * 数据库中limit的参数，一共取多少条
	 */
	private int dbNumber;
	/**
	 * 数据集合
	 */
	private List<T> dataList;
	/**
	 * 数据类型
	 */
	private Object entity;
	
	/**
	 * @构造函数
	 * @说明:无
	 * @param entity 查询条件
	 * @param currentPage 页数
	 * @param pageNumber 页数大小
	 * @作者:zw
	 */
	public Page(Object entity,int currentPage, int pageNumber) {
		this.entity = entity;
		this.currentPage = currentPage;
		this.pageNumber = pageNumber;
	}
	/**
	 * @构造函数
	 * @说明:无
	 * @param entity 查询条件
	 * @param currentPage 页数
	 * @作者:zw
	 */
	public Page(Object entity,int currentPage) {
		this.entity = entity;
		this.currentPage = currentPage;
	}
	
	/**
	 * @构造函数
	 * @说明:无
	 * @param currentPage 页数
	 * @作者:zw
	 */
	public Page(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public Page() {
		super();
	}

	/**
	 * 根据当前对象中属性值计算并设置相关属性值
	 */
	public void count() {
		// 计算总页数
		int totalPageTemp = this.totalNumber / this.pageNumber;
		int plus = (this.totalNumber % this.pageNumber) == 0 ? 0 : 1;
		totalPageTemp = totalPageTemp + plus;
		if(totalPageTemp <= 0) {
			totalPageTemp = 1;
		}
		this.totalPage = totalPageTemp;
		
		// 设置当前页数
		// 总页数小于当前页数，应将当前页数设置为总页数
		if(this.totalPage < this.currentPage) {
			this.currentPage = this.totalPage;
		}
		// 当前页数小于1设置为1
		if(this.currentPage < 1) {
			this.currentPage = 1;
		}
		
		// 设置limit的参数
		this.dbIndex = (this.currentPage - 1) * this.pageNumber;
		this.dbNumber = this.pageNumber;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}


	public List<T> getDataList() {
		return dataList;
	}

	public Object getEntity() {
		return entity;
	}


	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		this.count();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
		this.count();
	}

	public int getDbIndex() {
		return dbIndex;
	}

	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}

	public int getDbNumber() {
		return dbNumber;
	}

	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}
}
