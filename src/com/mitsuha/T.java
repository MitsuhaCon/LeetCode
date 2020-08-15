package com.mitsuha;



public class T {
    /**
     * is it the power of 2
     *
     * @param i origin data
     * @return true or false
     */
    private boolean x(int i) {
        int count = 0;
        while (true) {
            if ((i & 1) == 1) {
                if (++count > 1) {
                    return false;
                }
            }
            if ((i = i >> 1) == 0) {
                break;
            }
        }
        return true;
    }

    private boolean y(int i) {
        return (i & i - 1) == 0;
    }


    private static int z(int i) {
        int count = 0;
        while (true) {
            if ((i & 1) == 1) {
                ++count;
            }
            if ((i = i >>> 1) == 0) {
                break;
            }
        }
        return count;
    }
}
