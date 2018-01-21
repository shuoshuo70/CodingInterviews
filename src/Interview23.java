import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuoshu on 2018/1/21.
 */
public class Interview23 {
    public static void main(String[] args) {
        Interview23 solution = new Interview23();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        solution.printTree(root);
    }

    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                System.out.print(cur.val + " ");

                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
    }
}
