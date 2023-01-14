package ewk.code08.spring;

import ewk.code08.book.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class Main07加载properties文件 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource);
        BookDao bookDao = (BookDao) context.getBean("bookDao2");
        bookDao.save();
    }
}
