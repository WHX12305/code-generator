package ${generateConfig.basePackage}.${templateInfo.packagePath};

import java.io.Serializable;
<#list table.columnPackage as typePackage>
import ${typePackage};
</#list>
<#if tableConfig.enableSwagger == "true">import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;</#if>
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * ${table.desc}
 * </p>
 *
 * @author ${generateConfig.author}
 */<#if tableConfig.enableSwagger == "true">
@ApiModel("${table.desc}")</#if>
@Getter
@Setter
public class ${table.className}DTO implements Serializable{

    private static final long serialVersionUID = ${serialNo}L;
<#list table.columns as column><#if tableConfig.deleteName??><#if tableConfig.deleteName != column.originName>
    /**
     * <#if column.desc != "">${column.desc}</#if>
     */<#if tableConfig.enableSwagger == "true">
    @ApiModelProperty(required = ${column.canNull?c}, value = "${column.desc}")</#if>
    private ${column.type} ${column.fieldName};
</#if><#else>
    /**
     * <#if column.desc != "">${column.desc}</#if>
     */<#if tableConfig.enableSwagger == "true">
    @ApiModelProperty(required = ${column.canNull?c}, value = "${column.desc}")</#if>
    private ${column.type} ${column.fieldName};
</#if></#list>
}