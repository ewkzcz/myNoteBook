package ewk.code01.c04class;

class Person4 {
    private int num = 1;

    public void show() {
        class Inner2 {
            public void show() {
                System.out.println(num);
            }
        }  // 到此处,只定义了类,没有创建对象及调用
        Inner2 inner2 = new Inner2();
        inner2.show();
    }
}

public class Main05方法内部类 {
    public static void main(String[] args) {
        Person4 p = new Person4();
        p.show();  // 方法内部类调用外部类的公有成员
    }
}
