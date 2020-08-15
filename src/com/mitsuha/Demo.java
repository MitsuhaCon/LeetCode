package com.mitsuha;

/**
 * @ClassName Demo
 * @Deacription
 * @Author MitsuhaCon
 * @Date 2020/7/8 20:57
 **/
public class Demo {
    public static void printArray(int size) {
        int x = 0, y = 0;
        Integer[][] array = new Integer[size][size];
        array[x][y] = 0;
        // 0 - 9
        int count = 0;
        //总数
        int total = 1;
        while ( total < size * size) {
            //向右  x不动，y动
            while (y + 1 < size && array[x][y + 1] == null) {
                count = ++count > 9 ? 0 : count;
                array[x][++y] = count;
                total++;
            }
            //向下 x动，y不动
            while (x + 1 < size && array[x + 1][y] == null) {
                count = ++count > 9 ? 0 : count;
                array[++x][y] = count;
                total++;
            }
            //向左  x不动，y动
            while (y - 1 >= 0 && array[x][y - 1] == null) {
                count = ++count > 9 ? 0 : count;
                array[x][--y] = count;
                total++;
            }
            //向上 x动，y不动
            while (x - 1 >= 0 && array[x - 1][y] == null) {
                count = ++count > 9 ? 0 : count;
                array[--x][y] = count;
                total++;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printArray(5);
    }
}
