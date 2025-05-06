package linkedlist;

public class LinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(21);
        head.next = new ListNode(42);
        head.next.next = new ListNode(53);
        head.next.next.next = new ListNode(24);
        head.next.next.next.next = new ListNode(15);

        System.out.println("Original List:");
        printList(head);

        ListNode result = oddEvenList(head);
        System.out.println("Reordered List (Odd followed by Even):");
        printList(result);
    }
}
