package ewk.code01.c01prepare;

import java.util.Scanner;

public class Main02Scanner类与控制台乱码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // 创建扫描器,初始化在控制台System.in
        System.out.println("请输入数据:");
        String str = sc.nextLine();  // 获取输入数据
        System.out.println(str);

        // system.out.println中存在中文时,控制台乱码问题
        // 1.控制台左侧绿色三角形下方扳手符号
        // 2.添加VM选项
        // 3.-Dfile.encoding=GBK

        // 输出控制台编码
        System.out.println(System.getProperty("file.encoding"));
    }
}
