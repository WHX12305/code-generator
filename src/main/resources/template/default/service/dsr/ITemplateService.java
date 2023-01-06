package ${generateConfig.basePackage}.service.dsr;

import ${generateConfig.basePackage}.model.dto.param.${table.className}AddParam;
import java.util.List;

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

    /**
     * 批量新增
     */
    void batchAdd(List<${table.className}AddParam> ${table.fieldName}AddParams);
}