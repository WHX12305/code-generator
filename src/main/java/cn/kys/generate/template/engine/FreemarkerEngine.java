package cn.kys.generate.template.engine;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * <p>
 *  Freemarker模板引擎
 * </p>
 *
 * @author catnip
 */
@Component
public class FreemarkerEngine implements TemplateEngine{

    @Override
    public void process(String templateFilePath, String targetFilePath, Object data) {
        try {
            Template template = getTemplate(templateFilePath);
            // 创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
            String[] split = targetFilePath.split("/");
            File file = new File(targetFilePath.replace(split[split.length - 1], ""));
            if (!file.exists()){
                file.mkdirs();
            }
            Writer out = new FileWriter(targetFilePath);
            template.process(data, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Template getTemplate(String templateFilePath) throws IOException {
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        // 第二步：设置模板文件所在的路径。
        String[] split = templateFilePath.split("/");
        configuration.setDirectoryForTemplateLoading(
                new File(templateFilePath.replace(split[split.length - 1], "")));
        // 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
        // 第四步：加载一个模板，创建一个模板对象。
        return configuration.getTemplate(split[split.length - 1]);
    }
}
