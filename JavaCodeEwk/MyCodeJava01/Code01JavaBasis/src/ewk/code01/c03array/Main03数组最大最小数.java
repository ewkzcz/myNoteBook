package ewk.code01.c03array;

public class Main03数组最大最小数 {
    public static void main(String[] args) {
        int[] data = new int[]{1, 3, 2, 5, 4, 7, 6, 9, 8, 0};

        // 1.查找最大值
        int maxValue = data[0];
        for (int i : data) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        System.out.println("max=" + maxValue);
        System.out.println("max=" + getMax(data));

        // 2.查找最小值
        int minValue = data[0];
        for (int i : data) {
            if (i < minValue) {
                minValue = i;
            }
        }
        System.out.println("min=" + minValue);
    }

    // 函数化: 求数组最大值
    public static int getMax(int[] data) {
        if (data != null) {
            int maxValue = data[0];
            for (int i : data) {
                if (i > maxValue) {
                    maxValue = i;
                }
            }
            return maxValue;
        } else {
            System.out.println("空数组异常");
            return Integer.MAX_VALUE;
        }
    }
}
