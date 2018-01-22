import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by shuoshu on 2018/1/22.
 */
public class Interview33 {
    public String smallestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });

        String res = "";
        for (int i = 0; i < strs.length; i++) {
            if ("0".equals(strs[i])) {
                continue;
            }
            res += strs[i];
        }

        return res;
    }
}
