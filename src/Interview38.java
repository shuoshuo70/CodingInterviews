/**
 * Created by shuoshu on 2018/1/23.
 */
public class Interview38 {
    public static void main(String[] args) {
        Interview38 solution = new Interview38();
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(solution.appearTimes(nums, 6));
    }

    public int appearTimes(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int first = findFirst(nums, target);
        if (first == -1) {
            return 0;
        }

        int last = findLast(nums, target);
        return last - first + 1;
    }

    private int findFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[l] == target ? l : -1;
    }

    private int findLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return nums[l] == target ? l : -1;
    }
}
