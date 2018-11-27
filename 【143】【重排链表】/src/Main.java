/**
 * 原题要求：
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 思路：
 * 分三步走，第一步，将链表一分为二，用到快慢指针；第二步，反转第二部分，反转链表是很重要的根基；第三步，将两链表接起来。
 * 使用快慢指针将链表分成两段，采用这种方式会导致在链表结点个数为奇数的情况下，后半段的个数比前半段多一个。
 * 前半段一preSlow维结束，后半段一slow开始。所以在第三步将两子链表连接起来的时候，要注意判断反转以后以newBeg开始的后半段是否已经结束，没有，则连接上剩余部分即可。
 * 针对反转链表，要认真的理解，关键是反转以后，要在新的链表结尾加上next=NULL。
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-11-27 17:18
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) { // 链表中只有两个元素不需要操作
            return;
        }
        // 找到中节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转后一部分链表
        ListNode pre = slow.next; // 后半部分头结点为中间节点的下一个
        // 第一个链表节点个数是大于（奇数）或等于（偶数）第二个链表的
        slow.next = null; // 置空
        //反转后半部分链表
        pre = reverseList(pre);
        ListNode old = head; // 前半部分链表头部

        // 合并前后两个链表
        ListNode next1 = null; // 临时节点
        ListNode next2 = null;
        while (pre != null) {
            next1 = old.next; // 保存old的下一个节点
            next2 = pre.next; // 保存pre的下一个节点
            old.next = pre;  // 插入pre
            pre.next = next1;
            old = next1;  // old重新指向下一个节点
            pre = next2;  // pre重新指向下一个节点
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        System.out.println("初始链表：");
        print(n1);

        Solution solution = new Solution();
        solution.reorderList(n1); // 重排链表
        System.out.println("最终链表：");
        print(n1);
    }

    public static void print(ListNode head) {
        for (ListNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val + "->");
        }
        System.out.println("null");
    }
}
