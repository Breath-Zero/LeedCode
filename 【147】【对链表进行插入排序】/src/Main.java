/**
 * 原题要求：
 * 对链表进行插入排序。
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 思路：
 *
 * 对链表的插入排序还是比较简单的，为了节省空间，可以直接在源链表上进行操作。
 * 先确定链表头，注意一定要从整个链表上剥离下来，也就是另他的后继为NULL，
 * 要么会出现很奇怪的运行时错误。每次插入的时候有两种情况，第一种是新插入的值比链表头还要小，
 * 那么它变成新的链表头，否则，在已经有序的链表中查找，并记录前面一个节点，找到合适位置后直接插入。
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-11-25 22:23
 **/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = head; // 指向有序节点
        ListNode late = temp.next; // 指向无序节点
        while(late != null){
            if(temp.val > late.val){
                temp.next = late.next; // 先跳过late
                // 从有序链表第一个开始查找，找比late大的
                ListNode n1 = pre;
                ListNode n2 = pre.next;
                while(n2.val < late.val){
                    n1 = n2;
                    n2 = n2.next;
                }
                n1.next = late; // 找到合适位置后插入（在n1和n2之间）
                late.next = n2;

                late = temp.next; // 继续查找下一个  无序链表的一个
            }else{
                temp = late;
                late = late.next;
            }
        }
        return pre.next;
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
        print(solution.insertionSortList(n1));
    }

    public static void print(ListNode head) {
        for (ListNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val + "->");
        }
        System.out.println("null");
    }
}
