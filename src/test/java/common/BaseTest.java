package common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 加载配置文件的基础类
 *
 * @Author:zhou
 * @Create:2018/10/13 14:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class BaseTest{
    /**
     * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
     */
} 
