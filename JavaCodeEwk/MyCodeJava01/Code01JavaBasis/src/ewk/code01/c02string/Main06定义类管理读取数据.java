package ewk.code01.c02string;

import java.io.*;
import java.util.Scanner;

// -Dfile.encoding=GBK

enum Study {硕士及以上, 大学, 高中, 初中, 小学及以下};

class Data {
    int id;
    String name;
    boolean sex;
    Study study;
    boolean isMarry;
}

public class Main06定义类管理读取数据 {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = new FileInputStream("E:\\CodeJava\\MyCodeJava01\\Code01\\src\\ewk\\code01\\string\\data2.txt");
        Scanner sc = new Scanner(in, "UTF8");
        sc.nextLine();  // 跳过第一行
        int lineNum = 0;
        Data[] data = new Data[100];

        while (sc.hasNextLine()) {
            // 读取数据
            String str = sc.nextLine();

            // 防止末尾空行
            if (str.length() == 0) {
                break;
            }

            // 解析数据
            Scanner scl = new Scanner(str);
            int id = scl.nextInt();
            String name = scl.next();
            String sexStr = scl.next();
            boolean sex;
            if (sexStr.equals("男")) {
                sex = true;
            } else if (sexStr.equals("女")) {
                sex = false;
            } else {
                break;
            }
            String studyStr = scl.next();
            Study study;
            if (studyStr.equals("硕士及以上")) {
                study = Study.硕士及以上;
            } else if (studyStr.equals("大学")) {
                study = Study.大学;
            } else if (studyStr.equals("高中")) {
                study = Study.高中;
            } else if (studyStr.equals("初中")) {
                study = Study.初中;
            } else if (studyStr.equals("小学及以下")) {
                study = Study.小学及以下;
            } else {
                break;
            }
            String isMarryStr = scl.next();
            boolean isMarry;
            if (isMarryStr.equals("已婚")) {
                isMarry = true;
            } else if (isMarryStr.equals("未婚")) {
                isMarry = false;
            } else {
                break;
            }

            // 类管理
            data[lineNum] = new Data();
            data[lineNum].id = id;
            data[lineNum].name = name;
            data[lineNum].sex = sex;
            data[lineNum].study = study;
            data[lineNum].isMarry = isMarry;

            // 行数加一
            lineNum++;
        }
        // 输出查看
        System.out.println("行数为" + lineNum);
        for (int i = 0; i < lineNum; i++) {
            System.out.print("id=" + data[i].id + " name=" + data[i].name + " sex=" + data[i].sex +
                    " study=" + data[i].study + " isMarry=" + data[i].isMarry + "\n");
        }
    }
}
