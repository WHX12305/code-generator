package cn.kys.generate;

import cn.kys.generate.facade.GenerateFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>
 * 生成代码
 * </p>
 *
 * @author catnip
 */
@SpringBootTest(classes = GenerateApplication.class, properties = "spring.profiles.active=t14local")
public class GenerateApplicationTest {
    @Autowired
    private GenerateFacade generateFacade;

    @Test
    public void test(){
        generateFacade.run();
    }
}
