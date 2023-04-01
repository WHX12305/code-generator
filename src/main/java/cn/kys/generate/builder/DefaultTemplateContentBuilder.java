package cn.kys.generate.builder;

import cn.hutool.core.util.IdUtil;
import cn.kys.generate.builder.config.GenerateConfig;
import cn.kys.generate.builder.config.TableConfig;
import cn.kys.generate.builder.model.Column;
import cn.kys.generate.builder.model.FileTemplateContent;
import cn.kys.generate.builder.model.Table;
import cn.kys.generate.dao.PubMapper;
import cn.kys.generate.util.GenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * <p>
 * 默认模板内容实现
 * </p>
 *
 * @author catnip
 */
@Component
public class DefaultTemplateContentBuilder implements TemplateContentBuilder {

    @Autowired
    private GenerateConfig generateConfig;

    @Autowired
    private PubMapper pubMapper;

    @Autowired
    private DataSource dataSource;

    /**
     * 数据库名
     */
    private String database;

    @Override
    public List<FileTemplateContent> buildTemplateContent() {
        List<FileTemplateContent> fileTemplateContents = new ArrayList<>();
        List<String> tableNames = generateConfig.getTables().stream().map(TableConfig::getTableName).toList();
        Connection conn;
        try {
            conn = dataSource.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet tableResultSet = metaData.getTables(null, "%", "%", new String[]{"TABLE"});
            while (tableResultSet.next()) {
                //获取表名
                String tableName = tableResultSet.getString("TABLE_NAME");
                //匹配表名
                if (tableNames.contains(tableName) || tableNames.get(0).equals("all")) {
                    Optional<TableConfig> first = generateConfig.getTables().stream()
                            .filter(e -> e.getTableName().equals(tableName))
                            .findFirst();
                    if (first.isPresent()) {
                        FileTemplateContent fileTemplateContent = new FileTemplateContent();
                        fileTemplateContent.setGenerateConfig(generateConfig);
                        fileTemplateContent.setSerialNo(IdUtil.getSnowflakeNextIdStr());
                        fileTemplateContent.setDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                        TableConfig tableConfig = first.get();
                        buildTableConfig(tableConfig);
                        fileTemplateContent.setTableConfig(tableConfig);
                        fileTemplateContent.setTable(buildTable(tableName, tableConfig));
                        fileTemplateContents.add(fileTemplateContent);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fileTemplateContents;
    }

    // todo 通过反射映射值
    private void buildTableConfig1(TableConfig tableConfig) {
        Class<? extends TableConfig> tableConfigClass = tableConfig.getClass();
        //获取TableConfig的字段名集合
        List<String> fieldNames = Arrays.stream(tableConfigClass.getDeclaredFields())
                .map(Field::getName).toList();

        for (String fieldName : fieldNames) {
            try {
                Field tableConfigfField = tableConfigClass.getDeclaredField(fieldName);
                tableConfigfField.setAccessible(true);
                Object target = tableConfigfField.get(tableConfig);
                if (target == null) {
                    Field[] fields = generateConfig.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        if (field.getName().equals(tableConfigfField.getName())) {
                            Object source = field.get(generateConfig);
                            tableConfigfField.set(tableConfig, source);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void buildTableConfig(TableConfig tableConfig) {
        if (tableConfig.getAuthor() == null) {
            tableConfig.setAuthor(generateConfig.getAuthor());
        }
        if (tableConfig.getTablePrefix() == null) {
            tableConfig.setTablePrefix(generateConfig.getTablePrefix());
        }
        if (tableConfig.getAutoGenerate() == null) {
            tableConfig.setAutoGenerate(generateConfig.getAutoGenerate());
        }
        if (tableConfig.getDeleteName() == null) {
            tableConfig.setDeleteName(generateConfig.getDeleteName());
        }
        if (tableConfig.getBasePackage() == null) {
            tableConfig.setBasePackage(generateConfig.getBasePackage());
        }
        if (tableConfig.getEnableSwagger() == null) {
            tableConfig.setEnableSwagger(generateConfig.getEnableSwagger());
        }
    }

    private Table buildTable(String tableName, TableConfig tableConfig) throws SQLException {
        Table table = new Table();
        table.setOriginName(tableName);
        String tablePrefix = tableConfig.getTablePrefix() == null ? "" : tableConfig.getTablePrefix();
        table.setClassName(
                GenerateUtil.firstUpper(
                        GenerateUtil.hump(tableName.replace(tablePrefix, ""))
                )
        );
        table.setFieldName(GenerateUtil.hump(tableName.replace(tablePrefix, "")));
        database = dataSource.getConnection().getCatalog();
        String selectDesc =
                "SELECT TABLE_COMMENT FROM information_schema.tables WHERE TABLE_SCHEMA = '" + database + "' AND TABLE_NAME = '" + tableName + "'";
        List<LinkedHashMap<String, String>> publicItems = pubMapper.getPublicItems(selectDesc);
        LinkedHashMap<String, String> tableSchema = publicItems.get(0);
        if (tableSchema == null || tableSchema.size() == 0) {
            throw new RuntimeException(tableName + "未执行建表语句");
        }

        String desc = tableSchema.get("TABLE_COMMENT");
        table.setDesc(desc);

        buildColumns(table);
        return table;
    }

    private void buildColumns(Table table) {
        String selectColumns =
                "SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA='"
                        + database + "' AND table_name = '" + table.getOriginName() + "' ORDER BY ORDINAL_POSITION";
        List<LinkedHashMap<String, String>> publicItems = pubMapper.getPublicItems(selectColumns);
        List<Column> columns = new ArrayList<>();
        List<Column> indexList = new ArrayList<>();
        Set<String> columnsPackage = new HashSet<>();
        Set<String> columnsKeyPackage = new HashSet<>();
        publicItems.forEach(e -> {
            Column column = new Column();
            column.setDesc(e.get("COLUMN_COMMENT"));
            column.setKey(e.get("COLUMN_KEY"));
            column.setType(e.get("COLUMN_TYPE"));
            column.setCanNull("YES".equals(e.get("IS_NULLABLE")));
            column.setOriginName(e.get("COLUMN_NAME"));
            column.setFieldName(GenerateUtil.hump(e.get("COLUMN_NAME")));
            column.setUpperFieldName(GenerateUtil.firstUpper(column.getFieldName()));
            String dataType = GenerateUtil.getType(e.get("DATA_TYPE")).split("\\.")[2];
            column.setType("Byte".equals(dataType) ? "Byte[]" : dataType);
            column.setTypePackage(GenerateUtil.getType(e.get("DATA_TYPE")));
            columns.add(column);
            columnsPackage.add(column.getTypePackage());
            if (column.getKey() != null && !"".equals(column.getKey()) && !"PRI".equals(column.getKey())) {
                columnsKeyPackage.add(column.getTypePackage());
                indexList.add(column);
            }
        });
        table.setColumns(columns);
        table.setColumnPackage(columnsPackage);
        table.setIndex(indexList);
        table.setIndexPackage(columnsKeyPackage);
    }
}
