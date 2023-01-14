package ewk.code08.book;

public class BookDaoFactory {
    public static BookDao getBookDao(){
        System.out.println("factory bookDao");
        return new BookDaoClass();
    }
}
