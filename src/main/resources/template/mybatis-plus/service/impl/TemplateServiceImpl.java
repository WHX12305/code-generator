package ${generateConfig.basePackage}.${templateInfo.packagePath};

import org.springframework.stereotype.Service;
import ${generateConfig.basePackage}.${templateInfo.servicePackagePath}.${table.className}Service;
import ${generateConfig.basePackage}.${templateInfo.repositoryPackagePath}.${table.className}Repository;

/**
 * <p>
 * ${table.className}Service的实现
 * </p>
 */
@Service
public class ${table.className}ServiceImpl implements ${table.className}Service {

    private ${table.className}Repository ${table.fieldName}Repository;
}