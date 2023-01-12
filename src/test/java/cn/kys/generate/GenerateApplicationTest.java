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
 * @author whx
 * @since 2022/9/27 下午4:16
 */
@SpringBootTest(classes = GenerateApplication.class, properties = "spring.profiles.active=home")
public class GenerateApplicationTest {
    @Autowired
    private GenerateFacade generateFacade;

    @Test
    public void test(){
        generateFacade.run();
    }
}
