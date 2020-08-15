package com.mitsuha.twoadd;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ListNode
 * @Deacription //TODO
 * @Author MitsuhaCon
 * @Date 2020/7/14 17:35
 **/
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0;
        int b = 0;
        int result = 0;
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        ListNode tmpNode = null;
        ListNode resultNode = null;
        while ((tmpNode = l1.next) != null) {
            list1.add(l1.val);
        }
        while ((tmpNode = l2.next) != null) {
            list2.add(l2.val);
        }
        for (int len = list1.size(), i = len -1; i > 0; --i) {
            a += list1.get(i) * Math.pow(10, len -1);
        }
        for (int len = list2.size(), i = len -1; i > 0; --i) {
            b += list1.get(i) * Math.pow(10, len -1);
        }
        result = a + b;
        int length = Integer.valueOf(result).toString().length();
        for (int i = length - 1; i >= 0; ++i) {
            //int val = result % Math.pow(10, i);
            //tmpNode = new ListNode(val);
            resultNode.next = tmpNode;
        }
        return resultNode;
    }
}
