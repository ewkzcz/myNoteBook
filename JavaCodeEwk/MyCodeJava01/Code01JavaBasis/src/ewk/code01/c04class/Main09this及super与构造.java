package ewk.code01.c04class;

class Father2 {
    private int num1;
    private int num2;

    Father2() {
        System.out.println("构造函数Father");
    }

    Father2(int num1) {
        this();
        this.num1 = num1;
    }

    Father2(int num1, int num2) {
        this(num1);
        this.num2 = num2;
    }
}

class Son2 extends Father2 {
    Son2() {
        // 默认调用super(),相当于调用父类默认构造函数Father2()
        super();  // 显式调用默认构造函数
        System.out.println("构造函数Son");
    }

    Son2(int num1) {
        super(num1);
        System.out.println("构造函数Son");
    }

    Son2(int num1, int num2) {
        super(num1, num2);
        System.out.println("构造函数Son");
    }
}

public class Main09this及super与构造 {
    public static void main(String[] args) {
        Son2 s1 = new Son2();
        Son2 s2 = new Son2(1);
        Son2 s3 = new Son2(1, 1);

        // super函数用于子类构造函数调用父类构造函数: 一定在第一行,且只能出现一次
    }
}
