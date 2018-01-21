/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview15 {
    public static void main(String[] args) {
        Interview15 solution = new Interview15();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(solution.findKToTail(head, 4).val);
    }

    public ListNode findKToTail(ListNode head, int k) {
        if (k == 0 || head == null) {
            return null;
        }

        int length = 0;
        ListNode cur = head;

        while (cur != null) {
            length++;
            cur = cur.next;
        }

        k = (k - 1) % length + 1;

        ListNode fast = head, slow = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    private void print(ListNode head) {
        while (head != null)  {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
