package ewk.code01.c02string;

public class Main01不可变equals及intern {
    public static void main(String[] args) {
        // 1.String是不可变对象
        // 常量区
        String str1 = "abc";
        str1 = "123";  // 浅拷贝
        // str1[0] = "H";  // 字符串为不可变对象,值不可变,但指向的对象可以改变
        System.out.println(str1);

        String str2 = "Hello";
        String str3 = "Hello";  // 直接赋值常量字符串,放入常量池中,地址相同
        System.out.println(System.identityHashCode(str2));
        System.out.println(System.identityHashCode(str3));
        System.out.println(str2 == str3);

        // 堆区
        char[] ch = {'a', 'b', 'c'};
        String str4 = new String(ch);
        String str5 = new String(ch);  // 构造方法得到对象,地址不同
        System.out.println(System.identityHashCode(str4));
        System.out.println(System.identityHashCode(str5));
        System.out.println(str4 == str5);

        // 2.String的比较
        // ==比较: 基本类型比较值,引用类型比较地址(String类为引用类型)
        // equals: 用于String类型内容的比较
        System.out.println(str2.equals(str3));
        System.out.println(str4.equals(str5));

        // 3.intern()
        System.out.println(str2.intern() == str2);  // str1.intern()返回一个常量字符串池的引用地址
        System.out.println(str2.intern() == str3);
        System.out.println(str2.intern() == str4);
        System.out.println(str4.intern() == str4);

        String str6 = new String("zcz").intern();  // 转入常量区,节约堆区
        System.out.println(str6.intern() == str6);

        // 4.new和不new的区别
        // 4.1 String由于实现了常量池 所以new和不new有区别:
        // new的话，引用变量指向堆区。不new的话，引用变量指向常量池。
        // 4.2 对于数组的定义，初始化时用new与不用new没区别，只是两种方式罢了，
        // 因为数组是引用数据类型，建立对象时，无论用不用new，数组实体都是放在堆内存中，引用变量放在栈内存。
    }
}
