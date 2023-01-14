package ewk.code10.test;

import ewk.code10.config.SpringConfig;
import ewk.code10.data.Brand;
import ewk.code10.service.BrandServiceClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main01Spring整合Mybatis {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        BrandServiceClass brandServiceClass = applicationContext.getBean(BrandServiceClass.class);
        List<Brand> brandList = brandServiceClass.selectAll();
        for (Brand brand : brandList) {
            System.out.print(brand);
        }
    }
}
