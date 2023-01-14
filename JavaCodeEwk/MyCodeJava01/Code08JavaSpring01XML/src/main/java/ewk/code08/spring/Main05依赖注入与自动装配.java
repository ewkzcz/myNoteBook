package ewk.code08.spring;

import ewk.code08.book.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main05依赖注入与自动装配 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = (BookDao) applicationContext.getBean("bookDao");
        bookDao.save();
    }
}
