/**
 * Created by shuoshu on 2018/1/22.
 */
public class Interview31 {
    public int maxSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE, sum = 0;

        for (int num : nums) {
            if (sum <= 0) {
                sum = num;
            } else {
                sum += num;
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}
