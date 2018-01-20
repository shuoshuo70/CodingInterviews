/**
 * Created by shuoshu on 2018/1/20.
 */
public class Interview14 {
    public static void main(String[] args) {
        Interview14 solution = new Interview14();
        int[] nums = {1, 2, 3, 4, 5};
        solution.adjustArray(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void adjustArray(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) {
                i++;
            }

            while (i < j && (nums[j] & 1) == 0) {
                j--;
            }

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}