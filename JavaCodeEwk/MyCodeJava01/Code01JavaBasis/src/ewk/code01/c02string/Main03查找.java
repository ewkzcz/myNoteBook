package ewk.code01.c02string;

public class Main03查找 {
    public static void main(String[] args) {
        // length
        String str = "你好啊123ewk123";
        System.out.println(str.length());  // 长度,一个中文字符记为1

        // charAt
        System.out.println(str.charAt(1));  // 查找指定位置的一个字符
        // System.out.println(str[0]);  // 不能下标访问

        // indexOf: 查找指定字符串/字符在指定位置第一次出现的位置,找不到返回-1
        System.out.println(str.indexOf("123", 1));

        // 循环查找字符串
        for (int pos = 0; pos != -1; pos = str.indexOf("123", pos)) {
            if (pos == 0 && str.indexOf("123", pos) == 0) {
                System.out.print(pos + " ");
            } else if (pos != 0) {
                System.out.print(pos + " ");
            }
            pos += "123".length();
        }
        System.out.println();

        // lastIndexOf: 指定字符在指定范围内的最后一次出现,反向搜索

        // substring: 查找指定位置上的字符串,越界时报错
        String str1 = "123你好啊123ewk123hhh123";
        System.out.println(str1.substring(3,9));  // begin to end-1
        // System.out.println(str1.substring(30));

        // contains: 是否包含子串
        String str2 = "123zcz";
        String str3 = "zcz";
        System.out.println(str2.contains(str3));

        // startsWith: 是否以子串为开头
        String str4 = "123";
        System.out.println(str2.startsWith(str4));
    }
}
