package ewk.code12.test;

import ewk.code12.config.SpringConfig;
import ewk.code12.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MainSpring事务及转账业务追加日志 {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
        accountService.transfer("Tom1", "Tom2", 100D);
    }
}
