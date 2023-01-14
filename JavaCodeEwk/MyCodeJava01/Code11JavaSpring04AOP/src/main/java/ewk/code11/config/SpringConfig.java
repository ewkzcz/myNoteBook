package ewk.code11.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("ewk.code11")
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
@EnableAspectJAutoProxy
public class SpringConfig {

}
