package ewk.code01.c02string;

import java.io.*;
import java.util.Scanner;

public class Main05数据读取并搜索 {
    public static void main(String[] args) {
        try {
            InputStream fin = new FileInputStream("E:\\CodeJava\\MyCodeJava01\\Code01\\src\\ewk\\code01\\string\\data1.txt");
            Scanner sin = new Scanner(fin, "GBK");
            while (sin.hasNextLine()) {  // 是否还有下一行
                String str = sin.nextLine();
                /* indexOf
                int pos = str.indexOf("123");
                if (pos != -1) {
                    System.out.println(str);
                }
                */
                // contains
                boolean con = str.contains("123");
                if(con){
                    System.out.println(str);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
