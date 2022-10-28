package cn.kys.generate.builder.model;

import cn.kys.generate.builder.config.GenerateConfig;
import cn.kys.generate.builder.config.TableConfig;

/**
 * <p>
 * 模板内容
 * </p>
 *
 * @author whx
 * @since 2022/9/27 下午6:21
 */
public class FileTemplateContent {

    /**
     * 序列化id
     */
    private String serialNo;

    /**
     * 创建时间
     */
    private String dateTime;

    /**
     * 生成配置
     */
    private GenerateConfig generateConfig;

    /**
     * 表配置
     */
    private TableConfig tableConfig;

    /**
     * 读取的表信息
     */
    private Table table;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public GenerateConfig getGenerateConfig() {
        return generateConfig;
    }

    public void setGenerateConfig(GenerateConfig generateConfig) {
        this.generateConfig = generateConfig;
    }

    public TableConfig getTableConfig() {
        return tableConfig;
    }

    public void setTableConfig(TableConfig tableConfig) {
        this.tableConfig = tableConfig;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
