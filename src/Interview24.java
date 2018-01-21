/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview24 {
    public static void main(String[] args) {
        Interview24 solution = new Interview24();
        int[] nums = {5, 6, 7, 9, 11, 10, 8};
        System.out.println(solution.isPostOrder(nums));
    }

    public boolean isPostOrder(int[] nums) {
        return isPostOrder(nums, 0, nums.length - 1);
    }

    private boolean isPostOrder(int[] nums, int start, int end) {
        if (start > end) {
            return false;
        }

        int i = start;
        for (; i < end; i++) {
            if (nums[i] > nums[end]) {
                break;
            }
        }

        int j = i;
        for (; j < end; j++) {
            if (nums[j] < nums[end]) {
                return false;
            }
        }

        boolean isValidLeft = true, isValidRight = true;
        if (i > start) {
            isValidLeft = isPostOrder(nums, start, i - 1);
        }
        if (j > i) {
            isValidRight = isPostOrder(nums, i, end - 1);
        }

        return isValidLeft && isValidRight;
    }
}
