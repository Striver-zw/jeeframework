package org.zw.singleton.jeeframework.modules.basis.page;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
//import org.apache.struts2.json.annotations.JSON;

public class PageBean {
	/** 当前第几页 */
	private Integer page=1;
	/** 每页大小 */
	private Integer pagesize=10;
	private Integer rp;
	/** 排序的列名 */
	private String sortname;
	/** 升序或者降序; desc;asc */
	private String sortorder;
	/** 附件的查询条件 */
	private List<?> addparams;
	/** 总数多少 */
	private Integer total;
	/** 查询出来的数据 */
	private List<?> rows;
	
	private String query;
	private String qtype;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String toString() {
		// MULTI_LINE_STYLE
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE, true, true);
	}

	/**
	 * @return 返回给页面需要用的
	 */
//	@JSON(name="page")
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page
	 *            返回给页面需要用的
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return 每页大小
	 */
//	@JSON(name="rp")
	public Integer getPagesize() {
		return pagesize;
	}
	
	public Integer getRp() {
		return rp;
	}

	public void setRp(Integer rp) {
		this.pagesize = rp;
		this.rp = rp;
	}

	/**
	 * @param pagesize
	 *            每页大小
	 */
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	/**
	 * @return 排序的列名
	 */
	public String getSortname() {
		return sortname;
	}

	/**
	 * @param sortname
	 *            排序的列名
	 */
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	/**
	 * @return 升序或者降序; desc;asc
	 */
	public String getSortorder() {
		return sortorder;
	}

	/**
	 * @param sortorder
	 *            升序或者降序; desc;asc
	 */
	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	/**
	 * @return 附件的查询条件
	 */
	public List<?> getAddparams() {
		return addparams;
	}

	/**
	 * @param addparams
	 *            附件的查询条件
	 */
	public void setAddparams(List<?> addparams) {
		this.addparams = addparams;
	}

	/**
	 * @return 总数多少
	 */
//	@JSON(name="total")
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            总数多少
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return 查询出来的数据
	 */
//	@JSON(name="rows")
	public List<?> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            查询出来的数据
	 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	

	/**
	 * 计算总页数
	 * @param totals
	 * @param pageSize
	 * @return
	 */
	public Integer getTotalPages(Integer totals,Integer pageSize){
		if(totals<0 || totals<pageSize){
			return 1;
		}else{
			return totals%pageSize == 0 ? totals/pageSize : (totals/pageSize+1);
		}
	}
}
