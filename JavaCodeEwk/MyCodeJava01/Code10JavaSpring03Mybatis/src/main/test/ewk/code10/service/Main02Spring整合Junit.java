package ewk.code10.service;

import ewk.code10.config.SpringConfig;
import ewk.code10.data.Brand;
import ewk.code10.mapper.BrandMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class Main02Spring整合Junit {
    @Autowired(required=false)
    private BrandMapper brandMapper;

    @Test
    public void testSelectAll(){
        List<Brand> brandList = brandMapper.selectAll();
        for (Brand brand : brandList) {
            System.out.print(brand);
        }
    }
}
