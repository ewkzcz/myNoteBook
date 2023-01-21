//package ewk.code13.config;
//
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
//
//public class ServletContainersInitConfig1 extends AbstractDispatcherServletInitializer {
//    // 加载SpringMVC容器
//    @Override
//    protected WebApplicationContext createServletApplicationContext() {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(SpringMvcConfig.class);
//        return context;
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//    // 加载Spring容器
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(SpringConfig.class);
//        return context;
//    }
//}
