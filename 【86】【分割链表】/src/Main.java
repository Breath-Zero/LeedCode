/**
 * 题目要求：
 * <p>
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 解题思路：
 * 创建两个链表a，b，将原来链表中的每个结点，小于等于x的结点放在a链表的末尾，如果是大于就放在b的
 * 末尾，最后将b的头结点接到a末尾。
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution1 {
    public ListNode partition(ListNode head, int x) {

        ListNode min = new ListNode(0); // 小于x的链表
        ListNode max = new ListNode(0); // 大于等于x的链表
        ListNode t1 = min;
        ListNode t2 = max;
        ListNode p = head;

        while (p != null) {
            if (p.val < x) { // 如果该节点值比 x 小，就放在min链表中
                t1.next = p;
                t1 = p;
            } else { // 如果该节点值比 x 大，就放在max链表中
                t2.next = p;
                t2 = p;
            }
            p = p.next;
        }

        t2.next = null; // 让数值大的链表最后指向空

        // 说明小于的链表上有数据
        if (t1 != min) {
            t1.next = max.next;
            return min.next;
        } else {
            return max.next;
        }
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
        System.out.println("最终链表：");
        print(solution.partition(n1, 4));
    }

    public static void print(ListNode head) {
        for (ListNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val + "->");
        }
        System.out.println("null");
    }
}
