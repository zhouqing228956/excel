package com.zhou.excel.service;

import com.zhou.excel.entity.Excel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 表显示逻辑
 *
 * @Author:zhou
 * @Create:2018/10/14 13:50
 */
@Service
 public interface ShowExcelService{
    /**
     * @Description //TODO
     * @Param []
     * @return java.util.List<com.zhou.excel.entity.Excel>
     * 显示excel表数据
     */
    List<Excel> getList();
    /**
     * @Description //TODO
     * @Param [riQi]
     * @return com.zhou.excel.entity.Excel
     * 根据日期搜索
     */
    List<Excel> getByRiQi(String riQi);







} 
