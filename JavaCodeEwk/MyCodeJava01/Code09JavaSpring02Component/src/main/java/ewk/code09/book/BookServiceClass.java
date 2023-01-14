package ewk.code09.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceClass implements BookService {
    @Autowired
    @Qualifier("bookDao")
    private BookDao bookDao;

    @Override
    public void save() {
        System.out.println("save from service to dao");
        bookDao.save();
    }

    /* 提供@Autowired后,可以省略set方法
    public void setBookDao(BookDao bookDao){
        this.bookDao = bookDao;
    }
     */
}
