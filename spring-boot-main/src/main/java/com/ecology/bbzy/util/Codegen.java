package com.ecology.bbzy.util;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.ColumnConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.core.service.IService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.zaxxer.hikari.HikariDataSource;

public class Codegen {

    public static void main(String[] args) {
        //配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://192.168.6.173:3306/mytest?characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("wkqdmm");

        //创建配置内容，两种风格都可以。
        GlobalConfig globalConfig = createGlobalConfigUseStyle1();

        //通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig);

        //生成代码
        generator.generate();
    }

    public static GlobalConfig createGlobalConfigUseStyle1() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();


        //文件包路径
        globalConfig.setSourceDir("D:\\workspace\\spring-ecology-all\\spring-boot-main\\src\\main\\java");
        //设置根包
        globalConfig.setBasePackage("com.ecology.bbzy");
        //MapperXml路径
        globalConfig.setMapperXmlPath("D:\\workspace\\spring-ecology-all\\spring-boot-main\\src\\main\\resources\\mapping");

        //设置表前缀和只生成哪些表  未配置生成所有表
//        globalConfig.setTablePrefix("tb_");
//        globalConfig.setGenerateTable("tb_account", "tb_account_session");

        //设置生成 entity 并启用 Lombok
        globalConfig.setEntityGenerateEnable(true);
        globalConfig.setEntityWithLombok(true);

        //设置生成 mapper
        //globalConfig.setMapperGenerateEnable(true);
        //设置生成service
        globalConfig.setServiceGenerateEnable(true);
        //设置生成serviceImpl
        globalConfig.setServiceImplGenerateEnable(true);
        //设置生成mapperXml
        //globalConfig.setMapperXmlGenerateEnable(true);
        //配置生成tableDef
        //globalConfig.setTableDefGenerateEnable(true);

        //Service 生成配置
        globalConfig.getServiceConfig()
        //        .setClassPrefix("My")
                .setClassSuffix("Service")
                .setSuperClass(IService.class);

        //ServiceImpl 生成配置
        globalConfig.getServiceImplConfig()
        //        .setClassPrefix("My")
                .setClassSuffix("ServiceImpl")
                .setSuperClass(ServiceImpl.class);

        //MapperXml 生成配置
        globalConfig.getMapperXmlConfig()
        //        .setFilePrefix("My")
                .setFileSuffix("Mapper");

        globalConfig.getTableDefConfig()
        //        .setClassPrefix("My")
                .setClassSuffix("Def");

        //可以单独配置某个列
//        ColumnConfig columnConfig = new ColumnConfig();
//        columnConfig.setColumnName("tenant_id");
//        columnConfig.setLarge(true);
//        columnConfig.setVersion(true);
//        globalConfig.setColumnConfig("tb_account", columnConfig);

        return globalConfig;
    }

}
