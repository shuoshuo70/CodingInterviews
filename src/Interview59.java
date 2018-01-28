/**
 * Created by shuoshu on 2018/1/28.
 */
public class Interview59 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSymmetric(p.left, q.right)
                && isSymmetric(p.right, q.left);
    }
}
