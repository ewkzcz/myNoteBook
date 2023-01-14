package ewk.code01.c04class;

public class Main16访问权限 {
    public static void main(String[] args) {
        /*
        Java支持4种不同的访问权限:
        public: 对所有类可见。
        protected: 对同一包内可见+不同包子类可继承(而不能在子类中实例父类对象,调用其保护方法)。
        default(默认): 在同一包内可见，不使用任何修饰符。
        private: 在同一类内可见。

        访问控制和继承:
        父类中声明为 public 的方法在子类中也必须为 public。
        父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private。
        父类中声明为 private 的方法，不能够被子类继承。
        总结: public->protected->default->private(只要能继承,继承的权限不能降低)

        Java顶级类的访问权限:
        public: 所有类可见(所有public类/接口不能同名)
        default: 同包可见(同一个包中的default类/接口不能同名)

        Java内部类的访问权限:
        内部类可为静态，可用protected和private修饰。

        public类:
        一个文件中只能有一个public的类或接口，并且public的类名或接口名必须与文件名相一致(可以没有)

        主类(含有main):
        可以有多个,调用与文件名同名的类(如果文件中有public类,显然一定调用该类)

        关于Java源文件命名，通常有以下建议：
        一个 Java 源文件只定义一个类，不同的类使用不同的源文件定义。
        让 Java 源文件的主文件名与该源文件中定义的public类同名。
         */
    }
}
