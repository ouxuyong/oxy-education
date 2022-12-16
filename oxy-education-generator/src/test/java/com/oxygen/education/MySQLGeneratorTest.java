package com.oxygen.education;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import org.junit.Test;

import java.util.Collections;

/**
 * MySQL 代码生成
 *
 * @author lanjerry
 * @since 3.5.3
 */
public class MySQLGeneratorTest extends BaseGeneratorTest {
    private final static String FINAL_PROJECT_PATH = "D:\\oxy_project\\oxy-education\\oxy-education-generator";

    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
        .Builder("jdbc:mysql://localhost:3306/oxy_education?serverTimezone=Asia/Shanghai", "root", "123456")
//        .schema("oxy-education-generator")
        .build();

    @Test
    public void testSimple() {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(
                new StrategyConfig.Builder()
                .addInclude("company_table_config")
                .mapperBuilder().enableBaseResultMap()
                .build()
        );
        generator.packageInfo(
                new PackageConfig.Builder()
                .parent("com/oxygen/education")
                .moduleName("model")
                .mapper("mapper")
                .pathInfo(Collections.singletonMap(OutputFile.xml, FINAL_PROJECT_PATH + "/src/main/resources/mapper"))
                .build()
        );
        generator.global(
                new GlobalConfig.Builder()
                        //作者名字
                        .author("oxy")
                        // 输出路径
                        .outputDir(FINAL_PROJECT_PATH + "/src/main/java")
                        .fileOverride()
                        .build()
        );
        generator.execute();
    }
}