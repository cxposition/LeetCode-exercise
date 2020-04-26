package com.hunau;

/**
 * @author cx
 * @Time 2020/4/24 13:33
 * @Description 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：

 * 给定的 n 保证是有效的。
 */


public class SolutionTwo {
    public ListNode removeNthFromEnd(ListNode head,int n)
    {
        /**用来统计节点数*/
        int k = 0;
        /**声明一个哑结点方便删除操作*/
        ListNode dummy = new ListNode(0);
        /**声明一个指针初始化指向哑结点*/
        ListNode point = dummy;
        /**哑结点指向首节点*/
        dummy.next = head;
        /**便利统计节点的数量*/
        while (point.next != null)
        {
            point = point.next;
            k++;
        }
        /**让指针初始化到原来的位置*/
        point = dummy;
        /**移动指针到被删除节点的前面一位*/
        for (int i = 0;i < k - n;i++)
        {
            point = point.next;
        }
        /**将选中的节点删除*/
        point.next = point.next.next;
        return dummy.next;
    }
}
