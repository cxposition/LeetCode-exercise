package com.hunau;

/**
 * @author cx
 * @Time 2020/4/26 23:35
 * @Description 拆分链表
 */
public class SolutionThree {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
        public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode cur = root;
            int N = 0;
            while (cur != null) {
                cur = cur.next;
                N++;
            }

            int width = N / k, rem = N % k;

            ListNode[] ans = new ListNode[k];
            cur = root;
            for (int i = 0; i < k; ++i) {
                ListNode head = cur;
                for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                    if (cur != null) cur = cur.next;
                }
                if (cur != null) {
                    ListNode prev = cur;
                    cur = cur.next;
                    prev.next = null;
                }
                ans[i] = head;
            }
            return ans;
        }
    }


