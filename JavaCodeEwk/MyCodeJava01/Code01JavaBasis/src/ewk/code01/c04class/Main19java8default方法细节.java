package ewk.code01.c04class;

interface Animal4 {
    default void show() {
        System.out.println("ewk1");
    }

    void get();
}

interface Animal5 {
    /*
    default void show() {
        System.out.println("ewk2");
    }
     */
    void get();
}

class Tiger3 implements Animal4, Animal5 {

    @Override
    public void get() {

    }
}

interface Animal6 extends Animal4, Animal5 {

}

public class Main19java8default方法细节 {
    public static void main(String[] args) {
        /* 接口细节
        1.default方法
        Java8以前: 接口不能有非抽象方法,只能有抽象方法
        Java8中可以用default定义非抽象方法,不能省略
        2.类实现多个接口时的冲突问题
        一个类实现多个接口时: 不同接口中可以有同名的抽象方法,但是不能有同名的default方法
        3.接口可以继承多个接口
        一个接口继承另一个接口,需要使用extends关键字,而不是implements.
        一个接口可以同时继承多个接口
        4.接口不允许继承类
         */
    }
}
