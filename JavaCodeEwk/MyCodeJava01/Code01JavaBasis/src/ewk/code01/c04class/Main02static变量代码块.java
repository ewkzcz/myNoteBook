package ewk.code01.c04class;
// -Dfile.encoding=GBK

class Person1 {
    private static int count;  // 静态变量/类变量,存储在静态区/全局区
    private int num = 10;

    public Person1(int num1) {
        this.num = num1;
        count++;
        System.out.println("构造函数");
        // static int data = 10;
        // static关键字不能修饰局部变量
    }

    {
        System.out.println("构造代码块");
        // 调用顺序: new->构造代码块(自动)->构造函数(自动)
    }

    static {
        System.out.println("静态代码块");
        // 调用顺序(第一次): new->静态代码块(自动)->构造代码块(自动)->构造函数(自动)
        // 调用顺序(第二次及以后): new->静态代码块(自动)->构造代码块(自动)->构造函数(自动)
    }

    public static int getCount() {
        // this.num = 10;  // static方法不能访问实例变量
        return count;
    }
}

public class Main02static变量代码块 {
    public static void main(String[] args) {
        // Person1.getCount();  // 不创建对象,调用类的静态方法,也会触发static代码块执行

        new Person1(0);
        new Person1(0);
        new Person1(0);
        new Person1(0);
        Person1 p1 = new Person1(0);
        Person1 p2;
        System.out.println(Person1.getCount());  // static变量及getStatic方法统计实例化次数
    }
}
