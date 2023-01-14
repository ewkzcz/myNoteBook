package ewk.code01.c04class;

class Person5 {
    private int num;

    public void show() {

    }
}

public class Main06匿名内部类 {
    public static void main(String[] args) {
        // 方法1
        Person5 p = new Person5() {
            private int num = 1;

            public void show() {
                System.out.println(num * 10);
            }
        };
        p.show();

        // 方法2
        new Person5() {
            private int num = 1;

            public void show() {
                System.out.println(num * 20);
            }
        }.show();

        // 定义匿名内部类时,会立即创建一个该类的对象,该类定义立即消失,该类定义不能重复使用
        // 匿名内部类必须预定义
    }
}
