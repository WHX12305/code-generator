package cn.kys.generate.builder;

import cn.kys.generate.builder.model.FileTemplateContent;

import java.util.List;

/**
 * <p>
 * 生成模板需要的数据
 * </p>
 *
 * @author whx
 * @since 2022/9/28 上午10:18
 */
public interface TemplateContentBuilder {

    List<FileTemplateContent> buildTemplateContent();
}
