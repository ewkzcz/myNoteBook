package ewk.code01.c03array;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class Main08Arrays并发计算 {
    public static void main(String[] args) {
        // 1.并发排序
        int[] arr1 = new int[10];
        for (int i = 0; i < 10; i++) {
            arr1[i] = (int) (Math.random() * 10);
        }
        Arrays.parallelSort(arr1);  // 并发排序
        System.out.println(Arrays.toString(arr1));

        // 2.相邻计算
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {  // left当前元素的左侧元素,right当前元素
                return left * right;
            }
        });
        System.out.println(Arrays.toString(arr2));

        // 3. 每个元素计算,自动排序
        int[] arr3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Arrays.parallelSetAll(arr3, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand * 2;
            }
        });
        System.out.println(Arrays.toString(arr3));
    }
}
