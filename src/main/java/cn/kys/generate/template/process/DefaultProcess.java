package cn.kys.generate.template.process;

import cn.kys.generate.builder.config.GenerateConfig;
import cn.kys.generate.builder.model.FileTemplateContent;
import cn.kys.generate.builder.model.TemplateInfo;
import cn.kys.generate.template.engine.TemplateEngine;
import cn.kys.generate.template.enums.TemplateFileNameEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * <p>
 * 默认模板生成流程处理器
 * </p>
 *
 * @author catnip
 */
@Component
public class DefaultProcess extends Process {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void exec(FileTemplateContent fileTemplateContent) {
        GenerateConfig generateConfig = fileTemplateContent.getGenerateConfig();
        String templateConfigName = generateConfig.getTemplate();
        String templateFilePath = templateFilePath(templateConfigName);
        String outPath = outPath(generateConfig.getBasePackage());
        for (TemplateFileNameEnum templateFileNameEnum : TemplateFileNameEnum.values()) {
            String templateName = templateFileNameEnum.getTemplateName();
            //添加模板信息
            TemplateInfo templateInfo = new TemplateInfo();
            String templatePathPartPackage = getTemplatePathPartPackage(templateFilePath, templateConfigName, templateName);
            templateInfo.setPackagePath(templatePathPartPackage);
            templateInfo.setDoPackagePath(getTemplatePathPartPackage(templateFilePath, templateConfigName, TemplateFileNameEnum.DAO_ENTITY.getTemplateName()));
            templateInfo.setDoQueryPackagePath(getTemplatePathPartPackage(templateFilePath, templateConfigName, TemplateFileNameEnum.DAO_QUERY.getTemplateName()));
            templateInfo.setMapperPackagePath(getTemplatePathPartPackage(templateFilePath, templateConfigName, TemplateFileNameEnum.DAO_MAPPER.getTemplateName()));
            fileTemplateContent.setTemplateInfo(templateInfo);
            if (templatePathPartPackage == null){
                templatePathPartPackage = "";
            }
            templateEngine.process(
                    templateFilePath + "/" + templatePathPartPackage.replaceAll("\\.", "/") + "/" + templateName,
                    outPath + "/" + templatePathPartPackage.replaceAll("\\.", "/") + "/" + templateFileNameEnum.getPrefix() + fileTemplateContent.getTable().getClassName() + templateFileNameEnum.getSuffix(),
                    fileTemplateContent
            );
            LOG.info("{}表的{}生成完毕", fileTemplateContent.getTableConfig().getTableName(), templateName);
        }
    }

    /**
     * @param templateFilePath     当前选择模板
     * @param templateName 当前生成的模板文件名称
     * @return 模板文件子包路径
     */
    private String getTemplatePathPartPackage(String templateFilePath, String templateConfigName, String templateName) {
        try {
            Optional<Path> first = Files.walk(Paths.get(templateFilePath)).filter(e -> e.getFileName().toString().equals(templateName)).findFirst();
            if (first.isPresent()) {
                String templatePath = first.get().toString();
                return templatePath.split(templateConfigName + "/")[1].split("/" + templateName)[0].replaceAll("/", ".");
            }else {
                LOG.warn("templateFilePath:{},templateConfigName{},templateName:{}", templateFilePath, templateConfigName, templateName);
                return null;
            }
        } catch (IOException e) {
            LOG.error("templateFilePath:{},templateConfigName{},templateName:{}", templateFilePath, templateConfigName, templateName);
            throw new RuntimeException(e);
        }
    }

    /**
     * @param basePackage 基础包路径
     * @return 文件输出路径
     */
    private String outPath(String basePackage) {
        //Window系统输出路径
        if (System.getProperties().getProperty("os.name").contains("Windows")) {
            return this.getClass()
                    .getClassLoader()
                    .getResource("\\")
                    .getPath()
                    .replace("/target/test-classes/", "/src/main/resources/out/" + basePackage.replaceAll("\\.", "/")).replaceFirst("/", "")
                    .replace("%5c", "");
        }
        //Linux系统输出路径
        return this.getClass()
                .getClassLoader()
                .getResource("")
                .getPath()
                .replace("/target/test-classes/", "/src/main/resources/out/" + basePackage.replaceAll("\\.", "/"));
    }

    /**
     * @param templateName 模板名称
     * @return 模板文件路径
     */
    private String templateFilePath(String templateName) {
        if (System.getProperties().getProperty("os.name").contains("Windows")) {
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