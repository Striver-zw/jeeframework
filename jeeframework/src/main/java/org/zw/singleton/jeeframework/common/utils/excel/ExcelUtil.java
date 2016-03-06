package org.zw.singleton.jeeframework.common.utils.excel;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * excle 数据导出 
 * 参考api http://poi.apache.org/apidocs/org/apache/poi/xssf/streaming/SXSSFWorkbook.html
  * @类名:ExcelUtil
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月30日-上午11:14:21
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class ExcelUtil {
	/**
     * 创建excel文档，
     * @param list 数据
     * @param keys list中map的key数组集合
     * @param columnNames excel的列名
     * */
    public static Workbook createWorkBook(List<Map<String, Object>> list,String []keys,String columnNames[]) {
        // 创建excel工作簿
//        Workbook wb = new HSSFWorkbook();
    	SXSSFWorkbook wb = new SXSSFWorkbook(100);
        // 创建第一个sheet（页），并命名
        Sheet sheet = wb.createSheet(list.get(0).get("sheetName").toString());
       // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        for(int i=0;i<keys.length;i++){
            sheet.setColumnWidth((short) i, (short) (35.7 * 150));
        }
        // 创建第一行
        Row row = sheet.createRow((short) 0);
        // 创建两种单元格格式
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();
        // 创建两种字体
        Font f = wb.createFont();
        Font f2 = wb.createFont();
        // 创建第一种字体样式（用于列名）
        f.setFontHeightInPoints((short) 10);
        f.setColor(IndexedColors.BLACK.getIndex());
        f.setBoldweight(Font.BOLDWEIGHT_BOLD);
        // 创建第二种字体样式（用于值）
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());
//      Font f3=wb.createFont();
//      f3.setFontHeightInPoints((short) 10);
//      f3.setColor(IndexedColors.RED.getIndex());
        // 设置第一种单元格的样式（用于列名）
        cs.setFont(f);
        cs.setBorderLeft(CellStyle.BORDER_THIN);
        cs.setBorderRight(CellStyle.BORDER_THIN);
        cs.setBorderTop(CellStyle.BORDER_THIN);
        cs.setBorderBottom(CellStyle.BORDER_THIN);
        cs.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置第二种单元格的样式（用于值）
        cs2.setFont(f2);
        cs2.setBorderLeft(CellStyle.BORDER_THIN);
        cs2.setBorderRight(CellStyle.BORDER_THIN);
        cs2.setBorderTop(CellStyle.BORDER_THIN);
        cs2.setBorderBottom(CellStyle.BORDER_THIN);
        cs2.setAlignment(CellStyle.ALIGN_CENTER);
        //设置列名
        for(int i=0;i<columnNames.length;i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
        }
        //设置每行每列的值
        for (short i = 1; i < list.size(); i++) {
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上
            Row row1 = sheet.createRow((short) i);
            // 在row行上创建一个方格
            for(short j=0;j<keys.length;j++){
                Cell cell = row1.createCell(j);
                cell.setCellValue(list.get(i).get(keys[j]) == null?" ": list.get(i).get(keys[j]).toString());
                cell.setCellStyle(cs2);
            }
        }
        return wb;
    }
    
    /**
     * 导出数据 只能到出1000行以内的数据
     * @方法说明:
     * @方法名称:saveExcel
     * @param fileName1
     * @param list1
     * @param response
     * @throws IOException
     * @作者:zw
     * @返回值:void
     */
//    public static void saveExcel(String fileName1,List<Object> list1,HttpServletResponse response) throws IOException{
//    	String fileName = "excel文件";
//		// 填充projects数据
//		List<SysUser> projects = createData();
//		List<Map<String, Object>> list = createExcelRecord(projects);
//		String columnNames[] = { "ID", "项目名", "销售人", "负责人", "所用技术", "备注" };// 列名
//		String keys[] = { "id", "name", "saler", "principal", "technology", "remarks" };// map中的key
//		ByteArrayOutputStream os = new ByteArrayOutputStream();
//		try {
//			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);// 使用工具类设置参数
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		byte[] content = os.toByteArray();
//		InputStream is = new ByteArrayInputStream(content);
//		// 设置response参数，可以打开下载页面
//		response.reset();
//		response.setContentType("application/vnd.ms-excel;charset=utf-8");
//		response.setHeader("Content-Disposition",
//				"attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
//		ServletOutputStream out = response.getOutputStream();
//		BufferedInputStream bis = null;
//		BufferedOutputStream bos = null;
//		try {
//			bis = new BufferedInputStream(is);
//			bos = new BufferedOutputStream(out);
//			byte[] buff = new byte[2048];
//			int bytesRead;
//			// Simple read/write loop.
//			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
//				bos.write(buff, 0, bytesRead);
//			}
//		} catch (final IOException e) {
//			throw e;
//		} finally {
//			if (bis != null)
//				bis.close();
//			if (bos != null)
//				bos.close();
//		}
//    }
//    
//
//	private static List<SysUser> createData() {
//		List<SysUser> list = new ArrayList<SysUser>();
//		for (int i = 0; i < 100000; i++) {
//			SysUser p = new SysUser();
//			p.setId(1+i);
//			p.setSysName("你麻痹"+i);
//			p.setSysFloat(null);
//			p.setSysDouble(1.0+i);
//			list.add(p);
//		}
//		// 自己实现
//		return list;
//	}
//
//	// 填充数据
//	private static List<Map<String, Object>> createExcelRecord(List<SysUser> projects) {
//		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("sheetName", "sheet1");
//		listmap.add(map);
//		SysUser project = null;
//		for (int j = 0; j < projects.size(); j++) {
//			project = projects.get(j);
//			Map<String, Object> mapValue = new HashMap<String, Object>();
//			mapValue.put("id", project.getId());
//			mapValue.put("name", project.getSysName());
//			mapValue.put("technology", project.getSysFloat());
//			mapValue.put("remarks", project.getSysDouble());
//			listmap.add(mapValue);
//		}
//		return listmap;
//	}
}
