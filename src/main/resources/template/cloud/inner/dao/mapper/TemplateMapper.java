package ${generateConfig.basePackage}.inner.dao.mapper;

import ${generateConfig.basePackage}.inner.dao.entity.${table.className}DO;
import ${generateConfig.basePackage}.inner.dao.query.${table.className}DaoQuery;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ${table.className}Mapper {

    /**
     * 根据id查询单条
     */
    ${table.className}DO selectOneById(Long id);

    /**
     * 根据id列表查询多条
     */
    List<${table.className}DO> selectByIds(List<Long> ids);

    /**
     * 条件查询多条
     */
    List<${table.className}DO> selectByCondition(${table.className}DaoQuery query);

    /**
     * 新增一条
     */
    int insert(${table.className}DO ${table.fieldName});

    /**
     * 批量新增
     */
    void batchInsert(List<${table.className}DO> ${table.fieldName}s);

    /**
     * 根据主键id更新
     */
    void updateById(${table.className}DO ${table.fieldName});
}