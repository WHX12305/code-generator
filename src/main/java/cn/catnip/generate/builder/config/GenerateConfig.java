package cn.catnip.generate.builder.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 生成配置
 * </p>
 *
 * @author catnip
 */
@Configuration
@ConfigurationProperties(prefix = "generate")
public class GenerateConfig {

    /**
     * 流程模板选择
     */
    private String template;

    /**
     * 作者
     */
    private String author;

    /**
     * 表前缀
     */
    private String tablePrefix;

    /**
     * 基础包路径
     */
    private String basePackage;

    /**
     * 由数据库自动生成的字段（新增时不会新增对应属性）
     */
    private String[] autoGenerate;

    /**
     * 删除条件
     */
    private String deleteName;

    /**
     * 是否开启swagger
     */
    private String enableSwagger;

    /**
     * 表配置列表
     */
    private List<TableConfig> tables;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String[] getAutoGenerate() {
        if (autoGenerate == null){
            autoGenerate = new String[]{};
        }
        return autoGenerate;
    }

    public void setAutoGenerate(String[] autoGenerate) {
        this.autoGenerate = autoGenerate;
    }

    public String getEnableSwagger() {
        return enableSwagger;
    }

    public void setEnableSwagger(String enableSwagger) {
        this.enableSwagger = enableSwagger;
    }

    public List<TableConfig> getTables() {
        return tables;
    }

    public void setTables(List<TableConfig> tables) {
        List<TableConfig> tableConfigs = new ArrayList<>();
        tables.forEach(e->{
            String tableName = e.getTableName();
            String[] split = tableName.split(",");
            for (String s : split) {
                TableConfig clone = e.clone();
                clone.setTableName(s);
                tableConfigs.add(clone);
            }
        });
        this.tables = tableConfigs;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getDeleteName() {
        return deleteName;
    }

    public void setDeleteName(String deleteName) {
        this.deleteName = deleteName;
    }
}
