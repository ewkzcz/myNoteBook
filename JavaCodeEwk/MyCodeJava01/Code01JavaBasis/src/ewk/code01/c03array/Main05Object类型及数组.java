package ewk.code01.c03array;

public class Main05Object类型及数组 {
    public static void main(String[] args) {
        // 1.Object类型(万用类型/种子类型)
        Object ob1 = 123;
        Object ob2 = 123.123;
        Object ob3 = "Hello";
        Object ob4 = 'A';
        ob1 = 123.123;  // 在低版本JDK不成立
        ob2 = "Hello";
        ob3 = 'A';
        ob4 = 123;
        System.out.println(ob1);
        System.out.println(ob2);
        System.out.println(ob3);
        System.out.println(ob4);

        // 2.Object数组
        Object[] arrOb = new Object[]{123, 123.123, "Hello", 'A'};
        for (Object i : arrOb) {
            System.out.println(i);
        }
        Object arrOb1 = new String[]{"123", "123"};
        // Object arrOb1 = new String[]{"123", 123};
        Object arrOb2 = new int[]{1, 1, 1};  // 对于基本数据类型,在低版本JDK不成立
        Object arrOb3 = new Integer[]{1, 1, 1};  // 上例不成立时的替代方案
    }
}
