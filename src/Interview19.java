/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview19 {
    public boolean isMirrorTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isMirrorTree(p.left, q.right) && isMirrorTree(p.right, q.left);
    }
}
