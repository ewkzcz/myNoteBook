package ewk.code11.test;

import ewk.code11.config.SpringConfig;
import ewk.code11.data.Brand;
import ewk.code11.service.BrandServiceInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main04业务层接口万次执行时间 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        BrandServiceInterface brandServiceInterface = applicationContext.getBean(BrandServiceInterface.class);
        List<Brand> brandList = brandServiceInterface.selectAll();
        for (Brand brand : brandList) {
            System.out.print(brand);
        } // 万次查询耗费约4秒
    }
}
