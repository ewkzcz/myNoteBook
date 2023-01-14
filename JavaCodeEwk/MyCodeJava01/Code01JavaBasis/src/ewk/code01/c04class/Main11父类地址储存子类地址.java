package ewk.code01.c04class;

class Father4 {
    public void show(){
        System.out.println("Father");
    }
}

class Son4 extends Father4{
    public void show(){
        System.out.println("Son");
    }
}

public class Main11父类地址储存子类地址 {
    public static void main(String[] args) {
        Father4 f = new Son4();  // 父类地址可以储存子类对象,子类地址不能储存父类对象
        f.show();  // 父类地址存储子类对象,也遵循覆写原则

        Son4 s = (Son4)f;  // 下转: 将父类地址强制转换为子类地址
        s.show();

        Son4 s1 = new Son4();
        Father4 f1 = (Father4)s1;  // 上转型对象,父类地址存储的仍然是子类对象
        f1.show();
    }
}
