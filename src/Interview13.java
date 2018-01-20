/**
 * Created by shuoshu on 2018/1/20.
 */
public class Interview13 {
    public static void main(String[] args) {
        Interview13 solution = new Interview13();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode delete = head;
        solution.print(solution.deleteNode(head, delete));
    }

    private void print(ListNode head) {
        while (head != null)  {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode deleteNode(ListNode head, ListNode delete) {
        if (head == delete) {
            return head.next;
        }

        if (delete.next != null) {
            delete.val = delete.next.val;
            delete.next = delete.next.next;
        } else {
            ListNode pre = null, cur = head;
            while (cur != delete) {
                pre = cur;
                cur = cur.next;
            }

            pre.next = null;
        }

        return head;
    }
}
