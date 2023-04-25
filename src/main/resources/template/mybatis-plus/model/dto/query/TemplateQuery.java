package ${generateConfig.basePackage}.${templateInfo.packagePath};

import java.io.Serial;
import java.io.Serializable;
<#list table.indexPackage as typePackage>
import ${typePackage};
</#list><#if tableConfig.enableSwagger == "true">import io.swagger.v3.oas.annotations.media.Schema;</#if>
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * ${table.desc},查询条件
 * </p>
 */<#if tableConfig.enableSwagger == "true">
@Schema(description = "${table.desc},查询条件")</#if>
@Getter
@Setter
public class ${table.className}Query implements Serializable{
    @Serial
    private static final long serialVersionUID = ${serialNo}L;
<#list table.index as column>
    /**
     * <#if column.desc != "">${column.desc}</#if>
     */<#if tableConfig.enableSwagger == "true">
    @Schema(description = "${column.desc}")</#if>
    private ${column.type} ${column.fieldName};
</#list>
}