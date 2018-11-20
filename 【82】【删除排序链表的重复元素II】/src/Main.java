/**
 * 原题要求
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 思路：
 * h -> 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
 * pre   cur
 *
 * 我们始终要让pre在cur的前面，通过判断cur.val == cur.next.val判断重复元素是否存在。
 * h -> 1 -> 2    3    3    4 -> 4 -> 5
 *            |              |
 *            ----------------
 *           pre            cur
 * 如果存在重复元素的话，我们pre.next=cur.next;cur=cur.next，如果不存在重复元素，
 * 我们pre=cur;cur=cur.next，所以这里我们要通过一个变量标记是否存在重复元素。
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-11-20 22:53
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
        ListNode old = new ListNode(0);
        old.next = head;
        ListNode pre = old;
        ListNode cur = head;
        while(cur != null){
            int flag = 0;
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
                flag = 1;
            }
            if(flag == 0){
                pre = cur;
            }else{
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return old.next;
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
        ListNode n7 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
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
