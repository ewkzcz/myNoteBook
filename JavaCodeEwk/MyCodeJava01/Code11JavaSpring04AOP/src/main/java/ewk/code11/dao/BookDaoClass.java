package ewk.code11.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDaoClass implements BookDao {
    public void save() {
        System.out.println(System.currentTimeMillis());
        System.out.println("save");
    }

    public void update() {
        System.out.println("update");
    }

    public int show() {
        System.out.println(100);
        return 100;
    }

    public String test(int num1, int num2) {
        return num1 + "," + num2;
    }

    public String testAfterReturning() {
        return "Hello";
    }
}
