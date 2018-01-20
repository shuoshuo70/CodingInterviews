/**
 * Created by shuoshu on 2018/1/20.
 */
public class Interview8 {
    public int minValue(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[l] < nums[r]) {
                return nums[l];
            }

            if (nums[l] == nums[mid] || nums[l] == nums[r]) {
                l++;
                continue;
            }

            if (nums[mid] == nums[r]) {
                r--;
                continue;
            }

            if (nums[l] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }
}
