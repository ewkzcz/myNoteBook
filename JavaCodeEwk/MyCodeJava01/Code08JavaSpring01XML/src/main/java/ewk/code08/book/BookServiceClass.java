package ewk.code08.book;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BookServiceClass implements BookService, InitializingBean, DisposableBean {
    // private BookDao bookDao = new BookDaoClass();
    private BookDao bookDao;

    public BookServiceClass() {
        System.out.println("调用无参构造方法实例化bean-bookService");
    }

    public BookServiceClass(BookDao bookDao) {
        System.out.println("调用有参构造方法实例化bean-bookService");
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
        System.out.println("save from service to dao");
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("service destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("service init");
    }
}
