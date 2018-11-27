/**
 * 原题要求：
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，
 * 这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * <p>
 * 思路：
 * 这里我的思路就是利用分成两个链表，然后分别把位置为奇数的归一类，把位置为偶数的归为一类。
 * 最后把位置为偶数的链表接在位置为奇数链表的后面。
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-11-27 17:48
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode first = head; // 奇数链表头结点
        ListNode second = head.next; // 偶数链表头结点
        ListNode temp = second;
        while(second != null && second.next != null){
            first.next = second.next;
            first = first.next;
            second.next = first.next;
            second = second.next;
        }
        // 合并奇偶链表
        first.next = temp;
        return head;
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
        System.out.println("最终链表：");
        print(solution.oddEvenList(n1));
    }

    public static void print(ListNode head) {
        for (ListNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val + "->");
        }
        System.out.println("null");
    }
}

