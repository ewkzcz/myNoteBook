package ewk.code01.c03array;

public class Main06数组缺陷和长度固定 {
    public static void main(String[] args) {
        // 1.数组初始化时,长度可以为变量
        int num = 10;
        int[] arr1 = new int[num];

        // 2.数组一但初始化,长度不可变
        int[] arr2 = new int[]{1, 1, 1};
        // arr2[3] = 1;

        // 3.数组长度变长的替代方法
        int[] arr3 = new int[]{1, 1, 1};
        int[] arr4 = new int[arr3.length + 1];
        for (int i = 0; i < arr3.length; i++) {
            arr4[i] = arr3[i];
        }
        arr4[arr3.length] = 1;
        arr3 = arr4;
        // 此时arr3长度由3间接变为4
        for (int i : arr3) {
            System.out.println(i);
        }

        // 4.数组的缺陷
        // 插入,长度不可变,删除
    }
}
