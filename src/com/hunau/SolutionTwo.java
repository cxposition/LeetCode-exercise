package com.hunau;

/**
 * @author cx
 * @Time 2020/4/24 13:33
 * @Description
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
