package cn.kys.generate.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * <p>
 * sql执行mapper
 * </p>
 *
 * @author whx
 * @since 2022/9/27 下午3:30
 */
@Mapper
public interface PubMapper {

    @Select("${sqlStr}")
    List<LinkedHashMap<String,String>> getPublicItems(@Param(value = "sqlStr") String sqlStr);
}
