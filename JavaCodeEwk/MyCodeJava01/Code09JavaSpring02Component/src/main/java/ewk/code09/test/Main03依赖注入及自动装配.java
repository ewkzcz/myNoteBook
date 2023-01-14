package ewk.code09.test;

import ewk.code09.book.BookDao;
import ewk.code09.book.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main03依赖注入及自动装配 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = context.getBean(BookDao.class);
        bookDao.save();
        BookService bookService1 = (BookService) context.getBean("bookService");
        bookService1.save();
        BookService bookService2 = (BookService) context.getBean("bookService1");
        bookService2.save();
    }
}
