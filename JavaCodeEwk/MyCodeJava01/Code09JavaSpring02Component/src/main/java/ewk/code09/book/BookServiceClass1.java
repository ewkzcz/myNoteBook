package ewk.code09.book;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("bookService1")
public class BookServiceClass1 implements BookService {
    @Value("${password}")
    private String password;

    @Override
    public void save() {
        System.out.println("save from service to dao" + password);
    }
}