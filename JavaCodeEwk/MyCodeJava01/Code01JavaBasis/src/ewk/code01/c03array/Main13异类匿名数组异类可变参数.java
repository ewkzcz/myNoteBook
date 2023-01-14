package ewk.code01.c03array;

public class Main13异类匿名数组异类可变参数 {
    public static void main(String[] args) {
        show(1, 2, "zcz");
        show(1, 2, 3.3, 4, 5, "Hello");
        show(new Object[]{1, 2, 3.3, 4.4f, "5", '6', "Hello"});  // 异类匿名数组
    }

    public static void show(Object... args) {  // 异类可变参数
        for (Object i : args) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
