package cn.catnip.generate.facade;

import cn.catnip.generate.builder.model.FileTemplateContent;
import cn.catnip.generate.builder.TemplateContentBuilder;
import cn.catnip.generate.template.process.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 代码生成入口
 * </p>
 *
 * @author catnip
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
