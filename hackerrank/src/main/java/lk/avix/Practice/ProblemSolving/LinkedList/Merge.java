package lk.avix.Practice.ProblemSolving.LinkedList;

public class Merge {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        } else if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        if (head1.data > head2.data) {
            SinglyLinkedListNode temp = head2;
            head2 = head2.next;
            temp.next = head1;
            head1 = temp;
        }
        head1.next = mergeLists(head1.next, head2);
        return head1;
    }
}
