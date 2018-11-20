/**
 * 原题要求
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 思路：
 * 遍历链表，如果pre和cur的val相同的话pre.next = cur.next，然后cur = cur.next。
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-11-20 22:41
 **/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head;
        while(cur != null){
            pre = cur;
            cur = cur.next;
            while(cur != null && cur.val == pre.val){
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
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

        Solution solution = new Solution();
        System.out.println("最终链表：");
        print(solution.deleteDuplicates(n1));
    }

    public static void print(ListNode head) {
        for (ListNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val + "->");
        }
        System.out.println("null");
    }
}