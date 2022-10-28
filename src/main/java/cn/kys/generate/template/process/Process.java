package cn.kys.generate.template.process;

import cn.kys.generate.builder.model.FileTemplateContent;

/**
 * <p>
 * 模板渲染程序
 * </p>
 *
 * @author whx
 * @since 2022/9/27 下午2:35
 */
public abstract class Process {

    /**
     * @param fileTemplateContent 元数据
     */
    public abstract void exec(FileTemplateContent fileTemplateContent);
}
