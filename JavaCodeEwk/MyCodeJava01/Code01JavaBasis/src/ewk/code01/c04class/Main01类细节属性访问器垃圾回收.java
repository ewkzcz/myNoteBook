package ewk.code01.c04class;
// -Dfile.encoding=GBK

class Person {
    private String name;
    private int num = 10;

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }
}

public class Main01类细节属性访问器垃圾回收 {
    public static void main(String[] args) {
        // 1.成员变量初值: 第一步(初始化为默认值),第二步(显式初始化),第三步(返回对象引用)
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1.getName());
        System.out.println(p2.getName());
        System.out.println(p1.getNum());
        System.out.println(p2.getNum());  // 初始值: 默认值或显式初始化值

        // 2.引用类型
        p1.setName("张三");
        p2.setName("李四");
        p1 = p2;
        System.out.println(p1.getName());
        System.out.println(p2.getName());

        // 3.属性访问器:
        // 类名上右键-生成-get和set

        // 4.构造方法可以重载为普通函数

        // 5.对象地址
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));  // p1,p2地址相同,equals方法可以重载

        // 6.this调用构造方法:
        // 必须放在首行,只能是另一个构造方法(不能是成员方法:成员方法被调用时,初始化应该已完成),不能死循环调用

        // 7.垃圾回收机制: 自动回收不再被任何变量引用的内存
        // 回收机制只是对Java虚拟机的通知,回收时时机不明确
        // 回收机制由类的finalize函数实现,已弃用
        String str1 = new String("Hello");
        String str2 = new String("zcz");
        str2 = str1;  // "zcz"的内存失去引用,将会被回收
        str1 = null;
        str2 = null;  // "Hello"的内存失去引用,将会被回收
        // System.gc();  // 通知JVM进行垃圾回收,不建议
    }
}
