package cn.catnip.generate.builder.model;

/**
 * <p>
 * 列信息
 * </p>
 *
 * @author catnip
 */
public class Column {

    /**
     * 原始列名
     */
    private String originName;

    /**
     * class属性名
     */
    private String fieldName;

    /**
     * 首字母大写的属性名
     */
    private String UpperFieldName;

    /**
     * 类型
     */
    private String type;

    /**
     * 是否可以空
     */
    private Boolean canNull;

    /**
     * 类型路径
     */
    private String typePackage;

    /**
     * 备注
     */
    private String desc;

    /**
     * 是否覆盖索引
     */
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypePackage() {
        return typePackage;
    }

    public void setTypePackage(String typePackage) {
        this.typePackage = typePackage;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getCanNull() {
        return canNull;
    }

    public void setCanNull(Boolean canNull) {
        this.canNull = canNull;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getUpperFieldName() {
        return UpperFieldName;
    }

    public void setUpperFieldName(String upperFieldName) {
        UpperFieldName = upperFieldName;
    }
}
