/**
 * Created by shuoshu on 2018/1/27.
 */
public class Interview51 {
    public static void main(String[] args) {
        Interview51 solution = new Interview51();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(solution.duplicateOne(nums));
    }

    public int duplicateOne(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }

        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
