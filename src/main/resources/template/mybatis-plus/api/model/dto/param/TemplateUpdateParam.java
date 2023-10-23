package ${generateConfig.basePackage}.${templateInfo.packagePath};

import java.io.Serial;
import java.io.Serializable;
<#list table.columnPackage as typePackage>
import ${typePackage};
</#list>
<#if tableConfig.enableSwagger == "true">import io.swagger.v3.oas.annotations.media.Schema;</#if>
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * ${table.desc}
 * </p>
 */<#if tableConfig.enableSwagger == "true">
@Schema(description = "${table.desc}")</#if>
@Getter
@Setter
public class ${table.className}UpdateParam implements Serializable{

    @Serial
    private static final long serialVersionUID = ${serialNo}L;
<#list table.columns as column>
<#if tableConfig.autoGenerate?seq_contains(column.originName)><#else>
    /**
     * <#if column.desc != "">${column.desc}</#if>
     */<#if tableConfig.enableSwagger == "true">
    @Schema(description = "${column.desc}")</#if>
    private ${column.type} ${column.fieldName};</#if>
</#list>
}