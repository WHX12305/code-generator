package cn.kys.generate.template.engine;

/**
 * <p>
 * 模板引擎
 * </p>
 *
 * @author whx
 * @since 2022/9/27 下午3:33
 */
public interface TemplateEngine {

    /**
     * @param templateFilePath 模板文件路径
     * @param targetFilePath 目标文件路径
     * @param data 元数据
     */
    void process(String templateFilePath, String targetFilePath, Object data);
}
