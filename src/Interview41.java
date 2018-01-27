import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuoshu on 2018/1/27.
 */
public class Interview41 {
    public static void main(String[] args) {
        Interview41 solution = new Interview41();
        System.out.println(solution.getPairs(15));
    }

    public List<List<Integer>> getPairs(int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target <= 0) {
            return res;
        }

        int l = 1, r = 2;

        while (l < r) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(l);
                list.add(r);
                res.add(list);
                l++;
                r++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }


        return res;
    }
}
