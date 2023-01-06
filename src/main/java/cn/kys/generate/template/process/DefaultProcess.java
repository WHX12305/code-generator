package cn.kys.generate.template.process;

import cn.kys.generate.builder.config.GenerateConfig;
import cn.kys.generate.builder.model.FileTemplateContent;
import cn.kys.generate.template.engine.TemplateEngine;
import cn.kys.generate.template.enums.CloudTemplateEnum;
import cn.kys.generate.template.enums.DefaultTemplateEnum;
import cn.kys.generate.template.enums.TemplateEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 默认模板生成流程处理器
 * </p>
 *
 * @author whx
 * @since 2022/9/27 下午2:35
 */
@Component
public class DefaultProcess extends Process {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void exec(FileTemplateContent fileTemplateContent) {
        String originName = fileTemplateContent.getTable().getOriginName();
        String className = fileTemplateContent.getTable().getClassName();
        GenerateConfig generateConfig = fileTemplateContent.getGenerateConfig();
        String templateFilePath = templateFilePath(generateConfig.getTemplate());
        String outPath = outPath(generateConfig);
        if (generateConfig.getTemplate().equals("default")){
            for (DefaultTemplateEnum value : DefaultTemplateEnum.values()) {
                LOG.info("开始生成{}表的{}", originName, value);
                templateEngine.process(templateFilePath + value.getRePath() + value.getTemplateName(),
                        buildTargetFilePath(
                                outPath,
                                value,
                                value.getPrefix() + className + value.getSuffix()),
                        fileTemplateContent);
                LOG.info("{}表的{}生成完毕", originName, value);
            }
        }
        if (generateConfig.getTemplate().equals("cloud")){
            for (CloudTemplateEnum value : CloudTemplateEnum.values()) {
                LOG.info("开始生成{}表的{}", originName, value);
                templateEngine.process(templateFilePath + value.getRePath() + value.getTemplateName(),
                        buildTargetFilePath(
                                outPath,
                                value,
                                value.getPrefix() + className + value.getSuffix()),
                        fileTemplateContent);
                LOG.info("{}表的{}生成完毕", originName, value);
            }
        }
    }

    private String buildTargetFilePath(String outPath, TemplateEnum templateEnum, String name) {
        return outPath + templateEnum.getRePath() + name;
    }

    private String outPath(GenerateConfig generateConfig){
        if (System.getProperties().getProperty("os.name").contains("Windows")){
            return this.getClass()
                    .getClassLoader()
                    .getResource("\\")
                    .getPath()
                    .replace("/target/test-classes/", "/src/main/resources/out/" + generateConfig.getBasePackage().replaceAll("\\.","/")).replaceFirst("/", "")
                    .replace("%5c", "");
        }
        return this.getClass()
                .getClassLoader()
                .getResource("")
                .getPath()
                .replace("/target/test-classes/", "/src/main/resources/out/" + generateConfig.getBasePackage().replaceAll("\\.","/"));
    }

    private String templateFilePath(String templateName){
        if (System.getProperties().getProperty("os.name").contains("Windows")){
            return this.getClass()
                    .getClassLoader()
                    .getResource("\\")
                    .getPath()
                    .replace("/target/test-classes/", "/src/main/resources/template/" + templateName)
                    .replaceFirst("/", "")
                    .replace("%5c", "");
        }
        return this.getClass()
                .getClassLoader()
                .getResource("")
                .getPath()
                .replace("/target/test-classes/", "/src/main/resources/template/" + templateName);
    }
}