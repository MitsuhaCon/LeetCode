package com.mitsuha;

import java.util.Arrays;

/**
 * @ClassName LaoLong
 * @Deacription //TODO
 * @Author MitsuhaCon
 * @Date 2020/7/9 8:49
 **/
public class LaoLong {
    public static void main(String[] args) {
        int x = 5;
        int y = 5;
        int arr[][] = new int[5][5];
        int k = 0;
        for (int i = 0; i < 19; i++) {
            if (i % 4 == 0) {
                int j = i / 4;
                for (int i2 = j; i2 < x - j; i2++) {
                    arr[j][i2] = k % 10;
                    k++;
                }
            }
            if (i % 4 == 2) {
                int j = i / 4;
                for (int i2 = j; i2 < x - j; i2++) {
                    arr[x - j - 1][x - i2 - 1] = k % 10;
                    k++;
                }
            }
            if (i % 4 == 1) {
                int j = i / 4;
                int tx = x - 1 - j;
                for (int i2 = j + 1; i2 < x - j - 1; i2++) {
                    System.out.println(tx + ":" + i2);
                    arr[i2][tx] = k % 10;
                    k++;
                }

            }
            if (i % 4 == 3) {
                int j = i / 4;
                int tx = j;
                for (int i2 = j + 1; i2 < x - j - 1; i2++) {
                    arr[x - i2 - 1][tx] = k % 10;
                    k++;
                }

            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
