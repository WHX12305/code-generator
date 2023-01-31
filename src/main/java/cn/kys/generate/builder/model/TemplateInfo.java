package cn.kys.generate.builder.model;

/**
 * <p>
 * 模板文件信息
 * </p>
 *
 * @author whx
 * @since 2023/1/31 下午2:33
 */
public class TemplateInfo {

    /**
     * 模板所在包部分路径
     */
    private String packagePath;

    /**
     * do包部分路径，包含类名
     */
    private String doPackagePath;

    /**
     * doQuery包部分路径，包含类名
     */
    private String doQueryPackagePath;

    /**
     * mapper包部分路径，包含类名
     */
    private String mapperPackagePath;

    public String getMapperPackagePath() {
        return mapperPackagePath;
    }

    public void setMapperPackagePath(String mapperPackagePath) {
        this.mapperPackagePath = mapperPackagePath;
    }

    public String getDoPackagePath() {
        return doPackagePath;
    }

    public void setDoPackagePath(String doPackagePath) {
        this.doPackagePath = doPackagePath;
    }

    public String getDoQueryPackagePath() {
        return doQueryPackagePath;
    }

    public void setDoQueryPackagePath(String doQueryPackagePath) {
        this.doQueryPackagePath = doQueryPackagePath;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }
}
