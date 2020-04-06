package lk.avix.Practice.ProblemSolving.LinkedList;

public class InsertNodeAtTheHead {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        if (llist == null) {
            return new SinglyLinkedListNode(data);
        }

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = llist;

        return newNode;
    }
}
