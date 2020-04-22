package com.hunau;

/**
 * @author cx
 * @Time 2020/4/22 12:26
 * @Description /**
 *   Definition for singly-linked list.
 *   public class ListNode {
 *       int val;
 *       ListNode next;
 *       ListNode(int x) { val = x; }
 *   思路:先画图，然后确定本题需要四个指针，基数列的头指针，偶数列的头指针，基数指针，偶数指针四个指针
 *   根据指针的相互关系确定指针的移动，最后将偶数链表拼接在奇数链表的后面
 *   注意：指针可以指向空 null 注意while判断中的条件
 *
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        /**将偶数链表拼接在基数链表的后面*/
        odd.next = evenHead;
        return head;
    }
}
