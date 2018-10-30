package com.zhou.excel.mapper;

import com.zhou.excel.entity.Excel;
import org.apache.ibatis.annotations.Param;


import java.util.List;


public interface ExcelMapper{
    /**
     * @Description 通过日期查询所有符合的记录
     * @Param    riqi字段日期
     * @return   实体对象封装记录
     */
    List<Excel> getRiQi(String riqi);


    List<Excel> queryAllWithoutParam();

    /**
     * @Description //TODO
     * @Param [offset:查询起始位置, limit:查询条数]
     * @return java.util.List<com.zhou.excel.entity.Excel>
     */
    int insertExcel(Excel excel);


    List<Excel> queryAll(@Param("offset") int offset, @Param("limit") int limit);



}
