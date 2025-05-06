package linkedlist2;

public class LinkedList2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode groupEveryOther(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode groupA = head;           // Head of first group
        ListNode groupB = head.next;      // Head of second group
        ListNode a = groupA;
        ListNode b = groupB;

        while (b != null && b.next != null) {
            a.next = b.next;
            a = a.next;

            b.next = a.next;
            b = b.next;
        }

        a.next = groupB;  // Link Group A with Group B
        return groupA;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test case: [2,1,3,5,6,4,7]
        ListNode head = new ListNode(27);
        head.next = new ListNode(51);
        head.next.next = new ListNode(34);
        head.next.next.next = new ListNode(35);
        head.next.next.next.next = new ListNode(86);
        head.next.next.next.next.next = new ListNode(44);
        head.next.next.next.next.next.next = new ListNode(37);

        System.out.println("Original List:");
        printList(head);

        ListNode result = groupEveryOther(head);
        System.out.println("Grouped Every Other Node:");
        printList(result);
    }
}
