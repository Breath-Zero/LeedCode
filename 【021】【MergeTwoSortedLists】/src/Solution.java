class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    /**
     * <pre>
     * 原题
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 解题思路
     * 使用头结点root进行辅助操作，创建一个头结点，再使用两个引用指向两个链表的头结点，
     * 将较小的结点值的结点摘下来接到root链表的末尾，同时被摘的链头引用移动到下一个结点，
     * 一直操作，到到原先两个链表中有一个为空，最后再将剩下的结点接到root链表的末尾。
     * 最后返回root的下一个结点，其就为新的链表头。
     * </pre>
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode old = new ListNode(0);
        ListNode head = old;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            } else {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
        }
        if (l1 == null) { // l1为空的时候，有可能l2不为空，所以把剩下的l1链接
            head.next = l2;
        }
        if (l2 == null) {// l2为空的时候，有可能l1不为空，所以把剩下的l2链接
            head.next = l1;
        }
        return old.next;
    }
}
