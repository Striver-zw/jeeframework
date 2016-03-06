package org.zw.singleton.jeeframework.modules.gen.entity;

import java.io.Serializable;
import java.util.List;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**
 * 
  * @ClassName:SqlInfo
  * @Description:
  * @Author:singleton-zw
  * @CreateDate:2016年2月16日-下午10:53:27
  * @UpdateAuthor:
  * @UpdateDate:
  * @UpdateDesc:
  * @version: v1.0
  * @Copyright (c)-2016
 */
public class SqlInfo extends BaseEntity<SqlInfo> {

	private String tableName;
	private int status;//是否已经生成
	private List<Info> listInfo;
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<Info> getListInfo() {
		return listInfo;
	}

	public void setListInfo(List<Info> listInfo) {
		this.listInfo = listInfo;
	}



	@Override
	public String toString() {
		return "SqlInfo [tableName=" + tableName + ", listInfo=" + listInfo + "]";
	}



	public static class Info implements Serializable{
		private String columnType;
		private String coulumnName;
		private String remaRks;
		
		
		public String getColumnType() {
			return columnType;
		}
		public void setColumnType(String columnType) {
			this.columnType = columnType;
		}
		public String getCoulumnName() {
			return coulumnName;
		}
		public void setCoulumnName(String coulumnName) {
			this.coulumnName = coulumnName;
		}
		public String getRemaRks() {
			return remaRks;
		}
		public void setRemaRks(String remaRks) {
			this.remaRks = remaRks;
		}
		@Override
		public String toString() {
			return "Info [columnType=" + columnType + ", coulumnName=" + coulumnName + ", remaRks=" + remaRks + "]";
		}
		
		
	}
}
