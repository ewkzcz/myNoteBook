package ewk.code11.test;

import ewk.code11.config.SpringConfig;
import ewk.code11.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main02AOP工作流程 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = applicationContext.getBean(BookDao.class);
        System.out.println(bookDao);  // toString被重写了
        System.out.println(bookDao.getClass()); // 获取类型
        bookDao.update();
    }
}
