class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    /**
     * <pre>
     * 题目要求：
     * 合并k个排好的的单链表
     *
     * 解题思路：
     * 使用一个小堆来进行操作，先将k个单链表的第一个结点入堆，再取堆中的最小素，此为最小的元素，
     * 将这个元素的下一个结点堆，再取堆中最小的，依次操作直到堆为空
     * </pre>
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        //方法1
        ListNode cur = null;
        if(lists.length == 0){
            return null;
        }else if(lists.length == 1){
            return lists[0];
        }else if(lists.length == 2){
            return mergeTwoLists(lists[0], lists[1]);
        }else{
            cur = lists[0];
            for(int i = 1; i < lists.length; i++){
                cur = mergeTwoLists(cur, lists[i]);
            }
            return cur;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode old = new ListNode(0);
        ListNode head = old;
        while(l1 != null && l2 !=null){
            if(l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            }else{
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
        }
        if(l1 == null){ // l1为空的时候，有可能l2不为空，所以把剩下的l1链接
            head.next = l2;
        }
        if(l2 == null){// l2为空的时候，有可能l1不为空，所以把剩下的l2链接
            head.next = l1;
        }
        return old.next;
    }
}
