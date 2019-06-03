package com.steins.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * 配置spring和junit整合，junit启动时加载springIOC容器
 *加依赖spring-test
 */

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-mybatis.xml","classpath:spring/spring-servlet.xml"})
public class BaseTest {

}
