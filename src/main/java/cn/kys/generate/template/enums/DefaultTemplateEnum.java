package cn.kys.generate.template.enums;

/**
 * <p>
 * 生成文件对应包路径
 * </p>
 *
 * @author whx
 * @since 2022/9/27 下午2:54
 */
public enum DefaultTemplateEnum {
    SERVICE(".service.", "I", "Service.java"),
    SERVICE_IMPL(".service.impl.","", "Service.java"),
    DAO_ENTITY(".dao.entity.","", "DO.java"),
    DAO_QUERY(".dao.query.","", "DaoQuery.java"),
    DAO_MAPPER(".dao.mapper.","", "Mapper.java"),
    DAO_MAPPER_XML(".dao.mapper.","", "Mapper.xml"),
    MODEL_DTO(".model.dto.","", "DTO.java"),
    MODEL_ADD(".model.dto.param.","", "AddParam.java"),
//    MODEL_UPDATE(".model.param.","", "UpdateParam.java"),
    MODEL_QUERY(".model.dto.query.","", "Query.java"),
    CONTROLLER(".controller.", "", "Controller.java");

    private final String path;

    private final String prefix;

    private final String suffix;

    DefaultTemplateEnum(String path, String prefix, String suffix) {
        this.path = path;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getPath() {
        return path;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getTemplateName(){
        return prefix + "Template" + suffix;
    }

    public String getRePath(){
        return path.replace(".", "/");
    }
}
