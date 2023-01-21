package ewk.code18.controller;

import ewk.code18.data.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/brands")
public class BrandController {
    @Value("${brand.brandName}")
    private String brandName;

    @Autowired
    private Environment environment;

    @Autowired
    private Brand brand;

    @Value("${dataArr[0]}")
    private String data1;

    @GetMapping()
    public String selectAll() {
        // 方法1
        System.out.println(brandName);
        // 方法2
        System.out.println(environment.getProperty("brand.enterpriseName"));
        // 方法3
        System.out.println(brand.getIntroduce());

        // 获取数组元素
        System.out.println(data1);

        return new String("hello");
    }
}
