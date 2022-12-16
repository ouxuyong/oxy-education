package com.oxygen.education;//package com.oxygen;
//
//import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//
//import java.util.*;
//
//// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
//public class CodeGenerator {
//
//    /**
//     * <p>
//     * 读取控制台内容
//     * </p>
//     */
//    public static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入" + tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if (StringUtils.isNotBlank(ipt)) {
//                return ipt;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }
//
//    public static void main(String[] args) {
//        // 代码生成器
////        AutoGenerator mpg = new AutoGenerator();
//        GlobalConfig.Builder gc = new GlobalConfig.Builder();
//        // 全局配置
////        GlobalConfig gc = builder.build();
//        String projectPath = System.getProperty("user.dir");
//        gc.outputDir(projectPath + "/src/main/java");
//        gc.author("jobob");
//        gc.openDir(false);
//        // gc.setSwagger2(true); 实体属性 Swagger2 注解
////        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig.Builder dataSourceBuilder =  new DataSourceConfig.Builder(
//                "jdbc:mysql://localhost:3306/ant?useUnicode=true&useSSL=false&characterEncoding=utf8",
//                "root",
//                "密码"
//        );
//
////        DataSourceConfig dsc = new DataSourceConfig();
////        dsc.setUrl("jdbc:mysql://localhost:3306/ant?useUnicode=true&useSSL=false&characterEncoding=utf8");
////        // dsc.setSchemaName("public");
////        dsc.setDriverName("com.mysql.jdbc.Driver");
////        dsc.setUsername("root");
////        dsc.setPassword("密码");
//        AutoGenerator mpg = new AutoGenerator(dataSourceBuilder.build());
////        mpg.setDataSource(dsc);
//        mpg.global(gc.build());
//        // 包配置
//        PackageConfig.Builder packageConfigBuilder = new PackageConfig.Builder();
//
////        PackageConfig pc = new PackageConfig();
//        packageConfigBuilder.moduleName(scanner("模块名"));
//        packageConfigBuilder.parent("com.baomidou.ant");
//        mpg.packageInfo(packageConfigBuilder.build());
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig();
//
//        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
//        // 如果模板引擎是 velocity
//        // String templatePath = "/templates/mapper.xml.vm";
//
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        /*
//        cfg.setFileCreate(new IFileCreate() {
//            @Override
//            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
//                // 判断自定义文件夹是否需要创建
//                checkDir("调用默认方法创建的目录，自定义目录用");
//                if (fileType == FileType.MAPPER) {
//                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
//                    return !new File(filePath).exists();
//                }
//                // 允许生成模板文件
//                return true;
//            }
//        });
//        */
//        cfg.fileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//
//        // 配置自定义输出模板
//        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        // templateConfig.setEntity("templates/entity2.java");
//        // templateConfig.setService();
//        // templateConfig.setController();
//
//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);
//
//        // 策略配置
//        StrategyConfig.Builder strategyBuilder = new StrategyConfig.Builder();
//        StrategyConfig strategy = new StrategyConfig();
//        strategyBuilder.Naming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
//        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
//        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
//        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//    }
//
//
//    public void test(){
//        FastAutoGenerator.create(url, username, password)
//                .globalConfig(builder -> {
//                    builder.author("abc") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
//                            .disableOpenDir() //禁止打开输出目录
//                            .outputDir(finalProjectPath + "/src/main/java"); // 指定输出目录
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.baomidou.mybatisplus.samples") // 设置父包名
//                            .moduleName("test") // 设置父包模块名
//                            .entity("model.entity") //设置entity包名
//                            .other("model.dto") // 设置dto包名
//                            .pathInfo(Collections.singletonMap(OutputFile.xml, finalProjectPath + "/src/main/resources/mapper")); // 设置mapperXml生成路径
//
//                })
//                .injectionConfig(consumer -> {
//                    Map<String, String> customFile = new HashMap<>();
//                    // DTO
//                    customFile.put("DTO.java", "/templates/entityDTO.java.ftl");
//                    consumer.customFile(customFile);
//                });
//    }
//
//}