package ewk.code05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main03验证码工具类使用 {
    public static void main(String[] args) throws IOException {
        OutputStream fos = new FileOutputStream("E:\\CodeJava\\MyCodeJava01\\"+
                "Code05\\src\\main\\java\\ewk\\code05\\result.jpg");
        String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, fos, 4);
        System.out.println(checkCode);
    }
}
