/**
 * Created by shuoshu on 2018/1/28.
 */
public class Interview57 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1), cur = head, pre = dummy, next = null;
        boolean isDup = false;

        while (cur != null) {
            next = cur.next;
            while (next != null && next.val == cur.val) {
                next = next.next;
                isDup = true;
            }

            if (isDup) {
                pre.next = next;
            } else {
                pre.next = cur;
                pre = pre.next;
            }

            cur = next;
            isDup = false;
        }

        return dummy.next;
    }
}
