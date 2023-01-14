package ewk.code01.c03array;

import java.util.Arrays;

public class Main07Java8Arrays常用方法 {
    public static void main(String[] args) {
        // 1.判断数组是否相等
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{1, 2, 3};
        int[] arr3 = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(Arrays.equals(arr1, arr3));

        // 2.copy数据(个数/范围)
        int[] arr4 = Arrays.copyOf(arr3, 6);
        for (int i : arr4) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 3.toString: 数组转换为字符串,便于查看数据
        int[] arr5 = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr5));

        // 4.fill
        int[] arr6 = new int[10];
        Arrays.fill(arr6, 100);  // 全部填充为100
        Arrays.fill(arr6, 0, 2, 200);  // 指定位置填充
        for (int i : arr6) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 5.sort
        int[] arr7 = new int[]{5, 7, 3, 4, 6, 2, 1, 1, 5};
        Arrays.sort(arr7);
        System.out.println(Arrays.toString(arr7));
        int[] arr8 = new int[]{5, 7, 3, 4, 6, 2, 1, 1, 5};
        Arrays.sort(arr8, 1, arr8.length);  // 指定位置排序
        System.out.println(Arrays.toString(arr8));

        // 6.binarySearch: 二分查找,必须是有序的数组
        int[] arr9 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.sort(arr9);
        System.out.println(Arrays.binarySearch(arr9, 1));
    }
}
