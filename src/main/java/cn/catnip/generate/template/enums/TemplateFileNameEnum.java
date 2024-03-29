package cn.catnip.generate.template.enums;

/**
 * <p>
 * 模板文件名称枚举
 * </p>
 *
 * @author catnip
 */
public enum TemplateFileNameEnum{
    SERVICE("", "Service.java"),
    SERVICE_IMPL("", "ServiceImpl.java"),
    DAO_ENTITY("", "DO.java"),
    DAO_MAPPER("", "Mapper.java"),
    DAO_MAPPER_XML("", "Mapper.xml"),
    DAO_REPOSITORY("", "Repository.java"),
    DAO_REPOSITORY_IMPL("", "RepositoryImpl.java"),
    MODEL_DTO("", "DTO.java"),
    MODEL_ADD("", "AddParam.java"),
    MODEL_UPDATE("", "UpdateParam.java"),
    MODEL_QUERY("", "Query.java"),
    ;
    private final String prefix;

    private final String suffix;

    TemplateFileNameEnum(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getTemplateName(){
        return prefix + "Template" + suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}
