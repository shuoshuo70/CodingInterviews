/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview17 {
    public ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode newHead;
        if (l1.val < l2.val) {
            newHead = l1;
            l1.next = mergeList(l1.next, l2);
        } else {
            newHead = l2;
            l2.next = mergeList(l1, l2.next);
        }

        return newHead;
    }
}
