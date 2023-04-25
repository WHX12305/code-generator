package ${generateConfig.basePackage}.${templateInfo.packagePath};

<#list table.columnPackage as typePackage>
import ${typePackage};
</#list>
import lombok.Getter;
import lombok.Setter;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * ${table.desc}
 * </p>
 */
@Getter
@Setter
@TableName("${table.originName}")
public class ${table.className}DO {

<#list table.columns as column>
    /**
     * <#if column.desc != "">${column.desc}</#if>
     * canNull: ${column.canNull?c}
     */
    <#if column.primary==0>@TableId(type = IdType.AUTO)<#else>@TableField</#if>
    private ${column.type} ${column.fieldName};
</#list>
}