package lk.avix.Practice.ProblemSolving.LinkedList;

public class PrintTheElements {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static void printLinkedList(SinglyLinkedListNode head) {
        if (head == null) {
            return;
        }
        SinglyLinkedListNode node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
