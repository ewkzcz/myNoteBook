package ewk.code09.test;

import ewk.code09.book.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main02纯注解开发 {
    public static void main(String[] args) {
        // 加载配置类初始化容器
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = context.getBean(BookDao.class);
        bookDao.save();
    }
}
