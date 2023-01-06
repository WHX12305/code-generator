package cn.kys.generate.template.enums;

/**
 * <p>
 * 生成文件对应包路径
 * </p>
 *
 * @author whx
 * @since 2022/9/27 下午2:54
 */
public enum CloudTemplateEnum implements TemplateEnum{
    SERVICE(".api.service.", "", "Service.java"),
    WRITE_SERVICE(".api.service.","","WriteService.java"),
    SERVICE_IMPL(".inner.service.","", "ServiceImpl.java"),
    WRITE_SERVICE_IMPL(".inner.service.","", "WriteServiceImpl.java"),
    DAO_ENTITY(".inner.dao.entity.","", "DO.java"),
    DAO_QUERY(".inner.dao.query.","", "DaoQuery.java"),
    DAO_MAPPER(".inner.dao.mapper.","", "Mapper.java"),
    DAO_MAPPER_XML(".inner.dao.mapper.","", "Mapper.xml"),
    MODEL_DTO(".api.model.dto.","", "DTO.java"),
    MODEL_ADD(".api.model.dto.param.","", "AddParam.java"),
    MODEL_QUERY(".api.model.dto.query.","", "Query.java"),
    CONTROLLER(".api.controller.", "", "Controller.java");

    private final String path;

    private final String prefix;

    private final String suffix;

    CloudTemplateEnum(String path, String prefix, String suffix) {
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
