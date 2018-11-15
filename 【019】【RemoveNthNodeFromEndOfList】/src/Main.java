public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.print("初始链表：");
        print(n1);

        Solution solution = new Solution();
        ListNode head = solution.removeNthFromEnd(n1, 2);

        System.out.print("最终链表：");
        print(head);
    }
    private static void print(ListNode head) {
        for (ListNode temp = head; temp != null; temp = temp.next){
            System.out.print(temp.val + "->");
        }
        System.out.println("null");
    }
}
