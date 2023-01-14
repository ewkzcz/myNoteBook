package ewk.code01.c04class;

abstract class A {
    /* static内部类
    1.static不能修饰顶级类,但是可以修饰内部类
    2.静态内部类与外部类之间没有任何关系,其外部类只起到一个名称空间的作用,与包名类似
    3.静态内部类不能引用外部类的private成员,只能使用外部类的静态属性和静态方法
    4.静态内部类相当于顶级类,抽象静态内部类与一般抽象类也没有什么不同
    用途: 与其他类一起放入一个外部类中,作为内部类,便于实现多重继承
    不推荐但可以: 内部类可以继承另一个内部类
     */
    static abstract class AInner {  // 抽象内部类一定要是static的,否则外部无法继承
        public abstract void showInner();
    }

    static abstract class AInner1 {  // 抽象内部类一定要是static的,否则外部无法继承
        public abstract void showInner1();
    }

    public abstract void show();
}

class B extends A {  // 抽象静态内部类模拟实现多重继承
    public void show() {
        System.out.println("ewk");
    }

    class BInner extends A.AInner {
        public void showInner() {
            System.out.println("ewkInner1");
        }
    }

    class BInner1 extends A.AInner1 {
        public void showInner1() {
            System.out.println("ewkInner2");
        }
    }

    public void showInner() {
        BInner b = new BInner();
        b.showInner();
    }

    public void showInner1() {
        BInner1 b1 = new BInner1();
        b1.showInner1();
    }
}

class C extends A.AInner {  // 相当于: 类名.静态成员
    public void showInner() {
        System.out.println("ewk");
    }
}

public class Main15静态抽象内部类与多重继承模拟 {
    public static void main(String[] args) {
        B b = new B();
        b.show();
        b.showInner();
        b.showInner1();
    }
}
