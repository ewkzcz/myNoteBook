package ewk.code08.spring;

import ewk.code08.book.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main08容器总结 {
    public static void main(String[] args) {
        // 1.创建容器的两种方式
        // 从类路径加载
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从文件系统加载
        // ApplicationContext context = new FileSystemXmlApplicationContext(""+
        //         "E:\\CodeJava\\MyCodeJava01\\Code08\\src\\main\\resources\\applicationContext.xml");

        // 2.获取bean的三种方式
        BookDao bookDao1 = (BookDao) context.getBean("bookDao");
        BookDao bookDao2 = context.getBean("bookDao",BookDao.class);
        // BookDao bookDao3 = context.getBean(BookDao.class);  // 不能有同类型bean
    }
}
