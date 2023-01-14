package ewk.code01.c04class;

final class FinalClass {  // final类不能继承

}

//class FinalClassSon extends FinalClass{  // final类不能继承
//
//}

class Father3 {
    final public void show() {  // final类方法不能重写

    }
}

class Son3 extends Father3 {
//    public void show() {  // final类方法不能重写
//
//    }
}

public class Main10final变量数组对象类及成员 {
    public String str1 = "Hello";
    public final String str2 = "Hello";
    // public final int num;  // final成员变量必须初始化

    public static void main(String[] args) {
        // 1.作用于基本数据类型
        final int num = 10;
        // num = 20;  // 只能读,不能写

        // 2.作用于数组
        final int[] arr = new int[]{1, 1, 1};
        arr[0] = 2;  // final数组元素可以改变
        // arr = null;  // final数组地址不能改变
        for (int i : arr) {
            System.out.println(i);
        }

        // 3.作用于对象
        final Main10final变量数组对象类及成员 m1 = new Main10final变量数组对象类及成员();
        m1.str1 = "ewk";  // final对象指向的内容可以改变
        // m1 = null;  // final对象的地址不能改变
        // m1.str2 = "ewk";  // final成员变量的地址不能改变

        // 4.作用于类: 不能继承

        // 5.作用于类成员函数: 不能重写

        // 6.作用于类成员变量: 必须初始化
    }
}
