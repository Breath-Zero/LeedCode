/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 解题思路
 * 先找到第一个要反转的元素的前驱（prev），再计算要进行反转的元素个数，对元素进行头插法，
 * 插在prev后面，同时保持链表不断开。
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution1 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode old = new ListNode(0);
        old.next = head;

        ListNode pre = old;
        for (int i = 0; i < m - 1; ++i) {
            pre = pre.next;
        }
        ListNode temp = pre;
        pre = temp.next;

        ListNode cur = pre.next;
        for (int i = m; i < n; ++i) {
            pre.next = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            cur = pre.next;
        }
        return old.next;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        System.out.println("初始链表：");
        print(n1);

        Solution1 solution = new Solution1();
//        Solution solution = new Solution();
        System.out.println("最终链表：");
        print(solution.reverseBetween(n1, 2, 4));
    }

    public static void print(ListNode head) {
        for (ListNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val + "->");
        }
        System.out.println("null");
    }
}