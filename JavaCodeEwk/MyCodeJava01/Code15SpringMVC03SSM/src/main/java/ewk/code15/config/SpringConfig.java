package ewk.code15.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration  // 配置类声明
@ComponentScan("ewk.code15.service")  // 加载bean
@PropertySource("classpath:jdbc.properties")  // 加载配置文件(注意classpath)
@Import({JdbcConfig.class, MybatisConfig.class})
@EnableTransactionManagement  // 开启事务管理
public class SpringConfig {
}
