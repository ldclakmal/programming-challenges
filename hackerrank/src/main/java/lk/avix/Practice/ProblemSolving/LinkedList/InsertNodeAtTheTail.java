package lk.avix.Practice.ProblemSolving.LinkedList;

public class InsertNodeAtTheTail {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if (head == null) {
            return new SinglyLinkedListNode(data);
        }

        SinglyLinkedListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        tail.next = newNode;

        return head;
    }
}
