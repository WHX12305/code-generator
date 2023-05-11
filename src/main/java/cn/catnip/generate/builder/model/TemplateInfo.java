package cn.catnip.generate.builder.model;

/**
 * <p>
 * 模板文件信息
 * </p>
 *
 * @author catnip
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
     * doQuery包部分路径
     */
    private String doQueryPackagePath;

    /**
     * mapper包部分路径
     */
    private String mapperPackagePath;

    /**
     * service包部分路径
     */
    private String servicePackagePath;

    /**
     * repository包部分路径
     */
    private String repositoryPackagePath;

    public String getMapperPackagePath() {
        return mapperPackagePath;
    }

    public void setMapperPackagePath(String mapperPackagePath) {
        this.mapperPackagePath = mapperPackagePath;
    }

    public String getServicePackagePath() {
        return servicePackagePath;
    }

    public void setServicePackagePath(String servicePackagePath) {
        this.servicePackagePath = servicePackagePath;
    }

    public String getRepositoryPackagePath() {
        return repositoryPackagePath;
    }

    public void setRepositoryPackagePath(String repositoryPackagePath) {
        this.repositoryPackagePath = repositoryPackagePath;
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
