package ewk.code08.spring;

import ewk.code08.book.BookDao;
import ewk.code08.book.BookService;
import ewk.code08.book.BookServiceClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main01Spring入门IoC及dI案例 {
    public static void main(String[] args) {
        // testOld();
        // 使用Spring接管对象创建后,原来在IoC容器外部创建对象的方式由于删除了new操作,会产生空指针异常
        System.out.println();
        testNew();
    }
    public static void testOld(){
        BookService bookService = new BookServiceClass();
        bookService.save();
    }
    public static void testNew(){
        // 获取Ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取bean
        BookDao bookDao = (BookDao) applicationContext.getBean("bookDao");
        bookDao.save();
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        bookService.save();
    }
}
