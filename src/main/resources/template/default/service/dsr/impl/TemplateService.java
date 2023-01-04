package ${generateConfig.basePackage}.service.dsr.impl;

import ${generateConfig.basePackage}.model.dto.param.${table.className}AddParam;
import ${generateConfig.basePackage}.service.dsr.I${table.className}Service;
import ${generateConfig.basePackage}.entity.dsr.${table.className}DO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${generateConfig.basePackage}.utils.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import ${generateConfig.basePackage}.mapper.dsr.${table.className}Mapper;

/**
 * <p>
 * I${table.className}Service的实现
 * </p>
 *
 * @author ${generateConfig.author}
 * @since ${dateTime}
 */
@Service
public class ${table.className}Service implements I${table.className}Service {

    @Autowired
    private ${table.className}Mapper ${table.fieldName}Mapper;

    @Override
    public void add(${table.className}AddParam ${table.fieldName}AddParam) {
        ${table.fieldName}Mapper.insert(CopyUtil.copy(${table.fieldName}AddParam, ${table.className}DO.class));
    }
}