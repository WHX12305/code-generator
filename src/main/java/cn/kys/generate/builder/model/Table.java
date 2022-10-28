package cn.kys.generate.builder.model;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 表信息
 * </p>
 *
 * @author whx
 * @since 2022/7/5 下午6:00
 */
public class Table {

    /**
     * 表名 tb_address
     */
    private String originName;

    /**
     * 生成的类名 Address
     */
    private String className;

    /**
     * 作为参数时的名称 address
     */
    private String fieldName;

    /**
     * 列信息
     */
    private List<Column> columns;

    /**
     * 注释
     */
    private String desc;

    /**
     * 列路径集合
     */
    private Set<String> columnPackage;

    /**
     * 索引列信息
     */
    private List<Column> index;

    /**
     * 索引列路径集合
     */
    private Set<String> indexPackage;

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public void setColumnPackage(Set<String> columnPackage) {
        this.columnPackage = columnPackage;
    }

    public void setIndexPackage(Set<String> indexPackage) {
        this.indexPackage = indexPackage;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<String> getColumnPackage() {
        return columnPackage;
    }

    public Set<String> getIndexPackage() {
        return indexPackage;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Column> getIndex() {
        return index;
    }

    public void setIndex(List<Column> index) {
        this.index = index;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
