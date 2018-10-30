package com.zhou.excel.controller;

import com.zhou.excel.entity.Excel;
import com.zhou.excel.mapper.ExcelMapper;
import com.zhou.excel.service.ExcelServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * excel的导入与导出
 *
 * @Author:zhou
 * @Create:2018/10/13 18:38
 */
@Controller
public class ExcelController{
    @Autowired
    private ExcelServie excelServie;
    @Autowired
    private ExcelMapper excelMapper;
    /*
    * response.setContentType("application/vnd.ms-excel;charset=UTF-8");
    * response.setHeader("Content-Disposition", "inline;  filename=" + fileName + ".xls");
    * xls格式中打不开excel时，加前二个
    * */

    @RequestMapping("export")
    @ResponseBody
    //  @ResponseBody返回的事字符串，而不是视图解析
    public String export(HttpServletResponse response) throws Exception{
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        try{
            ServletOutputStream out=response.getOutputStream();
            String fileName=new String(("Excel导入导出"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(),"UTF-8");
            response.setHeader("Content-Disposition", "inline;  filename=" + fileName + ".xls");
            String[] titles={" 点位", "日期", "高程"};
            excelServie.export(titles,out);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "导出失败";
        }
    }
    /**
     * @Description //TODO
     * @Param [request]
     * @return java.lang.String
     * 传统方式的表单提交上传excel文件
     */
    @RequestMapping(value = "/upload",method = {RequestMethod.GET,RequestMethod.POST})
    public String uploadExcel(HttpServletRequest request) throws Exception{

        MultipartHttpServletRequest multipartRequest= (MultipartHttpServletRequest) request;
        System.out.println("传统方式的表单提交上传excel文件");
        InputStream in=null;
        List<List<Object>> listob = null;
        MultipartFile file=multipartRequest.getFile("upFile");//注意：这里参数需要和前台上传的name一样
        if (file.isEmpty()){
            throw new Exception("文件不存在!");
        }
        in=file.getInputStream();
        listob =excelServie.getBankListByExcel(in,file.getOriginalFilename());
        in.close();
        System.out.println(listob.size());

        for (int i = 0; i <listob.size() ; i++) {
            List<Object> lo=listob.get(i);
            Excel ex=new Excel();
            ex.setPoint(String.valueOf(lo.get(0)));
            ex.setRiqi(String.valueOf(lo.get(1)));
            ex.setAttu(Double.valueOf((String) lo.get(2)));
            System.out.println("打印信息点位"+ex.getPoint()+"日期"+ex.getRiqi()+"高程"+ex.getAttu());
            excelMapper.insertExcel(ex);
        }
        return "redirect:/list";
    }

} 
