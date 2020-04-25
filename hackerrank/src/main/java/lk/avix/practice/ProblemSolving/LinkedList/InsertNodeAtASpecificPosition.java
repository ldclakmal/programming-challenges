package lk.avix.practice.ProblemSolving.LinkedList;

public class InsertNodeAtASpecificPosition {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        if (head == null) {
            return new SinglyLinkedListNode(data);
        }

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        SinglyLinkedListNode tmpNode = head;
        int count = 1;
        while (count != position) {
            tmpNode = tmpNode.next;
            count++;
        }

        newNode.next = tmpNode.next;
        tmpNode.next = newNode;

        return head;
    }
}
