package cn.kys.generate.builder.config;

/**
 * <p>
 * 表配置信息
 * </p>
 *
 * @author whx
 * @since 2022/9/27 下午2:09
 */
public class TableConfig {
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
     * 由数据库自动生成的字段（新增和删除时不会新增对应属性）
     */
    private String[] autoGenerate;

    /**
     * 删除字段
     */
    private String deleteName;

    /**
     * 是否开启swagger
     */
    private String enableSwagger;

    /**
     * 表名
     */
    private String tableName;

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

    public String getEnableSwagger() {
        return enableSwagger;
    }

    public void setEnableSwagger(String enableSwagger) {
        this.enableSwagger = enableSwagger;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDeleteName() {
        if (deleteName == null){
            deleteName = "";
        }
        return deleteName;
    }

    public void setDeleteName(String deleteName) {
        this.deleteName = deleteName;
    }

    public String[] getAutoGenerate() {
        return autoGenerate;
    }

    public void setAutoGenerate(String[] autoGenerate) {
        this.autoGenerate = autoGenerate;
    }
}
