package com.mitsuha;

/**
 * @ClassName Demo1
 * @Deacription
 *  0 1 2 3 4
 *  5 6 7 8 5
 *  4 3 4 9 6
 *  3 2 1 0 7
 *  2 1 0 9 8
 * @Author MitsuhaCon
 * @Date 2020/7/8 23:11
 **/
public class Demo1 {
    public static void test(int n) {

        int x = 0, y = 0;
        Integer[][] arr = new Integer[n][n];
        arr[x][y] = 0;
        int count = 1;
        int num = 1;
        while (num < n * n) {

            while (y + 1 < n && arr[x][y + 1] == null) {
                arr[x][++y] = count++;
                count = count > 9 ? 0 : count;
                num++;
            }

            while (x+1 < n && arr[x+1][y] == null) {
                arr[++x][y] = count++;
                count = count > 9 ? 0 : count;
                num++;
            }

            while (y > 0 && arr[x][y-1] == null) {
                arr[x][--y] = count++;
                count = count > 9 ? 0 : count;
                num++;
            }

            while (x > 0 && arr[x-1][y] == null) {
                arr[--x][y] = count++;
                count = count > 9 ? 0 : count;
                num++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test(5);
    }
}

