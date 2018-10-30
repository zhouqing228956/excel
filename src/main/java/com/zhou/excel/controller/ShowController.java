package com.zhou.excel.controller;

import com.zhou.excel.entity.Excel;
import com.zhou.excel.service.ShowExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;

/**
 * 显示数据
 *
 * @Author:zhou
 * @Create:2018/10/14 13:45
 */
@Controller
@RequestMapping("")
public class ShowController{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShowExcelService showExcelService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    private String showList(Model model){
        List<Excel> list=showExcelService.getList();
        model.addAttribute("list",list);
        return "show";
    }
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    private String select(String riqi,Model model){
        List<Excel> byRiQi = showExcelService.getByRiQi(riqi);
        model.addAttribute("byRiQi",byRiQi);
        return "showByRiQi";
    }
    @PostMapping(value = "hello")
    @ResponseBody
    public List<Excel> hello(){
      List<Excel> excels=showExcelService.getList();
        return excels;
    }
} 
