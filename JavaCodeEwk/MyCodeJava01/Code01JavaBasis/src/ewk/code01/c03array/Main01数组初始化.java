package ewk.code01.c03array;

public class Main01数组初始化 {
    public static void main(String[] args) {
        // 1.动态初始化方式1
        int[] data1;  // 推荐格式,只完成了声明还未初始化
        // data1 = {1, 1, 1, 1, 1 };
        // data1[0] = 1;  //未初始化,此时必须先用new进行初始化,才能使用
        data1 = new int[]{1, 1, 1, 1, 1};  // 声明和赋值分开写,必须添加new int[]
        // int data2[];  // 不推荐格式

        // 2.动态初始化方式2: 系统分配初始值,垃圾回收器空闲时回收
        int[] arr1 = new int[3];
        System.out.println(arr1);  // 输出数组名
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr1[2]);

        // 数组是引用类型: 将一个数组赋值给另一个数组
        int[] arr2 = arr1;
        arr2[0] = 1;
        arr2[1] = 1;
        arr2[2] = 1;
        System.out.println(arr2);
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
        System.out.println(arr2[2]);
        System.out.println(arr1);
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr1[2]);

        // 3.静态初始化
        int[] arr3 = new int[]{1, 1, 1};

        // 4.静态初始化
        int[] arr4 = {1, 1, 1};
        // 4.1不同于String类，String由于实现了常量池,所以new和不new有区别:
        // new的话，引用变量指向堆区。不new的话，引用变量指向常量池。
        // 4.2对于数组的定义，初始化时用new与不用new没区别，只是两种方式罢了，
        // 因为数组是引用数据类型，建立对象时，无论用不用new，数组实体都是放在堆内存中，引用变量放在栈内存。
        // 4.3逃逸分析: 不满足逃逸分析,内存优化在栈区
        /*
        Java“逃逸分析”优化技术: 逃逸分析中有方法逃逸和线程逃逸
        方法逃逸: 就是当一个对象在方法中定义后,它可能被外部方法访问到,比如说通过参数传递到其它方法中
        线程逃逸: 就是当一个对象在方法中定义后,它可能赋值给其它线程中访问的变量
        如果不满足逃逸分析就会在栈上分配
        栈上分配的好处: 就是方法出栈后内存就释放了,不需要通过gc来进行垃圾回收
        总结: Java中的对象不一定是在堆上分配的,
        因为JVM通过逃逸分析,能够分析出一个新对象的使用范围,并以此确定是否要将这个对象分配到堆上
        */

        // 5.数组的常见问题
        // 索引越界
        // 空指针(null)异常

        // 6.数组未经赋值默认值
        // int 0
        // double 0.0
        // char 编号为0的字符,即空白
        // boolean false
        // String null
        // class null
    }
}