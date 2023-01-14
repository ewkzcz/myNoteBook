package ewk.code01.c04class;

// 单例模式:
// 只提供私有的构造方法
// 只含有一个静态私有对象,提供一个静态公有方法创建或获取它本身的静态私有对象

// 饿汉模式
class Single1 {

    private static Single1 single1 = new Single1();

    private Single1() {
    }

    public static Single1 getInstance() {
        return single1;
    }
}

// 懒汉模式
class Single2 {

    private static Single2 single2 = null;

    private Single2() {
    }

    public static Single2 getInstance() {
        if (single2 == null) {
            single2 = new Single2();
        }
        return single2;
    }
}

public class Main03单例模式 {
    public static void main(String[] args) {
        System.out.println(Single1.getInstance());
        System.out.println(Single1.getInstance());
        System.out.println(Single1.getInstance());

        System.out.println(Single2.getInstance());
        System.out.println(Single2.getInstance());
        System.out.println(Single2.getInstance());
    }
}
