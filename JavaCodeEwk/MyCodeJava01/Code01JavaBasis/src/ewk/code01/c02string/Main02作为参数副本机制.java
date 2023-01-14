package ewk.code01.c02string;

public class Main02作为参数副本机制 {
    String mystr = "123";

    public static void main(String[] args) {
        // 字符串作为参数无法改变值
        String str = "123";
        change(str);
        System.out.println(str);

        // 字符串作为参数可以改变值
        Main02作为参数副本机制 m = new Main02作为参数副本机制();
        System.out.println(m.mystr);
        change1(m);
        System.out.println(m.mystr);
    }

    public static void change(String cstr) {
        cstr = "Hello";  // 副本机制: cstr = str;cstr = "Hello";
        // cstr的地址改变了,但是str的地址没有被改变
    }

    public static void change1(Main02作为参数副本机制 cm) {
        cm.mystr = "Hello";
        // cm与m引用了相同的地址: cm = m;
        // cm.mystr = "Hello";  // 间接传入mystr,不再有副本机制,cm.mystr指向"Hello"常量池地址
    }
}
