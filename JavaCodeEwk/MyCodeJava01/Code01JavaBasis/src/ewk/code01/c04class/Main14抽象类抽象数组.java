package ewk.code01.c04class;

class Life {

}

abstract class Animal extends Life {
    public abstract void show();
    // protected abstract void show();
    // abstract void show();
}

class Tiger extends Animal {
    @Override
    public void show() {
        System.out.println("Tiger");
    }
}

class Dog extends Animal {
    @Override
    public void show() {
        System.out.println("Dog");
    }
}

public class Main14抽象类抽象数组 {
    public static void main(String[] args) {
        /* 抽象类特点
        1.抽象类及抽象方法用abstract修饰
        2.抽象类不一定有抽象方法,有抽象方法的类一定为抽象类或接口
        3.抽象类不能实例化,由子类进行实例化(抽象类多态)
        4.抽象类的子类要么是抽象子类要么必须实现抽象方法
        其他:
        1.abstract不能修饰: 成员变量,私有方法(无法被继承,矛盾),构造方法,静态方法(没有意义),final方法(不能继承,矛盾)
        2.抽象类的父类无限制
         */

        // Animal animal = new Animal();
        Animal[] animals = new Animal[10];  // 抽象数组是可以定义的
    }
}
