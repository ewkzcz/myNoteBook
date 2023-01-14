package ewk.code01.c02string;

import java.util.Arrays;  // 排序sort

public class Main09hashCode {
    public static void main(String[] args) {
        String str1 = "zcz";
        String str2 = "zcz";
        String str3 = str2;
        String str4 = new String("zcz");
        String str5 = new String("zcz");
        String str6 = str5;

        // 内容决定hashCode,内容的唯一标识
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());
        System.out.println(str5.hashCode());
        System.out.println(str6.hashCode());

        // hashCode值由字符串字面值转换为整数而来,作为排序的依据
        String[] strArr = {"abc", "bcd", "abd", "cde"};
        Arrays.sort(strArr);
        for (String i : strArr) {
            System.out.println(i + " " + i.hashCode());
        }
    }
}
