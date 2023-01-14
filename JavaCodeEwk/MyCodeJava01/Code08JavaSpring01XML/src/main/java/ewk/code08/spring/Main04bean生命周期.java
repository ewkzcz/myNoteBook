package ewk.code08.spring;

import ewk.code08.book.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main04bean生命周期 {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext为ApplicationContext的子类,新增close的方法,可以触发destroy方法
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.registerShutdownHook();  // 设置关闭钩子
        BookDao bookDao = (BookDao) context.getBean("bookDao");
        bookDao.save();
        // context.close();
    }
}
