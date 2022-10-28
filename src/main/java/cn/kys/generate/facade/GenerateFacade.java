package cn.kys.generate.facade;

import cn.kys.generate.builder.model.FileTemplateContent;
import cn.kys.generate.builder.TemplateContentBuilder;
import cn.kys.generate.template.process.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 代码生成入口
 * </p>
 *
 * @author whx
 * @since 2022/9/27 下午4:08
 */
@Component
public class GenerateFacade {

    @Autowired
    private Process process;

    @Autowired
    private TemplateContentBuilder templateContentBuilder;

    public void run(){
        List<FileTemplateContent> fileTemplateContents = templateContentBuilder.buildTemplateContent();
        fileTemplateContents.forEach(e-> process.exec(e));
    }
}
