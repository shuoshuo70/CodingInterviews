/**
 * Created by shuoshu on 2018/1/27.
 */
public class Interview39 {
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced1(root.left) &&
                isBalanced1(root.right);
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
