package ewk.code13.config;

import ewk.code13.controller.MyController;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement

@ComponentScan("ewk.code13")
//@ComponentScan(value = "ewk.code13",
//        excludeFilters = @ComponentScan.Filter(
//                type = FilterType.ANNOTATION,
//                classes = MyController.class
//        )
//)
public class SpringConfig {

}
