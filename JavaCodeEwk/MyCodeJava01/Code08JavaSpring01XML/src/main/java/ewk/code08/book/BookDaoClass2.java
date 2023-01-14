package ewk.code08.book;

public class BookDaoClass2 implements BookDao {
    private String username;

    private String password;

    @Override
    public void save() {
        System.out.println("username = " + username + "\npassword = " + password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
