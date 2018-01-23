/**
 * Created by shuoshu on 2018/1/23.
 */
public class Interview37 {
    public ListNode firstCommonNode(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        int len1 = 0, len2 = 0;
        ListNode cur1 = l1, cur2 = l2;

        while (cur1.next != null) {
            len1++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            len2++;
            cur2 = cur2.next;
        }

        if (cur1 != cur2) {
            return null;
        }

        cur1 = l1;
        cur2 = l2;
        int diff = len1 - len2;
        if (diff > 0) {
            while (diff-- > 0) {
                cur1 = cur1.next;
            }
        } else {
            while (diff++ < 0) {
                cur2 = cur2.next;
            }
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }
}