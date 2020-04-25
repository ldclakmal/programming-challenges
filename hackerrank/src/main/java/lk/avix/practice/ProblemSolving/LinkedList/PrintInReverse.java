package lk.avix.practice.ProblemSolving.LinkedList;

public class PrintInReverse {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static void reversePrint(SinglyLinkedListNode head) {
        if (head != null) {
            reversePrint(head.next);
            System.out.println(head.data);
        }
    }
}
