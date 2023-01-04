package ${generateConfig.basePackage}.service.dsr;

import ${generateConfig.basePackage}.model.dto.param.${table.className}AddParam;
/**
 * <p>
 * ${table.desc}
 * </p>
 *
 * @author ${generateConfig.author}
 * @since ${dateTime}
 */
public interface I${table.className}Service {

    /**
     * 新增
     */
    void add(${table.className}AddParam ${table.fieldName}AddParam);
}