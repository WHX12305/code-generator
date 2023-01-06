package ${generateConfig.basePackage}.inner.dao.query;

import java.io.Serializable;
<#list table.indexPackage as typePackage>
import ${typePackage};
</#list>
/**
 * <p>
 * ${table.desc}
 * </p>
 *
 * @author ${generateConfig.author}
 * @since ${dateTime}
 */
public class ${table.className}DaoQuery implements Serializable{

    private static final long serialVersionUID = ${serialNo}L;
<#list table.index as column>
    /**
     * <#if column.desc != "">${column.desc}</#if>
     */
    private ${column.type} ${column.fieldName};
</#list>
<#list table.index as column>

    public ${column.type} get${column.upperFieldName}() {
        return ${column.fieldName};
    }

    public void set${column.upperFieldName}(${column.type} ${column.fieldName}) {
        this.${column.fieldName} = ${column.fieldName};
    }
</#list>
}