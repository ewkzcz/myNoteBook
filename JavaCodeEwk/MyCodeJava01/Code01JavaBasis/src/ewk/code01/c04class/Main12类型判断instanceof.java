package ewk.code01.c04class;

class Father5 {
    public void show(){
        System.out.println("Father");
    }
}

class Son5 extends Father5{
    public void show(){
        System.out.println("Son");
    }
}

public class Main12类型判断instanceof {
    public static void main(String[] args) {
        Father5 f = new Son5();
        Son5 s = (Son5)f;

        Son5 s1 = new Son5();
        Father5 f1 = (Father5)s1;

        System.out.println(f instanceof Father5);
        System.out.println(s instanceof Son5);
        System.out.println(f1 instanceof Father5);
        System.out.println(s1 instanceof Son5);

        System.out.println(f instanceof Son5);  // f实例为子类,所以是子类类型
        System.out.println(s instanceof Father5);  // 子类对象同时是父类类型
        System.out.println(f1 instanceof Son5);  // f1实例为子类,所以是子类类型
        System.out.println(s1 instanceof Father5);  // 子类对象同时是父类类型

        Father5 f2 = new Father5();
        Son5 s2 = new Son5();
        System.out.println(f2 instanceof Father5);
        System.out.println(f2 instanceof Son5);  // f2实例为父类,不是子类类型
        System.out.println(s2 instanceof Father5);
        System.out.println(s2 instanceof Son5);

        // 1.根据实例对象判断
        // 同时子类对象都包含了父类对象,所以子类对象同时是父类类型

        // 2.Object类为所有类的父类
        Object obj = new Father5();
        // obj.show();
        ((Father5) obj).show();  // show在Object类中无定义,必须转换为Father5类型对象再进行调用
    }
}
