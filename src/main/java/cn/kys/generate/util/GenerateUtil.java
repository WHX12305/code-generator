package cn.kys.generate.util;

/**
 * <p>
 *
 * </p>
 *
 * @author catnip
 */
public class GenerateUtil {

    /**
     * 转驼峰
     */
    public static String hump(String tableName) {
        String[] s = tableName.split("_");
        StringBuilder sb = new StringBuilder(s[0]);
        for (int i = 1; i < s.length; i++) {
            sb.append(firstUpper(s[i]));
        }
        return sb.toString();
    }

    /**
     * 首字母大写
     */
    public static String firstUpper(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1);
    }

    /**
     * 获取数据库对应java的type
     */
    public static String getType(String value) {
        return switch (value) {
            case "bit" -> "java.lang.Boolean";
            case "tinyint" -> "java.lang.Integer";
            case "smallint" -> "java.lang.Integer";
            case "mediumint" -> "java.lang.Integer";
            case "int" -> "java.lang.Integer";
            case "bigint" -> "java.lang.Long";
            case "float" -> "java.lang.Float";
            case "double" -> "java.lang.Double";
            case "decimal" -> "java.math.BigDecimal";
            case "date" -> "java.lang.LocalDateTime";
            case "datetime" -> "java.time.LocalDateTime";
            case "timestamp" -> "java.time.LocalDateTime";
            case "time" -> "java.time.LocalDateTime";
            case "year" -> "java.time.Short";
            case "char" -> "java.lang.String";
            case "varchar" -> "java.lang.String";
            case "tinytext" -> "java.lang.String";
            case "text" -> "java.lang.String";
            case "mediumtext" -> "java.lang.String";
            case "longtext" -> "java.lang.String";
            case "enum" -> "java.lang.String";
            case "set" -> "java.lang.String";

            case "binary" -> "java.lang.Byte";
            case "varbinary" -> "java.lang.Byte";
            case "tinyblob" -> "java.lang.Byte";
            case "blob" -> "java.lang.Byte";
            case "mediumblob" -> "java.lang.Byte";
            case "longblob" -> "java.lang.Byte";

            default -> "java.lang.String";
        };
    }
}
