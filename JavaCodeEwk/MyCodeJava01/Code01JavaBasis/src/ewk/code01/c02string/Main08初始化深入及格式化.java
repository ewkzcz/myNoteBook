package ewk.code01.c02string;

public class Main08初始化深入及格式化 {
    public static void main(String[] args) {
        String str1 = null;  // 不指向任何地址
        String str2 = "";  // 指向常量池上空串地址

        // 字符/字节数组初始化String
        char[] ch = {'a','b','c'};
        byte[] by = {65,66,67};
        String str3 = new String(ch);
        String str4 = new String(by);
        System.out.println(str3);
        System.out.println(str4);

        // 字符串格式化
        int num = 1;
        String str5 = String.format("凳子重量为%dkg",num);
        System.out.println(str5);
        String str6 = "张三";
        String str7 = String.format("%s你好",str6);
        System.out.println(str7);


    }
}
