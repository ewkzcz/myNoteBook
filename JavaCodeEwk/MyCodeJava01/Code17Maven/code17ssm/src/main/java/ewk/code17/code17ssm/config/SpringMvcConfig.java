package ewk.code17.code17ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration   // 声明配置类
@ComponentScan({"ewk.code17.code17ssm.controller","ewk.code17.code17ssm.config"})
@EnableWebMvc  // 开启json数据转换
public class SpringMvcConfig {
}
