package ewk.code01.c04class;

class Father1{
    {
        System.out.println("构造代码块Father");
    }
    static {
        System.out.println("静态代码块Father");
    }
    Father1(){
        System.out.println("构造函数Father");
    }
}
class Son1 extends Father1{
    {
        System.out.println("构造代码块Son");
    }
    static {
        System.out.println("静态代码块Son");
    }
    Son1(){
        System.out.println("构造函数Son");
    }
}

public class Main08继承中父类子类的执行顺序 {
    public static void main(String[] args) {
        Son1 s1 = new Son1();
        /*
        静态代码块Father
        静态代码块Son
        构造代码块Father
        构造函数Father
        构造代码块Son
        构造函数Son
        ->
        销毁Son(包含销毁Father)
         */
    }
}
