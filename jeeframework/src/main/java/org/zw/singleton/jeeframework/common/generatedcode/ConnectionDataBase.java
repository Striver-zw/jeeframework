package org.zw.singleton.jeeframework.common.generatedcode;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zw.singleton.jeeframework.common.utils.sysconfig.ConfigUtils;
import org.zw.singleton.jeeframework.modules.gen.entity.SqlInfo;
 
/**
 * http://my.oschina.net/Thinkeryjgfn/blog/169384
  * @类名:
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月21日-下午3:30:29
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class ConnectionDataBase {
     
    /**
     * 这里是Oracle连接方法
     *private static final String driver = "oracle.jdbc.driver.OracleDriver";
     *private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
     *private static final String uid = "system";
     *private static final String pwd = "sys";
     *这里是SQL Server连接方法
     *private static final String url = "jdbc:sqlserver://localhost:1433;DateBaseName=数据库名";
     *private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
     *private static final String uid = "sa";
     *private static final String pwd = "sa";
     *
     *
     * 这里是MySQL连接方法
     */
//    private static final String driver="com.mysql.jdbc.Driver";
//    private static final String pwd="root";
//    private static final String user="root";
//    private static final String url = "jdbc:mysql://localhost/jeeframework"
//            + "?user=" + user + "&password=" + pwd
//            + "&useUnicode=true&characterEncoding=UTF-8";
//    
    private static Connection getConnection=null;
 
    /**
     * 获取表的信息
     * @方法说明:
     * @方法名称:getTableInfo
     * @return
     * @作者:zw
     * @返回值:List<Map<String,Object>>
     */
    public static List<Map<String, Object>> getTableInfo() {
//        FileSystemView fsv=FileSystemView.getFileSystemView();
//        String path=fsv.getHomeDirectory().toString();//获取当前用户桌面路径
        getConnection=getConnections();
        List<Map<String, Object>> val2 = new ArrayList<Map<String, Object>>();
        try {
            DatabaseMetaData dbmd=getConnection.getMetaData();
            ResultSet resultSet = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });
            while (resultSet.next()) {
                String tableName=resultSet.getString("TABLE_NAME");
                    //ResultSet rs =getConnection.getMetaData().getColumns(null, getXMLConfig.getSchema(),tableName.toUpperCase(), "%");//其他数据库不需要这个方法的，直接传null，这个是oracle和db2这么用
                    ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
//                    System.out.println("表名："+tableName+"\t\n表字段信息：");
                    List<Map<String, Object>> val = new ArrayList<Map<String, Object>>();
                    Map<String,Object> maptab = new HashMap<String,Object>();
                	maptab.put("table", tableName);
                    while(rs.next()){
//                        System.out.println("字段名："+rs.getString("COLUMN_NAME")+"\t 字段注释："+rs.getString("REMARKS")+"\t字段数据类型："+rs.getString("TYPE_NAME"));
                        Map<String,Object> map = new HashMap<String,Object>();
                        map.put("Column", rs.getString("TYPE_NAME"));
    					map.put("CoulumnName", rs.getString("COLUMN_NAME"));
    					map.put("RemaRks", rs.getString("REMARKS"));
    					val.add(map);
                    }
                    
                    maptab.put("ColumnList", val);
    				val2.add(maptab);
//                System.out.println("-------------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val2;
    }
    
    /**
     * 对象封装
     * @MethodsDescription:
     * @MethodName:getTableInfos
     * @return
     * @Author:singleton-zw
     * @Return:List<SqlInfo>
     */
    public static List<SqlInfo> getTableInfos() {
    	List<SqlInfo> lists = null;
		try {
			getConnection=getConnections();
			DatabaseMetaData dbmd=getConnection.getMetaData();
			ResultSet resultSet = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });
			lists = new ArrayList<SqlInfo>();
			while (resultSet.next()) {
			    String tableName=resultSet.getString("TABLE_NAME");
			        ResultSet rs = dbmd.getColumns(null, "%", tableName, "%");
			        SqlInfo s = new SqlInfo();
					s.setTableName(tableName);
					List<SqlInfo.Info> listsi = new ArrayList<SqlInfo.Info>();
			        while(rs.next()){
			            SqlInfo.Info ii = new SqlInfo.Info();
			            ii.setColumnType(rs.getString("TYPE_NAME"));
						ii.setCoulumnName(rs.getString("COLUMN_NAME"));
						ii.setRemaRks(rs.getString("REMARKS"));
						listsi.add(ii);
			        }
			        s.setListInfo(listsi);
					lists.add(s);
			}
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
    }
    
    /**
     * 链接数据库
     * @方法说明:
     * @方法名称:getConnections
     * @return
     * @作者:zw
     * @返回值:Connection
     */
    public static Connection getConnections(){
    	
    	String[] dbParameter = ConfigUtils.getDBParameter();
        try {
            //Properties props =new Properties();
            //props.put("remarksReporting","true");
            Class.forName(dbParameter[3]);
            getConnection=DriverManager.getConnection(dbParameter[4],dbParameter[1],dbParameter[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getConnection;
    }
    ////其他数据库不需要这个方法 oracle和db2需要
     public static String getSchema() throws Exception {
            String schema;
            schema =getConnection.getMetaData().getUserName();
            
            if ((schema == null) || (schema.length() == 0)) {
                throw new Exception("ORACLE数据库模式不允许为空");
            }
            return schema.toUpperCase().toString();
 
    }
 	/**
 	 * 数据库里面
 	 * 这里是获取了一个字段类型的int型，需要转化成string的话要做一个swtich，就不转了，你自己看java.sql.Types这个类去
 	 * the table is: admain_user
 	 * TABLE_CAT: 1	TABLE_SCHEM: 1	TABLE_NAME: 1	COLUMN_NAME: 1	DATA_TYPE: 4	TYPE_NAME: 1	COLUMN_SIZE: 4	BUFFER_LENGTH: 4	DECIMAL_DIGITS: 4	NUM_PREC_RADIX: 4	NULLABLE: 4	REMARKS: 1	COLUMN_DEF: 1	SQL_DATA_TYPE: 4	SQL_DATETIME_SUB: 4	CHAR_OCTET_LENGTH: 4	ORDINAL_POSITION: 4	IS_NULLABLE: 1	SCOPE_CATALOG: 1	SCOPE_SCHEMA: 1	SCOPE_TABLE: 1	SOURCE_DATA_TYPE: 5	IS_AUTOINCREMENT: 1
 	 * the table is: user
 	 * TABLE_CAT: 1	TABLE_SCHEM: 1	TABLE_NAME: 1	COLUMN_NAME: 1	DATA_TYPE: 4	TYPE_NAME: 1	COLUMN_SIZE: 4	BUFFER_LENGTH: 4	DECIMAL_DIGITS: 4	NUM_PREC_RADIX: 4	NULLABLE: 4	REMARKS: 1	COLUMN_DEF: 1	SQL_DATA_TYPE: 4	SQL_DATETIME_SUB: 4	CHAR_OCTET_LENGTH: 4	ORDINAL_POSITION: 4	IS_NULLABLE: 1	SCOPE_CATALOG: 1	SCOPE_SCHEMA: 1	SCOPE_TABLE: 1	SOURCE_DATA_TYPE: 5	IS_AUTOINCREMENT: 1
 	 */
}
 