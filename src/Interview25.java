import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview25 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root, target, new ArrayList<>(), res);

        return res;
    }

    private void dfs(TreeNode root, int target, List<Integer> list, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (target == root.val) {
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }

        list.add(root.val);
        dfs(root.left, target - root.val, list, res);
        dfs(root.right, target - root.val, list, res);
        list.remove(list.size() - 1);
    }
}
