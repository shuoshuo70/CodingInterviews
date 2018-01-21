import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview26 {
    public RandomListNode copyList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode newHead = new RandomListNode(head.val);
        RandomListNode preNew = newHead, cur = head.next;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, newHead);

        while (cur != null) {
            preNew.next = new RandomListNode(cur.val);
            map.put(cur, preNew.next);

            cur = cur.next;
            preNew = preNew.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return newHead;
    }
}

class RandomListNode {
    int val;
    RandomListNode next;
    RandomListNode random;

    RandomListNode(int val) {
        this.val = val;
    }
}
