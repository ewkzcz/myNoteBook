package ewk.code19;

import ewk.code19.data.Brand;
import ewk.code19.data.Page;
import ewk.code19.service.BrandServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SpringBoot整合SSM {
    @Autowired(required = false)
    private BrandServiceInterface brandServiceInterface;

    @Test
    public void testAdd() {
        Brand brand = new Brand("华强北", "华强北公司", "仿造第一");
        brandServiceInterface.add(brand);
    }

    @Test
    public void testDeleteById() {
        brandServiceInterface.deleteById(1010);
    }

    @Test
    public void testSelectAll() {
        List<Brand> brands = brandServiceInterface.selectAll();
        System.out.println(brands);
    }

    @Test
    public void testSelectById() {
        Brand brand = brandServiceInterface.selectById(1008);
        System.out.println(brand);
    }

    @Test
    public void testUpdateById() {
        Brand brand = new Brand(1008, "蒙牛", "蒙牛公司", "喝牛奶吗?");
        brandServiceInterface.updateById(brand);
    }

    @Test
    public void test() {
        Brand brand = new Brand(null, null, "公司", null);
        Page<Brand> page = brandServiceInterface.selectByPageAndCondition(1, 5, brand);
        System.out.println(page);
    }

    @Test
    public void testDeleteByIds() {
        brandServiceInterface.deleteByIds(new int[]{1001,1002});
    }
}
