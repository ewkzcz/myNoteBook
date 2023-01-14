package ewk.code01.c02string;

public class Main04大小写转换及拼接 {
    public static void main(String[] args) {
        // 1.大小写转换
        String str = "abcABC";
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());

        // 2.字符串拼接
        String str1 = "123";
        String str2 = "hello";
        System.out.println(str1+str2);
        System.out.println(str1.concat(str2));

        // 3.首字母大写
        String str3 = str.substring(0,1).toUpperCase().concat(str.substring(1));
        System.out.println(str3);
    }
}
