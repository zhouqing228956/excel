package mapper;

import com.zhou.excel.entity.Excel;
import com.zhou.excel.mapper.ExcelMapper;
import com.zhou.excel.service.ShowExcelService;
import common.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 接口测试
 *
 * @Author:zhou
 * @Create:2018/10/13 14:18
 */
public class ExcelTest extends BaseTest{
    @Autowired
    private ExcelMapper excelMapper;
    @Autowired
    private ShowExcelService showExcelService;
    @Test
    public  void testQueryByRiqi(){
        String riqi="2019-09-04";
        List<Excel> excel=showExcelService.getByRiQi(riqi);
        System.out.println(excel);
        System.out.println(excel.size());

    }
    @Test
    public void testQueryAll(){
        List<Excel> excels=excelMapper.queryAll(0,3);
        for (Excel exc:excels) {
            System.out.println(exc);
        }
        System.out.println(excels.size());

    }
    @Test
    public void queryAllWithoutParam(){
        List<Excel> excelList = excelMapper.queryAllWithoutParam();
        for (Excel zExcel:excelList) {
            System.out.println(zExcel);

        }
    }
    @Test
    public void test(){
        String s="盖伦,在进行了连续8次击杀后,获得了 超神 的称号";
        String subSentences[] = s.split(",");

        int []a=new int[]{3,2,1,5,6,5};
        System.out.println(a.length);


        }
    }


