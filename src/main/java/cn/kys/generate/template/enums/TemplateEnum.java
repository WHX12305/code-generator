package cn.kys.generate.template.enums;

/**
 * <p>
 * 定义文件信息
 * </p>
 *
 * @author whx
 * @since 2023/1/6 下午5:16
 */
public interface TemplateEnum {

    /**
     * 获取包路径
     */
    String getPath();

    /**
     * 获取文件前缀
     */
    String getPrefix();

    /**
     * 获取文件后缀
     */
    String getSuffix();

    /**
     * 获取模板名称
     */
    String getTemplateName();

    /**
     * 获取真实文件路径
     */
    String getRePath();
}
