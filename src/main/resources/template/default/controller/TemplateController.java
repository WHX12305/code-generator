package ${generateConfig.basePackage}.controller;

import ${generateConfig.basePackage}.service.I${table.className}Service;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * ${table.desc}
 * </p>
 *
 * @author ${generateConfig.author}
 * @since ${dateTime}
 */
@RestController
@RequestMapping("${table.fieldName}")
@Api(tags = "${table.desc}")
public class ${table.className}Controller {

    @Autowired
    private I${table.className}Service ${table.fieldName}Service;

}
