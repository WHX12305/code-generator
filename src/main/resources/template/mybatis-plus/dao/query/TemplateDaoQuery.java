package ${generateConfig.basePackage}.${templateInfo.packagePath};

<#list table.indexPackage as typePackage>
import ${typePackage};
</#list>
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * ${table.desc}
 * </p>
 */
@Getter
@Setter
public class ${table.className}DaoQuery {

<#list table.index as column>
    /**
     * <#if column.desc != "">${column.desc}</#if>
     */
    private ${column.type} ${column.fieldName};
</#list>
}