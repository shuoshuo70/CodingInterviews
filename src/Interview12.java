/**
 * Created by shuoshu on 2018/1/20.
 */
public class Interview12 {
    public static void main(String[] args) {
        Interview12 solution = new Interview12();
        solution.print1ToN(3);
    }

    public void print1ToN(int n) {
        if (n <= 0) {
            return;
        }

        char[] nums = new char[n];
        for (int i = 1; i <=  n; i++) {
            for (int j = 1; j < 10; j++) {
                nums[0] = (char) (j + '0');
                helper(nums, 1, i);
                nums[0] = '0';
            }
        }
    }

    private void helper(char[] nums, int index, int length) {
        if (index == length) {
            print(nums);
            return;
        }

        for (int i = 0; i < 10; i++) {
            nums[index] = (char) (i + '0');
            helper(nums, index + 1, length);
            nums[index] = '0';
        }
    }

    private void print(char[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }
}
