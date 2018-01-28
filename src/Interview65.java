import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by shuoshu on 2018/1/28.
 */
public class Interview65 {
    public static void main(String[] args) {
        Interview65 solution = new Interview65();
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        int[] ans = solution.maxInSlidingWindow(nums, 3);

        for (int n : ans) {
            System.out.print(n + " ");
        }
    }

    public int[] maxInSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }
}
