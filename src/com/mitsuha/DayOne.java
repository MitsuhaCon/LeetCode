package com.mitsuha;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName day1
 * @Deacription //TODO
 * @Author MitsuhaCon
 * @Date 2020/6/17 19:08
 **/
public class DayOne {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int b = 9;
        System.out.println(Integer.valueOf(1233).toString().length());
    }

    private static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        int sum = 0, sumLeft = 0, sumRight = 0;
        for (int n : nums){
            sum = sum + n;
        }

        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                sumLeft = 0;
            } else {
                sumLeft = sumLeft + nums[i-1];
            }
            sumRight = sum - sumLeft - nums[i];
            if (sumLeft == sumRight){
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分法查找元素并
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int index;
        return ((index = Arrays.binarySearch(nums, target)) >= 0)? index : -index - 1;

    }

    public static int[][] merge(int[][] intervals) {
        //边界判断
        if (intervals.length <= 1) {
            return intervals;
        }

        //先按起点位置进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        //利用list存储合并好的区间
        List<int[]> result = new ArrayList<>();
        //初始时将第一个区间放入list中
        result.add(intervals[0]);
        //记录上一合并好的区间在list中的位置
        int last = 0;
        //遍历并合并后面各区间
        for (int i = 1; i < intervals.length; i++) {
            //上一合并好的区间的起点和终点
            int lastStart = result.get(last)[0];
            int lastEnd = result.get(last)[1];
            //当前要合并的区间的起点和终点
            int start = intervals[i][0];
            int end = intervals[i][1];
            //如果左边重合
            if (lastStart == start) {
                if (end > lastEnd) {
                    result.set(last, new int[] {start, end});
                }
            } else {    //如果左边不重合
                if (start > lastEnd) {
                    result.add(new int[] {start, end});
                    last++;
                } else {
                    if (end > lastEnd) {
                        result.set(last, new int[] {lastStart, end});
                    }
                }
            }
        }
        return result.toArray(new int[0][]);
    }

    /**
     * 股票最大收益  [7, 5, 4, 7, 6, 9 , 11],只交易一次
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        int tmpMax = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            for (int j = i + 1; j < prices.length; ++j) {
                if (prices[j] <= prices[i]) {
                    break;
                } else if (prices[j] > prices[i]) {
                    tmpMax = prices[j] - prices[i];
                    if (tmpMax > max) {
                        max = tmpMax;
                    }
                }
            }
        }
        return max;
    }

    /**
     *股票最大收益  只交易一次 [1,2,3,4,5,2,1,4]
     * @param prices
     * @return
     */
    public static int t(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    /**
     * 删除排序数组中的重复项
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int back = 0;
        for (int front = 1; front < nums.length; front++) {
            if (nums[back] != nums[front]) {
                back++;
                nums[back] = nums[front];
            }
        }
        return back + 1;
    }

    /**
     *股票最大收益 可多次交易 [7,1,5,3,6,4]
     * @param prices
     * @return
     */
    public static int maxProfitBuyMore(int[] prices) {
        //收益
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] >= prices[i + 1]) {
                continue;
            } else {
                profit = profit + prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    /**
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     *
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     *
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     *
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                list.add("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0){
                list.add("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }


    /**
     *   计数质数
     * 统计所有小于非负整数 n 的质数的数量。
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        int count;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n / 2; j++) {
                if (i % j == 0) {
                    break;
                } else {

                }

            }
        }
        return 0;
    }

    /**
     * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param a
     * @param b
     * @return
     */
    public static boolean rotateString(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        } else {
            return (a + a).contains(b);
        }
    }

    /**
     *  0 1 2 3 4
     *  5 6 7 8 5
     *  4 3 4 9 6
     *  3 2 1 0 7
     *  2 1 0 9 8
     * @param size
     */
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

    /**
     * 0 到 9 和  +  和  *
     */
    public static void printScanner() {

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap();
        for (int i = 0, length = nums.length; i < length; ++i) {
            hm.put(nums[i],i);
        }

        for (int i = 0, length = nums.length; i < length; ++i) {
            int a = target - nums[i];
            if ( hm.containsKey(a)) {
                return new int[] {i, hm.get(a)};
            }
        }
        return null;

    }
}
