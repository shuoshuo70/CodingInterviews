import java.util.Arrays;

/**
 * Created by shuoshu on 2018/1/27.
 */
public class Interview52 {
    public static void main(String[] args) {
        Interview52 solution = new Interview52();
        int[] nums = {1, 1};
        int[] res = solution.productExceptSelf(nums);
        for (int n : res) {
            System.out.print(n + "  ");
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        if (nums.length == 0) {
            return ans;
        }

        int left = 1, right = 1;

        for (int i = 0; i < nums.length; i++) {
            ans[i] = left;
            left *= nums[i];
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            ans[j] *= right;
            right *= nums[j];
        }

        return ans;
    }
}
