/**
 * 原题要求
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 思路：
 * 先遍历一遍，得出链表长度 len，注意 k 可能大于 len，因此令k = (len + (k % len)) % len;。
 * 尾部下一个设为NULL即可。使用快慢指针操作，如找链表环等都使用此操作，倒数第k个结点
 *
 * @ClassName: Main
 * @Description: TODO
 * @Author: Mr.Ye
 * @Data: 2018-11-18 20:14
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0){
            return head;
        }
        int n = k;
        ListNode old = new ListNode(0);// 新建一个结点，利于操作
        old.next = head;
        ListNode fast = old; // 快指针
        ListNode slow = old; // 慢指针
        int len = 0;
        while(fast.next != null){ // 计算链表长度
            len++;
            fast = fast.next;
        }
        fast = old; // 让快指针从新指向头结点
        n = (len + (n % len)) % len; // 最主要的是 k 肯能是 大于节点长度的。 所以取k 的有效长度
        if (n == 0)   // 不需要翻转
            return old.next;
        while(n > 0){
            n--;
            fast = fast.next; //让快的先走 n 步
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        old.next = slow.next; // 重新改变整个节点的链接
        slow.next = fast.next;
        fast.next = head;

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

        Solution solution = new Solution();
        System.out.println("最终链表：");
        print(solution.rotateRight(n1,2));
    }

    public static void print(ListNode head) {
        for (ListNode temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val + "->");
        }
        System.out.println("null");
    }
}


