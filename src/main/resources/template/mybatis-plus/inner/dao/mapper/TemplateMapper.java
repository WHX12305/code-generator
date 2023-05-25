package ${generateConfig.basePackage}.${templateInfo.packagePath};

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ${generateConfig.basePackage}.${templateInfo.doPackagePath}.${table.className}DO;

@Mapper
public interface ${table.className}Mapper extends BaseMapper<${table.className}DO>{

}