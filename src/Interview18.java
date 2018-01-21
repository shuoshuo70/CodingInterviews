/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview18 {
    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val == root2.val) {
            if (isSame(root1, root2)) {
                return true;
            }
        }

        return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            return isSame(p.left, q.left) && isSame(p.right, q.right);
        }

        return false;
    }
}
