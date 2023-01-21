package ewk.code14.test;

import ewk.code14.config.SpringMvcConfig;
import ewk.code14.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        /* register+refresh
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringConfig.class);
        context.refresh();
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringMvcConfig.class);
        System.out.println(context.getBean(UserController.class));
    }
}
