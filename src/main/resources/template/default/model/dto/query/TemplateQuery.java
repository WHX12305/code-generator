package ${generateConfig.basePackage}.${templateInfo.packagePath};

import java.io.Serializable;
<#list table.indexPackage as typePackage>
import ${typePackage};
</#list><#if tableConfig.enableSwagger == "true">
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;</#if>
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * ${table.desc},查询条件
 * </p>
 *
 * @author ${generateConfig.author}
 */<#if tableConfig.enableSwagger == "true">
@ApiModel("${table.desc},查询条件")</#if>
@Getter
@Setter
public class ${table.className}Query implements Serializable{

    private static final long serialVersionUID = ${serialNo}L;
<#list table.index as column>
    /**
     * <#if column.desc != "">${column.desc}</#if>
     */<#if tableConfig.enableSwagger == "true">
    @ApiModelProperty(required = ${column.canNull?c}, value = "${column.desc}")</#if>
    private ${column.type} ${column.fieldName};
</#list>
}