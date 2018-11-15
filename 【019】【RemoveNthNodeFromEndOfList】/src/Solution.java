public class Solution {
    /**
     * <pre>
     *给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     *
     * 解题思路
     * 先让一个指针走找到第N个节点，然后再让一个指针指向头结点，然后两具指针一起走，
     * 直到前一个指针直到了末尾，后一个指针就是倒数第N+1个结点，删除倒数第N个结点就可以了。
     * </pre>
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null && head.next == null){
            return null;
        }

        ListNode pre = new ListNode(0); // 创建一个临时指针
        pre.next = head;
        ListNode slow = pre; // 慢指针
        ListNode fast = pre; // 快指针

        for(int i = 0; i < n; i++){  // 快指针先走n步，找到第n个结点
            fast = fast.next;
        }

        while(fast.next != null){ // 一起走
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return pre.next;
    }
}