package ewk.code01.c04class;

abstract class Animal1 {
    abstract void show1();

    abstract void show2();
}

interface Animal2 {  // interface = 只有抽象成员的abstract class
    /* 接口只能有抽象方法和常量值
    接口中的方法默认为public abstract的
    abstract void show1();
    abstract void show2();
    void show3(){

    }
    */
    void show1();

    void show2();

    /* 接口中的数据默认为常量,常量值必须初始化
    int num;
    final int num = 10;
     */
    int num = 10;
}

interface Animal3 {
}

class Tiger2 implements Animal2, Animal3 {

    @Override
    public void show1() {  // 实现接口中的方法,必须为public的
        System.out.println("Hello1");
    }

    @Override
    public void show2() {
        System.out.println("Hello2");
    }
}

public class Main18接口与多重实现 {
    public static void main(String[] args) {
        /*
        接口不能实例化
        实现接口中的方法,必须为public的
        接口用于弥补多重继承的缺失,一个类可以实现多个接口
         */

        // 接口数组可以被创建
        Animal2[] animal2s = new Animal2[10];

        // 接口地址 存储 实现接口的类的对象,并调用子类重写的方法
        Animal2 animal2 = new Tiger2();
        animal2.show1();
    }
}
