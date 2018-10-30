package com.zhou.excel.service;

import com.zhou.excel.entity.Excel;
import com.zhou.excel.mapper.ExcelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * excel显示实现类
 *
 * @Author:zhou
 * @Create:2018/10/14 13:53
 */
@Service
public class ShowExcelServiceImpl implements ShowExcelService{
    //日志
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ExcelMapper excelMapper;
    @Override
    public List<Excel> getList() {
        return excelMapper.queryAll(0,1000);
    }

    @Override
    public List<Excel> getByRiQi(String riqi) {
        return excelMapper.getRiQi(riqi);
    }
}
