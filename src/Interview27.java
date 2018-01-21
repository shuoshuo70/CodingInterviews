import sun.reflect.generics.tree.Tree;

/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview27 {
    public static void main(String[] args) {
        Interview27 solution = new Interview27();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        solution.print(solution.convertTree(root));
    }


    public TreeNode convertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode lastNode = convertTree(root, null);

        while (lastNode != null && lastNode.left != null) {
            lastNode = lastNode.left;
        }

        return lastNode;
    }

    private TreeNode convertTree(TreeNode root, TreeNode lastNode) {
        if (root == null) {
            return lastNode;
        }

        lastNode = convertTree(root.left, lastNode);

        root.left = lastNode;
        if (lastNode != null) {
            lastNode.right = root;
        }
        lastNode = root;

        lastNode = convertTree(root.right, lastNode);

        return lastNode;
    }

    private void print(TreeNode root) {
        while (root != null && root.right != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }

        while (root != null) {
            System.out.print(root.val + " ");
            root = root.left;
        }
    }
}
