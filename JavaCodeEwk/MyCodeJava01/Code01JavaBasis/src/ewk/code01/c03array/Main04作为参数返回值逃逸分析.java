package ewk.code01.c03array;

public class Main04作为参数返回值逃逸分析 {
    public static void main(String[] args) {
        // 1.数组作为参数: 能够影响外部
        int[] arr = new int[]{0, 0, 0};
        change(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println();

        // 2.数组作为返回值: return返回的是对象引用地址的值的一个"副本"
        int[] arr11 = getArr1();
        System.out.println(arr11);
        for (int i : arr11) {
            System.out.println(i);
        }
        int[] arr12 = getArr2();
        System.out.println(arr12);
        for (int i : arr12) {
            System.out.println(i);
        }
        // 2.1不同于String类，String由于实现了常量池 所以new和不new 有区别:
        // new的话，引用变量指向堆区。不new的话，引用变量指向常量池。
        // 2.2对于数组的定义，初始化时用new与不用new没区别，只是两种方式罢了，
        // 因为数组是引用数据类型，建立对象时，无论用不用new，数组实体都是放在堆内存中，引用变量放在栈内存。
        // 2.3还要考虑逃逸分析
        /*
        Java“逃逸分析”优化技术: 逃逸分析中有方法逃逸和线程逃逸
        方法逃逸: 就是当一个对象在方法中定义后,它可能被外部方法访问到,比如说通过参数传递到其它方法中
        线程逃逸: 就是当一个对象在方法中定义后,它可能赋值给其它线程中访问的变量
        如果不满足逃逸分析就会在栈上分配
        栈上分配的好处: 就是方法出栈后内存就释放了,不需要通过gc来进行垃圾回收
        总结: Java中的对象不一定是在堆上分配的,
        因为JVM通过逃逸分析,能够分析出一个新对象的使用范围,并以此确定是否要将这个对象分配到堆上
        */

        // 3.修改return的引用指向的值
        int[] arr2 = new int[]{1, 1, 1};
        System.out.println(arr2);
        int[] arr3 = getArr(arr2);
        System.out.println(arr3);
        arr3[0] = 2;
        for (int i : arr2) {
            System.out.println(i);
        }

        // 4.与return做对比
        int[] arr4 = {3,3,3};
        int[] arr5 = arr4;
        int[] arr6 = new int[]{4,4,4};
        int[] arr7 = arr6;
        System.out.println(arr4);
        System.out.println(arr5);
        System.out.println(arr6);
        System.out.println(arr7);
    }

    public static void change(int[] arr1) {
        arr1[0] = 1;  // arr1 = arr;
        // arr1为副本,arr1[0]为原本
    }

    public static int[] getArr1() {
        int arr[] = new int[]{1, 1, 1};
        System.out.println(arr);
        return arr;
    }

    public static int[] getArr2() {
        int arr[] = {2, 2, 2};  // 相当于int arr[] = new int[]{1, 1, 1};  // 满足逃逸分析
        System.out.println(arr);
        return arr;
    }

    public static int[] getArr(int arr[]) {
        System.out.println(arr);
        return arr;
    }
}
