import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuoshu on 2018/1/27.
 */
public class Interview44 {
    public static void main(String[] args) {
        Interview44 solution = new Interview44();
        int[] nums = {1, 2, 4, 0, 2};
        System.out.println(solution.isContinuous(nums));
    }

    public boolean isContinuous(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<Integer> visited = new HashSet<>();

        for (int num : nums) {
            if (num != 0) {
                if (!visited.add(num)) {
                    return false;
                }
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }

        return nums.length - 1 >= max - min;
    }
}
