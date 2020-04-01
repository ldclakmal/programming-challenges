package lk.avix.Problems;

public class Q2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addRecursively(l1, l2, 0);
    }

    public ListNode addRecursively(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int v1 = l1 == null ? 0 : l1.val;
        int v2 = l2 == null ? 0 : l2.val;
        int sum = v1 + v2 + carry;
        carry = sum / 10;
        ListNode t = new ListNode(sum % 10);
        t.next = addRecursively(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);
        return t;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Q2_Test {

    public static void main(String[] args) {

        // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        // Output: 7 -> 0 -> 8
        // Explanation: 342 + 465 = 807.

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Q2_AddTwoNumbers solution = new Q2_AddTwoNumbers();
        ListNode ln = solution.addTwoNumbers(l1, l2);

        ListNode node = ln;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();

        // l1 = [0,1]
        // l2 = [0,1,2]
        l1 = new ListNode(0);
        l1.next = new ListNode(1);

        l2 = new ListNode(0);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);

        solution = new Q2_AddTwoNumbers();
        ln = solution.addTwoNumbers(l1, l2);

        node = ln;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();

        // l1 = []
        // l2 = [0,1]
        l1 = null;
        l2 = new ListNode(0);
        l2.next = new ListNode(1);

        solution = new Q2_AddTwoNumbers();
        ln = solution.addTwoNumbers(l1, l2);

        node = ln;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();

        // l1 = [9,9]
        // l2 = [1]
        l1 = new ListNode(9);
        l1.next = new ListNode(9);

        l2 = new ListNode(1);

        solution = new Q2_AddTwoNumbers();
        ln = solution.addTwoNumbers(l1, l2);

        node = ln;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }
}
