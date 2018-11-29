/**
 * 原题要求：
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @ClassName: Main
 * @Author: Mr.Ye
 * @Data: 2018-11-29 19:15
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //平分结点，分成两个分支
        ListNode cur = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {//如果是奇数个结点，多出来的一个结点放在了后面的部分
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        cur.next = null;
        //每个分支都要排序，然后按序合并
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        //按序合并，子分支和大分支都在这里合并
        return merge(l1, l2);
    }//sortList

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), p = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.val = l1.val;
                p.next = l1;//这一句别忘了
                l1 = l1.next;
            } else {
                res.val = l2.val;
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }//while

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
//            p.next = l2.next;不能是p.next = l2.next
            p.next = l2;
        }
        return res.next;// ListNode res = new ListNode(0)因为第一个结点是0，所以这里是 res.next,而不是res

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
        solution.sortList(n1);
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
