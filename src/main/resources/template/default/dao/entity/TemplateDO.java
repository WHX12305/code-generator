package ${generateConfig.basePackage}.${templateInfo.packagePath};

import java.io.Serializable;
<#list table.columnPackage as typePackage>
import ${typePackage};
</#list>
/**
 * <p>
 * ${table.desc}
 * </p>
 *
 * @author ${generateConfig.author}
 */
public class ${table.className}DO implements Serializable{

    private static final long serialVersionUID = ${serialNo}L;
<#list table.columns as column>
    /**
     * <#if column.desc != "">${column.desc}</#if>
     * canNull: ${column.canNull?c}
     */
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