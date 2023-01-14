package ewk.code01.c04class;

// Father类: 此处只能为包访问权限
class Father {  // 包访问权限: 同一个包中均可以继承或使用该类
    public int num1;
    private int num2;
    protected int num3;
    int num4;

    public void show() {
        System.out.println("Father");
    }
}

class Son extends Father {
    public void check() {
        System.out.println(num1);  // 或this.num1
        // System.out.println(num2);  // 子类无法直接使用父类私有成员变量
        System.out.println(num3);
        System.out.println(num4);
    }

    public void show() {
        System.out.println("Son");
    }

    public void superShow() {
        super.show();
    }
}


public class Main07继承及super {
    public static void main(String[] args) {
        // 1.java不支持多继承
        Son s1 = new Son();
        s1.check();

        // 2.子类重写父类函数,子类调用父类同名函数
        s1.show();
        s1.superShow();  // supper关键字只能在子类中使用
    }
}
