package lk.avix.practice.ProblemSolving.LinkedList;

public class Compare {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if ((head1 == null && head2 != null) || (head1 != null && head2 == null)) {
            return false;
        }
        if (head1.next == null && head2.next == null) {
            return head1.data == head2.data;
        }
        return compareLists(head1.next, head2.next);
    }
}
