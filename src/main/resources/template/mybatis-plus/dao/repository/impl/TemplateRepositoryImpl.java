package ${generateConfig.basePackage}.${templateInfo.packagePath};

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${generateConfig.basePackage}.${templateInfo.doPackagePath}.${table.className}DO;
import ${generateConfig.basePackage}.${templateInfo.mapperPackagePath}.${table.className}Mapper;
import ${generateConfig.basePackage}.${templateInfo.repositoryPackagePath}.${table.className}Repository;
import org.springframework.stereotype.Service;

@Service
public class ${table.className}RepositoryImpl extends ServiceImpl<${table.className}Mapper, ${table.className}DO> implements ${table.className}Repository {

}