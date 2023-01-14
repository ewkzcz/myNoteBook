package ewk.code11.test;

import ewk.code11.config.SpringConfig;
import ewk.code11.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main05AOP获取修改数据 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = applicationContext.getBean(BookDao.class);
        bookDao.test(100, 200);

        bookDao.testAfterReturning();
    }
}
