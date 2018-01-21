/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview16 {
    public ListNode reverseNode1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null, cur = head, next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode reverseNode2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode newHead = reverseNode2(next);
        next.next = head;
        head.next = null;

        return newHead;
    }
}
