package ${generateConfig.basePackage}.inner.service

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${generateConfig.basePackage}.inner.dao.mapper.${table.className}Mapper

/**
 * <p>
 * I${table.className}Service的实现
 * </p>
 *
 * @author ${generateConfig.author}
 * @since ${dateTime}
 */
@Service
public class ${table.className}WriteServiceImpl implements I${table.className}WriteService {

    @Autowired
    private ${table.className}Mapper ${table.fieldName}Mapper;

}