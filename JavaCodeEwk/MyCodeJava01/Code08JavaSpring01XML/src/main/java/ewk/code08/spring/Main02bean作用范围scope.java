package ewk.code08.spring;

import ewk.code08.book.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main02bean作用范围scope {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao1 = (BookDao) applicationContext.getBean("bookDao");
        BookDao bookDao2 = (BookDao) applicationContext.getBean("bookDao");
        System.out.println(bookDao1);
        System.out.println(bookDao2);  // 默认单例
    }
}
