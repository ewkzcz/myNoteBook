package ewk.code09.book;

// import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

// @Component("bookDao")
@Repository("bookDao")
// @Scope()
// @Scope("single")
@Scope("prototype")
public class BookDaoClass implements BookDao {
    @Override
    public void save() {
        System.out.println("save from dao to database");
    }

    public void init(){
        System.out.println("init");
    }

    public void destroy(){
        System.out.println("destroy");
    }
}
