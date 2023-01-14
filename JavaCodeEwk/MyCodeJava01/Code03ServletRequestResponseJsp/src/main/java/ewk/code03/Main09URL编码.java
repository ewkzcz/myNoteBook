package ewk.code03;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Main09URL编码 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "张三";

        // 1.URL编码
        String encode = URLEncoder.encode(name,"utf-8");
        System.out.println(encode);

        // 2.URL解码
        String decode1 = URLDecoder.decode(encode,"utf-8");
        System.out.println(decode1);
        String decode2 = URLDecoder.decode(encode,"ISO-8859-1");  // tomcat get时的做法
        System.out.println(decode2);

        // 3.模拟解决tomcat解码乱码问题
        byte[] bytes = decode2.getBytes("ISO-8859-1");  // 将乱码显示的字符串转换为字节数组
        String s = new String(bytes,"utf-8");  // 将字节数组重新转换为字符串
        System.out.println(s);
    }
}
