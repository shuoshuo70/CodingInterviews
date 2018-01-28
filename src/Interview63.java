/**
 * Created by shuoshu on 2018/1/28.
 */
public class Interview63 {
    int cnt = 1, ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        if (root != null) {
            kthSmallest(root.left, k);
            if (cnt == k) {
                ans = root.val;
            }
            cnt++;
            kthSmallest(root.right, k);
        }

        return ans;
    }
}
