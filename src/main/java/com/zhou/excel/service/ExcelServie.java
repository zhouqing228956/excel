package com.zhou.excel.service;



import com.zhou.excel.entity.Excel;
import com.zhou.excel.mapper.ExcelMapper;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * excel导入与导出的业务逻辑实现
 *
 * @Author:zhou
 * @Create:2018/10/13 18:41
 */
@Service
public class ExcelServie{
    @Autowired
    private ExcelMapper excelMapper;

    private final static String excel2003L=".xls";   //2003及之前的版本
    private final static String excel2007U=".xlsx";   //2007及之后的版本

    /**
     * @Description excel导出
     * @Param [titles, out]
     * @return void
     */
    public void export(String[] titles, ServletOutputStream out) throws Exception{
        try{
            //1、创建worhbook,相当于一个工作簿（excel文件）
            HSSFWorkbook workbook=new HSSFWorkbook();
            //2、在workbook中添加一个sheet,对应为excel中的shhet
            HSSFSheet hssfSheet=workbook.createSheet("excel的导入与导出");
            //3、在sheet中添加表头，注意老版本poi对excel的行数列数有限制short
            HSSFRow hssfRow=hssfSheet.createRow(0);
            //4、创建单元格，并设置表头居中
            HSSFCellStyle hssfCellStyle=workbook.createCellStyle();
            //居中
            hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            //单元格
            HSSFCell hssfCell=null;
            for (int i = 0; i <titles.length ; i++) {
                hssfCell=hssfRow.createCell(i);//列索引从0开始
                hssfCell.setCellValue(titles[i]);//列名1
                hssfCell.setCellStyle(hssfCellStyle); //列居中显示
            }
            //5、写入实体数据
            List<Excel> excel=excelMapper.queryAllWithoutParam();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            /**
             * 遍历封装的实体数据
             *
             * */
            if (excel !=null && !excel.isEmpty()){
                for (int i = 0; i <excel.size() ; i++) {
                    hssfRow=hssfSheet.createRow(i+1);
                   Excel excels=excel.get(i);

                   //6、创建单元格。并设置值
                    String point="";
                    if (excels.getPoint()!=null){
                        point=excels.getPoint();
                    }
                    hssfRow.createCell(0).setCellValue(point);
                    String riqi="";
                    if (excels.getRiqi()!=null){
                        riqi=excels.getRiqi();
                    }
                    hssfRow.createCell(1).setCellValue(riqi);

                    Double attu=0.000;
                    if (excels.getAttu() !=0.000){
                        attu=excels.getAttu();
                    }
                    hssfRow.createCell(2).setCellValue(attu);
                }
            }
            //7、将文件输出到客服端
            try{
                workbook.write(out);
                out.flush();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("导出消息失败");
        }
    }

    /**
     * @Description //TODO
     * @Param [inStr, fileName]
     * @return org.apache.poi.ss.usermodel.Workbook
     * 根据文件后缀，自适应上传文件的版本
     */
    public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception{
        Workbook wb = null;
        /*substring截取字符串（基0开始），lastIndexOf定位最后一次出现的字符（基0开始）*/
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if(excel2003L.equals(fileType)){
            wb = new HSSFWorkbook(inStr);  //2003-
        }else if(excel2007U.equals(fileType)){
            wb = new XSSFWorkbook(inStr);  //2007+
        }else{
            throw new Exception("解析的文件格式有误！");
        }
        return wb;

    }
    /**
     * @Description //TODO
     * @Param [cell]
     * @return java.lang.Object
     * 对表格中数值进行格式化
     */
    public  Object getCellValue(Cell cell){
        Object value = null;
        DecimalFormat df = new DecimalFormat("0.000");  //格式化number String字符
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化
        DecimalFormat df2 = new DecimalFormat("0.000");  //格式化数字

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if("General".equals(cell.getCellStyle().getDataFormatString())){
                    value = df.format(cell.getNumericCellValue());
                }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
                    value = sdf.format(cell.getDateCellValue());
                }else{
                    value = df2.format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            default:
                break;
        }
        return value;
    }
    /**
     * @Description
     * @Param [in, fileName]
     * @return java.util.List<java.util.List<java.lang.Object>>
     * 获取IO流中的数据，组装成List<List<Object>>对象
     */
    public  List<List<Object>> getBankListByExcel(InputStream in, String fileName) throws Exception{
        List<List<Object>> list = null;
        System.out.println("getBankListByExcel");
        //创建Excel工作薄
        Workbook work = this.getWorkbook(in,fileName);
        if(null == work){
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        list = new ArrayList<List<Object>>();
        //遍历Excel中所有的sheet
        System.out.println("work.getNumberOfSheets()");
        System.out.println(work.getNumberOfSheets());
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if(sheet==null){continue;}
            //遍历当前sheet中的所有行
            for (int j = sheet.getFirstRowNum()+1; j < sheet.getLastRowNum()+1; j++) {
                row = sheet.getRow(j);
                System.out.println(" row = sheet.getRow(j);");
//                if(row==null||row.getFirstCellNum()==j){continue;}
                //遍历所有的列
                List<Object> li = new ArrayList<Object>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    System.out.println("cell.getStringCellValue()");
                    li.add(this.getCellValue(cell));
                }
                list.add(li);
            }
        }
        return list;
    }
} 
