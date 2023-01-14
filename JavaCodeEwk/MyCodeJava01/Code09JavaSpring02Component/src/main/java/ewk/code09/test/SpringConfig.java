package ewk.code09.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ewk.code09.book")
@PropertySource("jdbc.properties")
@Import({JdbcConfig.class})
public class SpringConfig {

}
