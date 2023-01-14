package ewk.code01.c03array;

import javax.swing.*;

public class Main10JFrame数组 {
    public static void main(String[] args) {
        JFrame[] jFrames = new JFrame[3];  // 动态初始化
        // JFrame[] jFrames1 = new JFrame[]{new JFrame(),new JFrame(),new JFrame()};  // 静态初始化
        for(int i=0;i<3;i++){
            jFrames[i] = new JFrame("ewk");
            // jFrames[i].setTitle("ewk");
            jFrames[i].setSize(300,300);
            jFrames[i].setLocation(100,100);
            // jFrames[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrames[i].setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            jFrames[i].setVisible(true);
        }
    }
}
