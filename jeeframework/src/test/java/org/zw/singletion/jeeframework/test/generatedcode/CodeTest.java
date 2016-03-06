package org.zw.singletion.jeeframework.test.generatedcode;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.zw.singletion.jeeframework.test.BaseTest;
import org.zw.singleton.jeeframework.common.generatedcode.ConnectionDataBase;
import org.zw.singleton.jeeframework.modules.gen.entity.SqlInfo;
import org.zw.singleton.jeeframework.modules.gen.entity.SqlInfo.Info;

import com.alibaba.druid.util.jdbc.ConnectionBase;

public class CodeTest extends BaseTest {

	@Test
	public void test(){
		List<Map<String, Object>> ma = ConnectionDataBase.getTableInfo();
		List<SqlInfo> lists = new ArrayList<SqlInfo>();
		
		for (int i = 0; i < ma.size(); i++) {
			Map<String, Object> map = ma.get(i);
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("ColumnList");
			SqlInfo s = new SqlInfo();
			s.setTableName((String)map.get("table"));
			List<SqlInfo.Info> listsi = new ArrayList<SqlInfo.Info>();
			for (int j = 0; j < list.size(); j++) {
				SqlInfo.Info ii = new SqlInfo.Info();
				Map<String, Object> map2 = list.get(j);
				ii.setColumnType((String)map2.get("Column"));
				ii.setCoulumnName((String)map2.get("CoulumnName"));
				ii.setRemaRks((String)map2.get("RemaRks"));
				listsi.add(ii);
			}
			s.setListInfo(listsi);
			lists.add(s);
		}
		
		
		for (int i = 0; i < lists.size(); i++) {
			SqlInfo sqlInfo = lists.get(i);
			System.err.println(sqlInfo.getTableName() );
			for (int j = 0; j < sqlInfo.getListInfo().size(); j++) {
				Info info = sqlInfo.getListInfo().get(j);
				System.err.println(info);
			}
		}
	}
	
	
	@Test
	public void tests(){
		List<SqlInfo> lists = new ArrayList<SqlInfo>() ;
//		try {
//			Connection connection = ConnectionDataBase.getConnections();
//			DatabaseMetaData dbmd=connection.getMetaData();
//			ResultSet resultSet = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });
//			lists = new ArrayList<SqlInfo>();
//			while (resultSet.next()) {
//			    String tableName=resultSet.getString("TABLE_NAME");
//			        ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
//			        SqlInfo s = new SqlInfo();
//					s.setTableName(tableName);
//					List<SqlInfo.Info> listsi = new ArrayList<SqlInfo.Info>();
//			        while(rs.next()){
//			            SqlInfo.Info ii = new SqlInfo.Info();
//			            ii.setColumnType(rs.getString("TYPE_NAME"));
//						ii.setCoulumnName(rs.getString("COLUMN_NAME"));
//						ii.setRemaRks(rs.getString("REMARKS"));
//						listsi.add(ii);
//			        }
//			        s.setListInfo(listsi);
//					lists.add(s);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		lists = ConnectionDataBase.getTableInfos();
		for (int i = 0; i < lists.size(); i++) {
			SqlInfo sqlInfo = lists.get(i);
			System.err.println(sqlInfo.getTableName() );
			for (int j = 0; j < sqlInfo.getListInfo().size(); j++) {
				Info info = sqlInfo.getListInfo().get(j);
				System.err.println(info);
			}
		}
	}
}
