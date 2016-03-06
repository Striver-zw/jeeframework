package org.zw.singleton.jeeframework.modules.basis.page;

import java.util.List;
/**
 * 
  * @类名:PageModel
  * @类描述: mybatis + mysq 进行分页
  * 		select * from admain_user where 1=1 limit ?, ?
  * 		第一个？ 是从多少条开始
  * 		第二个？ 多少条记录
  * @作者:张威
  * @创建时间:2015年9月8日-下午12:57:20
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright (c)-2015
 */
public class PageModel<T> {
	private int currentPage;// 当前页
	private int currentPage2;// 当前页
	private int pageSize;// 每页显示条数
	private int totalPage;// 总页数
	private int totalRecord;// 总记录数
	private List<T> dataList;// 分页数据
	private String fiflter;//排序
	private String kewors;//查找关键字
	
	

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public String getKewors() {
		return kewors;
	}

	public void setKewors(String kewors) {
		this.kewors = kewors;
	}

	public String getFiflter() {
		return fiflter;
	}

	public void setFiflter(String fiflter) {
		this.fiflter = fiflter;
	}

	private PageModel() {
	}

	public int getCurrentPage2() {
		return currentPage2;
	}



	public void setCurrentPage2(int currentPage2) {
		this.currentPage2 = currentPage2;
	}



	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	/*
	 * 初始化PageModel实例
	 */
	private PageModel(final int pageSize, final int currentPage1, final int totalRecord) {
		// 初始化每页显示条数
		this.pageSize = pageSize;
		// 设置总记录数
		this.totalRecord = totalRecord;
		// 初始化总页数
		setTotalPage();
		// 初始化当前页
		setCurrentPage(currentPage1);

	}

	/*
	 * 外界获得PageModel实例
	 */
	public static PageModel newPageModel(int currentPage1, int totalRecord) {

		return new PageModel(5, currentPage1, totalRecord);
	}

	/** 设置当前请求页
	 * 传人的是字符
	 * @方法说明:
	 * @方法名称:setCurrentPage
	 * @param page
	 * @作者:张威
	 * @返回值:	void
	 */
	private void setCurrentPage(int currentPage1) {
		currentPage=currentPage1;
//		try {
//			currentPage = Integer.parseInt(page);
//
//		} catch (java.lang.NumberFormatException e) {
//			// 这里异常不做处理，当前页默认为1
//			currentPage = 1;
//		}
		// 如果当前页小于第一页时，当前页指定到首页
		if (currentPage < 1) {
			currentPage = 1;
		}

		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

	}

	/**
	 * 
	 * @方法说明:
	 * @方法名称:setTotalPage
	 * @作者:张威
	 * @返回值:	void
	 */
	private void setTotalPage() {
		if (totalRecord % pageSize == 0) {
			totalPage = totalRecord / pageSize;
		} else {
			totalPage = totalRecord / pageSize + 1;
		}
	}

	/*
	 * 获得当前页
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/*
	 * 获得总页数
	 */
	public int getTotalPage() {
		return totalPage;

	}

	/*
	 * 获得开始行数
	 */
	public int getStartRow() {
		return (currentPage - 1) * pageSize;
	}

	/*
	 * 获得结束行
	 */
	public int getEndRow() {
		return pageSize;
		// 当前页* 每页的大小
		// return currentPage * pageSize;
	}

	/*
	 * 获得翻页数据
	 */
	public List<T> getDataList() {
		return dataList;
	}

	/*
	 * 设置翻页数据
	 */
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	// 首页
	public int getFirst() {
		return currentPage = 1;
	}
	
	// 上一页
	public int getPrevious() {
		return currentPage - 1;
	}
	// // 下一页
	public int getNext() {
		return currentPage + 1;
	}
	
	// // 尾页
	public int getLast() {
		return totalPage;
	}
}
