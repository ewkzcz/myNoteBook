package ewk.code18;

import ewk.code18.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Code18SpringBootApplicationTests {
    @Autowired(required = false)
    private BrandService brandService;

    @Test
    void contextLoads() {
        brandService.show();
    }

}
