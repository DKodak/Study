package com.ht.test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @company 宏图
 * @User Kodak
 * @create 2019-03-20 -19:33
 */
public class TestMp {
    /**
     *
     * 代码生成器
     * */
    @Test
    public void testGenerator() {
    //1  全局配置
        GlobalConfig config = new GlobalConfig();
        //1.1是否支持AR模式
            config.setActiveRecord(true)
             //作者
                .setAuthor("kodak")
                //生成路径
                .setOutputDir("D:\\School\\springboot2.0\\mybiats_plus03\\src\\main\\java")
 //              文件覆盖
                .setFileOverride(true)
//                 设置生成的service接口名首字母是否为I
                .setServiceName("%sService")
//                  生成映射文件
                    .setBaseResultMap(true)
//                    生成sql片段
                    .setBaseColumnList(true)
                // 主键策略
                .setIdType(IdType.AUTO)
            ;

        //2  数据源配置
        DataSourceConfig dataSourceConfig=new DataSourceConfig();
//        2.1设置数据库类型
        dataSourceConfig.setDbType(DbType.MYSQL)
        .setDriverName("com.mysql.jdbc.Driver")
        .setUrl("jdbc:mysql://localhost:3306/kodak")
        .setUsername("root")
        .setPassword("123456");

        //3 策略配置
        StrategyConfig strategyConfig=new StrategyConfig();
//        开启全局大写命名
        strategyConfig.setCapitalMode(true)
//        指定表名字段名是否使用下划线
        .setDbColumnUnderline(true)
//         数据库表映射到实体的命名策略 也就是开启驼峰命名
        .setNaming(NamingStrategy.underline_to_camel)
//          设置数据库表名的前缀
        .setTablePrefix("tbl_")
//          生成的数据表需要自己创建
        .setInclude("tbl_user")
        ;

        //4  包名策略配置
        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setParent("com.ht")
        .setController("controller")
        .setMapper("mapper")
        .setService("service")
//        .setServiceImpl("serviceimpl")
        .setEntity("beans")
        .setXml("mapper")
        ;

        //5 整合配置
        AutoGenerator autoGenerator=new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
        .setDataSource(dataSourceConfig)
        .setStrategy(strategyConfig)
        .setPackageInfo(packageConfig);

        //6执行
        autoGenerator.execute();
    }









}
