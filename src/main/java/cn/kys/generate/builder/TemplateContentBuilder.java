package cn.kys.generate.builder;

import cn.kys.generate.builder.model.FileTemplateContent;

import java.util.List;

/**
 * <p>
 * 生成模板需要的数据
 * </p>
 *
 * @author catnip
 */
public interface TemplateContentBuilder {

    List<FileTemplateContent> buildTemplateContent();
}
