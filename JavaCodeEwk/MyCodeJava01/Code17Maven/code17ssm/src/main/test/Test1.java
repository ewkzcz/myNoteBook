import ewk.code17.code17pojo.data.Brand;
import ewk.code17.code17pojo.data.Page;
import ewk.code17.code17ssm.config.SpringConfig;
import ewk.code17.code17ssm.service.BrandServiceInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class Test1 {
    @Autowired
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
    public void test111() {
        Brand brand = new Brand(null, null, "公司", null);
        Page<Brand> page = brandServiceInterface.selectByPageAndCondition(1, 1, brand);
        System.out.println(page);
    }

    @Test
    public void testDeleteByIds() {
        brandServiceInterface.deleteByIds(new int[]{1001,1002});
    }
}