package ewk.code01.c03array;

public class Main12获取类型名getClass {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 1, 1};
        char[] arr2 = new char[]{'A', 'B', 'C'};
        float[] arr3 = new float[]{1.1f, 2.2f, 3.3f};
        double[] arr4 = new double[]{1.1, 2.2, 3.3};
        String str = "Hello";
        int[][] arrRow = {{1, 1, 1}, {2, 2}, {3, 3, 3, 3}};
        System.out.println(arr1.getClass());  // 打印数组名称,或为getClass().toString()
        System.out.println(arr2.getClass());
        System.out.println(arr3.getClass());
        System.out.println(arr4.getClass());  // [一维数组
        System.out.println(str.getClass());
        System.out.println(arrRow.getClass());  // [[二维数组

        // 2.getClass不能获取基本数据类型的类名,可以获取数组名及类名
        int num = 10;
        // System.out.println(num.getClass());
    }
}
