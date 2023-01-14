package ewk.code08.book;

public class BookDaoClass implements BookDao {
    public BookDaoClass(int connectNum, String databaseNum) {
        System.out.println("调用有参构造方法实例化bean-bookDao");
        this.connectNum = connectNum;
        this.databaseNum = databaseNum;
    }

    public void setConnectNum(int connectNum) {
        this.connectNum = connectNum;
    }

    public void setDatabaseNum(String databaseNum) {
        this.databaseNum = databaseNum;
    }

    private int connectNum;
    private String databaseNum;

    public BookDaoClass() {
        System.out.println("调用无参构造方法实例化bean-bookDao");
    }

    @Override
    public void save() {
        System.out.println("save from dao to database " + databaseNum + " " + connectNum);
    }

    public void init() {
        System.out.println("init");
    }

    public void destroy() {
        System.out.println("destroy");
    }
}
