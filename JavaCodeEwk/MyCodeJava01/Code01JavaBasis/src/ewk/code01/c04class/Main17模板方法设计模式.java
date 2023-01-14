package ewk.code01.c04class;

abstract class MyArray {
    public Object[] data;

    // 共同且繁琐的操作
    public void show() {
        System.out.println("ewk");
    }

    // 子类实现的方法
    abstract void sort();

    // 模板方法定义的框架
    public void get() {
        show();
        sort();
    }
}

class MyIntArray extends MyArray {
    MyIntArray(Object[] data) {
        this.data = data;
    }

    @Override
    void sort() {
        System.out.println("sortInt");
    }
}

class MyStringArray extends MyArray {
    MyStringArray(Object[] data) {
        this.data = data;
    }

    @Override
    void sort() {
        System.out.println("sortString");
    }
}

public class Main17模板方法设计模式 {
    public static void main(String[] args) {
        Object[] data1 = {1, 1, 1};
        Object[] data2 = {"zcz", "zcz", "zcz"};
        MyIntArray my1 = new MyIntArray(data1);
        MyStringArray my2 = new MyStringArray(data2);
        my1.get();
        my2.get();
    }
}
