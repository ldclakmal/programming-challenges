package lk.avix.Practice.ProblemSolving.LinkedList;

public class DeleteNode {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (head == null) {
            return null;
        }

        if (position == 0) {
            return head.next;
        }

        SinglyLinkedListNode tmpNode = head;
        int count = 1;
        while (count != position) {
            tmpNode = tmpNode.next;
            count++;
        }

        tmpNode.next = tmpNode.next.next;

        return head;
    }
}
