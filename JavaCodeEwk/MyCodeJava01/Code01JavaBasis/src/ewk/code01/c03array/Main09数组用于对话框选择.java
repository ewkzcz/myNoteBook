package ewk.code01.c03array;

import javax.swing.*;

public class Main09数组用于对话框选择 {
    public static void main(String[] args) {
        Object[] valueArr = {"手机","电脑","平板"};
        Object value = JOptionPane.showInputDialog(null,"请选择","对话框",JOptionPane.INFORMATION_MESSAGE,
                null,valueArr,valueArr[0]);
    }
}
