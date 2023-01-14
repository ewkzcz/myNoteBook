package ewk.code01.c03array;

public class Main02数组深浅拷贝 {
    public static void main(String[] args) {
        // 1.数组直接赋值: 浅拷贝
        int[] arr1 = new int[]{1, 1, 1};
        int[] arr2 = arr1;
        arr2[0] = 2;
        for (int i : arr1) {
            System.out.println(i);
        }

        // 2.数组深拷贝: 不直接赋值,使用new首先开辟新空间
        int[] arr3 = new int[]{1, 1, 1};
        int[] arr4 = new int[]{arr3[0], arr3[1], arr3[2]};
        arr4[0] = 2;
        for (int i : arr3) {
            System.out.println(i);
        }
    }
}
