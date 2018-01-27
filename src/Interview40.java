/**
 * Created by shuoshu on 2018/1/27.
 */
public class Interview40 {
    public static void main(String[] args) {
        Interview40 solution = new Interview40();
        int[] nums = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] res = solution.getOnce(nums);
        for (int n : res) {
            System.out.println(n);
        }
    }

    public int[] getOnce(int[] nums) {
        int ans = 0;

        for (int num : nums) {
            ans ^= num;
        }

        int[] res = new int[2];
        int i = 0;
        for (; i < 32; i++) {
            if ((ans & (1 << i)) != 0) {
                break;
            }
        }

        for (int num : nums) {
            if ((num & (1 << i)) != 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }
}
