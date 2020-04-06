package lk.avix.Practice.ProblemSolving.LinkedList;

public class Reverse {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public PrintInReverse.SinglyLinkedListNode head;
        public PrintInReverse.SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SinglyLinkedListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
