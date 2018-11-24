/**
 * 原题要求：
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 思路：
 * 创建两个指针一个每次走两步，一个每次走一步，若单链表带环，则在第一个指针不会找到尾节点，
 * 而且第一个会在环内已知循环知道和第二个指针相遇才能退出循环，同时返回这个节点位置；
 * 若带环则让快指针指向头结点，然后让两个指针同时走，一次一个节点，当二者相遇时，相遇点就是节点入口。
 *
 * @ClassName: Main
 * @Description: TODO
 * @Author: Mr.Ye
 * @Data: 2018-11-24 18:47
 * @Version: 1.0
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next ==null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){ // 判断是否有环
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){ // 代表有环
                fast = head; // 改变快指针的指向，让其指向头结点
                while(fast != slow){ // 两指针同时走，相遇点为节点入口
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
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
        n6.next = n4;

        Solution solution = new Solution();
        System.out.println(solution.detectCycle(n1).val); // 该链表有环
    }

    public static void print(ListNode head) {
        for (ListNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val + "->");
        }
        System.out.println("null");
    }
}


