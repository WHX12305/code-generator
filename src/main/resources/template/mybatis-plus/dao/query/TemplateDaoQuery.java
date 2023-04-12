package ${generateConfig.basePackage}.${templateInfo.packagePath};

import java.io.Serializable;
<#list table.indexPackage as typePackage>
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
public class ${table.className}DaoQuery implements Serializable{

    private static final long serialVersionUID = ${serialNo}L;

<#list table.index as column>
    /**
     * <#if column.desc != "">${column.desc}</#if>
     */
    private ${column.type} ${column.fieldName};
</#list>
}