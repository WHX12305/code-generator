package ${generateConfig.basePackage}.${templateInfo.packagePath};

import java.io.Serializable;
<#list table.columnPackage as typePackage>
import ${typePackage};
</#list>
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * ${table.desc}
 * </p>
 *
 * @author ${generateConfig.author}
 */
@Getter
@Setter
public class ${table.className}DO implements Serializable{

    private static final long serialVersionUID = ${serialNo}L;
<#list table.columns as column>
    /**
     * <#if column.desc != "">${column.desc}</#if>
     * canNull: ${column.canNull?c}
     */
    private ${column.type} ${column.fieldName};
</#list>
}