/**
 * Created by shuoshu on 2018/1/19.
 */
public class Interview3 {
    public boolean findNumber(int target, int[][] nums) {
        int i = 0, j = nums[0].length - 1;

        while (i < nums.length && j >= 0) {
            if (nums[i][j] == target) {
                return true;
            } else if (nums[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
