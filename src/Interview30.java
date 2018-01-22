import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by shuoshu on 2018/1/22.
 */
public class Interview30 {
    public static void main(String[] args) {
        Interview30 solution = new Interview30();
        int[] nums = {1,  34, 54, 23, 2, 45, 64, 1, 3};
        int[] ans = solution.minKs3(nums, 3);

        for (int n : ans) {
            System.out.print(n + " ");
        }
    }

    public int[] minKs1(int[] nums, int k) {
        if (nums.length < k) {
            return nums;
        }

        int[] ans = new int[k];
        partition(nums, 0, nums.length - 1, k);

        for (int i = 0; i < k; i++) {
            ans[i] = nums[i];
        }

        return ans;
    }

    private void partition(int[] nums, int start, int end, int k) {
        int pivot = nums[start], i = start, j = end;

        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }

            if (i < j) {
                nums[i++] = nums[j];
            }

            while (i < j && nums[i] < pivot) {
                i++;
            }

            if (i < j) {
                nums[j--] = nums[i];
            }
        }

        nums[i] = pivot;
        if (i > k) {
            partition(nums, start, i - 1, k);
        } else if (i < k) {
            partition(nums, i + 1, end, k);
        }
    }

    public int[] minKs2(int[] nums, int k) {
        if (nums.length < k) {
            return nums;
        }

        int[] ans = new int[k];

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (pq.peek() > nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        int index = 0;
        while (!pq.isEmpty()) {
            ans[index++] = pq.poll();
        }

        return ans;
    }

    public int[] minKs3(int[] nums, int k) {
        if (nums.length < k) {
            return nums;
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = nums[i];
        }

        buildHeap(ans);

        for (int i = k + 1; i < nums.length; i++) {
            if (nums[i] < ans[0]) {
                ans[0] = nums[i];
                adjustHeap(ans, 0, ans.length - 1);
            }
        }

        return ans;
    }

    private void buildHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            adjustHeap(nums, i, nums.length - 1);
        }
    }

    private void adjustHeap(int[] nums, int start, int end) {
        int lChild = 2 * start + 1, rChild = 2 * start + 2, maxIndex = start;

        if (lChild <= end && nums[maxIndex] < nums[lChild]) {
            maxIndex = lChild;
        }
        if (rChild <= end && nums[maxIndex] < nums[rChild]) {
            maxIndex = rChild;
        }

        if (maxIndex != start) {
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[start];
            nums[start] = temp;
            adjustHeap(nums, maxIndex, end);
        }
    }
}
