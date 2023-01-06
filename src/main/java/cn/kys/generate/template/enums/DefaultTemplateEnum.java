package cn.kys.generate.template.enums;

/**
 * <p>
 * 生成文件对应包路径
 * </p>
 *
 * @author whx
 * @since 2022/9/27 下午2:54
 */
public enum DefaultTemplateEnum implements TemplateEnum{
    SERVICE(".service.", "", "Service.java"),
    WRITE_SERVICE(".service.","","WriteService.java"),
    SERVICE_IMPL(".service.","", "ServiceImpl.java"),
    WRITE_SERVICE_IMPL(".service.","", "WriteServiceImpl.java"),
    DAO_ENTITY(".dao.entity.","", "DO.java"),
    DAO_QUERY(".dao.query.","", "DaoQuery.java"),
    DAO_MAPPER(".dao.mapper.","", "Mapper.java"),
    DAO_MAPPER_XML(".dao.mapper.","", "Mapper.xml"),
    MODEL_DTO(".model.dto.","", "DTO.java"),
    MODEL_ADD(".model.dto.param.","", "AddParam.java"),
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

    @Override
    public String getPath() {
        return path;
    }
    @Override
    public String getPrefix() {
        return prefix;
    }
    @Override
    public String getSuffix() {
        return suffix;
    }
    @Override
    public String getTemplateName(){
        return prefix + "Template" + suffix;
    }
    @Override
    public String getRePath(){
        return path.replace(".", "/");
    }
}
