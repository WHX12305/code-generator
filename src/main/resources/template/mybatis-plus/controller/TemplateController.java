package ${generateConfig.basePackage}.${templateInfo.packagePath};

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * ${table.desc}
 * </p>
 */
@RestController
@RequestMapping("${table.fieldName}")
@Api(tags = "${table.desc}")
public class ${table.className}Controller {

}
