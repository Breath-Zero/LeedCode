/**
 * 原题要求：
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * 思路：
 * 递归：每次对头进行判断是否此值等于给定值val，如果相等则将此节点删除，将下一个节点作为头节点递归调用自己，
 * 否则将此节点的下一个节点为作为头节点递归调用自己，调用后的返回值作为此时头节点的下一个节点。
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-11-26 22:35
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
         ListNode old = new ListNode(0);
        old.next = head;
        ListNode pre = old;
        while(pre.next != null){
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }
        return old.next;

//        if(head == null){
//            return null;
//        }else{
//            if(head.val == val){
//                ListNode cur = removeElements(head.next, val);
//                return cur;
//            }else{
//                head.next = removeElements(head.next, val);
//                return head;
//            }
//        }
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

        Solution solution = new Solution();
        System.out.println("最终链表：");
        solution.removeElements(n1, 2); // 删除所有节点值为2的节点
        print(n1);
    }

    public static void print(ListNode head) {
        for (ListNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val + "->");
        }
        System.out.println("null");
    }
}
