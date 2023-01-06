package ${generateConfig.basePackage}.controller.dsr;

import ${generateConfig.basePackage}.model.dto.param.${table.className}AddParam;
import ${generateConfig.basePackage}.service.dsr.I${table.className}Service;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.dynamic.datasource.annotation.DS;
import java.util.List;

/**
 * <p>
 * ${table.desc}
 * </p>
 *
 * @author whx
 * @since 2023/1/4 下午3:13
 */
@RestController
@RequestMapping("/spider/dsr/${table.fieldName}")
@Api(tags = "天猫dsr-${table.desc}")
public class ${table.className}Controller {

    @Autowired
    private I${table.className}Service ${table.fieldName}Service;

    @PostMapping("add")
    @DS("analysis")
    public String add(@RequestBody ${table.className}AddParam ${table.fieldName}AddParam){
        ${table.fieldName}Service.add(${table.fieldName}AddParam);
        return "success";
    }

    @PostMapping("batchAdd")
    @DS("analysis")
    public String batchAdd(@RequestBody List<${table.className}AddParam> ${table.fieldName}AddParams){
        ${table.fieldName}Service.batchAdd(${table.fieldName}AddParams);
        return "success";
    }
}
