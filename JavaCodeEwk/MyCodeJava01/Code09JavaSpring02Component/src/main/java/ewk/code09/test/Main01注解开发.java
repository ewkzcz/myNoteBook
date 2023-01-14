package ewk.code09.test;

import ewk.code09.book.BookDao;
import ewk.code09.book.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main01注解开发 {
    public static void main(String[] args) {
        // 获取Ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        // 获取bean
        BookDao bookDao = applicationContext.getBean(BookDao.class);  // 按名称
        bookDao.save();
    }
}
