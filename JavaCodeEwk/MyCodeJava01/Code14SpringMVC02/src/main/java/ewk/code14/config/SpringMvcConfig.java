package ewk.code14.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("ewk.code14.controller")
@EnableWebMvc  // 开启json数据转换
public class SpringMvcConfig {
}
