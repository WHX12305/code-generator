package ${generateConfig.basePackage}.controller;

import ${generateConfig.basePackage}.service.${table.className}Service;
import ${generateConfig.basePackage}.service.${table.className}WriteService;
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
    private ${table.className}Service ${table.fieldName}Service;

    @Autowired
    private ${table.className}WriteService ${table.fieldName}WriteService;
}
