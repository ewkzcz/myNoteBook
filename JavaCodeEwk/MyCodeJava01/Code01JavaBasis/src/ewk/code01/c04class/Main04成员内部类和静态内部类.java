package ewk.code01.c04class;

class Person2 {
    private int num = 10;
    private String str = "Hello";

    class Inner {  // 成员内部类: 外部类名$内部类名.class
        private int innerNum = 123;
        private String innerStr = "ewk";
        private static int id = 111;

        public void showInner() {
            System.out.println(Person2.this.num + " " + str);  // 显式访问,隐式访问
        }
    }

    public void test() {
        Inner inner = new Inner();
        inner.showInner();
    }
}

class Person3 {
    private int num = 10;
    private String str = "Hello";
    private static String strStatic = "static";

    static class Inner1 {  // 成员内部类: 外部类名$内部类名.class
        private static String strStaticInner = "staticInner";

        public void showInner() {
            System.out.println(strStatic + " " + Person3.strStatic);  // 静态内部类只能访问外部类的静态成员
        }
    }

    public void test() {
        Person3.Inner1 inner = new Person3.Inner1();
        inner.showInner();
        System.out.println(Inner1.strStaticInner);
    }
}

public class Main04成员内部类和静态内部类 {
    public static void main(String[] args) {
        // 1.成员内部类
        Person2 p = new Person2();
        p.test();  // 成员内部类可以访问外部类的私有属性,成员内部类需要在成员函数中实例化才有成员属性

        Person2.Inner inner = new Person2().new Inner();
        // 等价于
        Person2 p1 = new Person2();
        Person2.Inner inner1 = p1.new Inner();

        inner.showInner();
        inner1.showInner();

        // 2.静态内部类
        Person3 p2 = new Person3();
        p2.test();  // 静态内部类可以访问外部类的私有静态成员,外部类也可以访问内部静态类的静态成员

        // 静态内部类的私有属性对于外部类是不存在的,对于其他类仍然存在
        // System.out.println(Person3.Inner1.strStaticInner);
    }
}
