package ewk.code01.c04class;

class Coder {
    public void show() {
        System.out.println("Coder");
    }
}

class JavaCoder extends Coder {
    public void show() {
        System.out.println("JavaCoder");
    }
}

class CCoder extends Coder {
    public void show() {
        System.out.println("CCoder");
    }
}

public class Main13父类地址存储任何子类对象与多态 {
    public static void main(String[] args) {
        Object obj;
        obj = new Coder();
        obj = new JavaCoder();
        obj = new CCoder();

        // 父类地址可以存储任何子类对象
        Coder coder;
        coder = new JavaCoder();
        coder.show();
        coder = new CCoder();
        coder.show();
    }
}
