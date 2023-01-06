package ${generateConfig.basePackage}.api.model.dto;

import java.io.Serializable;
<#list table.columnPackage as typePackage>
import ${typePackage};
</#list>
<#if tableConfig.enableSwagger == "true">import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;</#if>

/**
 * <p>
 * ${table.desc}
 * </p>
 *
 * @author ${generateConfig.author}
 * @since ${dateTime}
 */<#if tableConfig.enableSwagger == "true">
@ApiModel("${table.desc}")</#if>
public class ${table.className}DTO implements Serializable{

    private static final long serialVersionUID = ${serialNo}L;
<#list table.columns as column>
    /**
     * <#if column.desc != "">${column.desc}</#if>
     */<#if tableConfig.enableSwagger == "true">
    @ApiModelProperty(required = ${column.canNull?c}, value = "${column.desc}")</#if>
    private ${column.type} ${column.fieldName};
</#list>
<#list table.columns as column>

    public ${column.type} get${column.upperFieldName}() {
            return ${column.fieldName};
    }

    public void set${column.upperFieldName}(${column.type} ${column.fieldName}) {
            this.${column.fieldName} = ${column.fieldName};
    }
</#list>
}