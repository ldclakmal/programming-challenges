package lk.avix.problems;

public class Q2_AddTwoNumbers {

    public String add(int[] arr1, int[] arr2) {
        ListNode l1 = convertToListNode(arr1);
        ListNode l2 = convertToListNode(arr2);
        ListNode ln = addTwoNumbers(l1, l2);
        return convertToString(ln);
    }

    private ListNode convertToListNode(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode node = new ListNode(arr[0]);
        ListNode temp = node;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return node;
    }

    private String convertToString(ListNode ln) {
        StringBuilder output = new StringBuilder();
        while (ln != null) {
            output.append(ln.val);
            ln = ln.next;
        }
        return String.valueOf(output);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addRecursively(l1, l2, 0);
    }

    private ListNode addRecursively(ListNode l1, ListNode l2, int carry) {
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

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
