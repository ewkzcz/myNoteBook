package ewk.code01.c03array;

public class Main11二维数组三维数组 {
    public static void main(String[] args) {
        // 静态初始化,锯齿数组
        int[][] arr1 = {{1, 1, 1, 1}, {2, 2, 2}, {3, 3, 3, 3, 3}};
        int[][] arr2 = new int[][]{{1, 1, 1, 1}, {2, 2, 2}, {3, 3, 3, 3, 3}};

        // 动态初始化,矩阵数组
        int[][] arr3 = new int[2][3];  // 2行3列
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                arr3[i][j] = 1;
            }
        }

        // 动态初始化,锯齿数组(有规则形状的)
        int[][] arr4 = new int[9][];  // 2行
        for (int i = 0; i < 9; i++) {
            arr4[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                arr4[i][j] = i + 1;
            }
        }

        // 遍历二维数组
        System.out.println("rowNumber = " + arr1.length);
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
        for (int[] row : arr1) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        for (int[] row : arr4) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

        // 三维数组
        int[][][] data = { {{1,1,1},{2,2},{3,3,3}},
                {{1,1},{2,2,2},{3,3,3,3}},
                {{1,1,1},{2,2},{3,3,3}} };
        System.out.println();
        for(int[][] sheet:data){
            for(int[] row:sheet){
                for(int item:row){
                    System.out.print(item+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
