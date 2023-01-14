package ewk.code01.c04class;

interface A1{
    void come1();
    // 低版本: 内部接口必须为static的
    // static interface B1{};
    interface B1{
        void come2();
    }
}

class C1 implements A1.B1 {

    @Override
    public void come2() {
        System.out.println("ewk");
    }
}

public class Main20内部接口 {
    public static void main(String[] args) {
        // 内部接口的实现
        C1 c = new C1();
        c.come2();

        // 与抽象内部类的一点不同: 低版本内部接口必须为static的,但现版本不需要static
    }
}
