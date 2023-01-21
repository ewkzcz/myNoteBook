package ewk.code16.config;

import ewk.code16.controller.ProjectInterceptor;
import ewk.code16.controller.ProjectInterceptor1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("ewk.code16.controller")
@EnableWebMvc  // 开启json数据转换
public class SpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Autowired
    private ProjectInterceptor1 projectInterceptor1;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/users", "/users/**");
        registry.addInterceptor(projectInterceptor1).addPathPatterns("/users", "/users/**");
    }
}
