package ewk.code01.c02string;

public class Main07切割及split {
    public static void main(String[] args) {
        String str1 = "Hello ewk zcz";
        String[] splitResult1 = str1.split(" ");
        for (String i : splitResult1) {
            System.out.println(i);
        }

        String str2 = "Hello|ewk|zcz";
        String[] splitResult2 = str2.split("\\|");  // split按照转义字符切割,必须插入\\
        for (String i : splitResult2) {
            System.out.println(i);
        }

        String str3 = "Hello_ewk_zcz";
        String[] splitResult3 = str3.split("_");
        for (String i : splitResult3) {
            System.out.println(i);
        }

        String str4 = "Hello,ewk,zcz";
        String[] splitResult4 = str4.split(",");  // split按照字符切割,必须插入\\
        for (String i : splitResult4) {
            System.out.println(i);
        }

        String str5 = "  Hello  ewk  zcz  ";
        System.out.println(str5.trim());  // 消除前后空格
    }
}
