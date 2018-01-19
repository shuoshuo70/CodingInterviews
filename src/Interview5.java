import java.util.Stack;

/**
 * Created by shuoshu on 2018/1/19.
 */
public class Interview5 {
    public static void main(String[] args) {
        Interview5 solution = new Interview5();
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        solution.printReverseNode1(head);
    }

    public void printReverseNode1 (ListNode head) {
        if (head == null) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public void printReverseNode2 (ListNode head) {
        if (head == null) {
            return;
        }

        ListNode next = head.next;
        printReverseNode2(next);
        System.out.println(head.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
