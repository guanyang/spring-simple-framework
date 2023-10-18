#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

/**
 * 功能描述：
 *
 * @author gy
 * @version 1.0.0
 */
public class MybatisAutoGeneratorHelper {


    // 数据源 url
    static final String url = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf8";
    // 数据库用户名
    static final String username = "root";
    // 数据库密码
    static final String password = "12345678";

    //源码路径
    static final String SRC_PATH = "/src/main/java";

    //资源路径
    static final String RESOURCE_PATH = "/src/main/resources";

    //项目根路径
    static final String path =
        System.getProperty("user.dir") + System.getProperty("file.separator");

    public static void main(String[] args) {
        String author = "gy";//代码生成者名字，仅作标识而已，可随意指定
        String basePackage = "${package}.dao";//框架模板自动生成
        String mavenProjectName = "${parentArtifactId}-dao";//框架模板自动生成
        String sourcePath = path + mavenProjectName + SRC_PATH;//固定路径
        String mapperXmlPath = path + mavenProjectName + RESOURCE_PATH + "/mappers";//固定路径
        String[] tableNames = {"hello_world"};//要生成的数据库表名，可以指定多个
        generator(author, basePackage, sourcePath, mapperXmlPath, url, username, password, tableNames);
    }

    /**
     * 功能描述：代码生成
     *
     * @param author 作者
     * @param basePackage package根路径
     * @param sourcePath 源码路径
     * @param mapperXmlPath mapperXml路径
     * @param url 数据库url
     * @param username 用户名
     * @param password 密码
     * @param tableNames 表名
     * @author gy
     * @version 1.0.0
     */
    private static void generator(String author, String basePackage, String sourcePath, String mapperXmlPath,
        String url, String username, String password, String... tableNames) {
        FastAutoGenerator.create(url, username, password)
            .globalConfig(builder -> {
                builder.author(author)                    // 设置作者
                    .fileOverride()                     // 覆盖已生成文件
                    .outputDir(sourcePath); // 指定输出目录
            })
            .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                if (typeCode == Types.TINYINT || typeCode == Types.SMALLINT) {
                    // 自定义类型转换
                    return DbColumnType.INTEGER;
                }
                return typeRegistry.getColumnType(metaInfo);
            }))
            .packageConfig(builder -> {
                builder.parent(basePackage) // 设置父包名
                    .pathInfo(Collections
                        .singletonMap(OutputFile.xml, mapperXmlPath)); // 设置mapperXml生成路径
            })
            .strategyConfig(builder -> {
                builder.addInclude(tableNames)   //设置表名
                        .entityBuilder()
                        .idType(IdType.AUTO)            //id自增
                        .enableLombok()                 //开启lombok
                        .enableColumnConstant()         //开启生成字段常量
                        .enableChainModel()
                        .enableFileOverride()
                        .versionColumnName("version")   //乐观锁字段名(数据库字段)
                        .addTableFills()
                        .logicDeleteColumnName("deleted")    //逻辑删除数据库字段
                        .enableActiveRecord().build()           //开启 activeRecord 模式
                        .controllerBuilder()
                        .enableRestStyle().build()
                        .mapperBuilder()
                        .enableFileOverride()
                        .enableBaseColumnList()     //XML columList
                        .enableBaseResultMap().build();
            })
            .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .templateConfig(builder -> {
                builder.disable(TemplateType.CONTROLLER);   //禁用controller生成
            })
            .execute();
    }

}
