import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shuoshu on 2018/1/28.
 */
public class Interview62 {
    public static void main(String[] args) {
        Interview62 solution = new Interview62();
        TreeNode root = new TreeNode(1);
        root.left =new TreeNode(2);
        root.right = new TreeNode(3);
        String s = solution.serialize(root);
        solution.deserialize(s);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return null;
        }

        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.val + ",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        } else {
            sb.append("#,");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strs = data.split(",");
        Queue<String> q = new LinkedList<>();

        for (String str : strs) {
            q.offer(str);
        }

        return deserialize(q);
    }

    private TreeNode deserialize(Queue<String> q) {
        if (q.isEmpty()) {
            return null;
        }

        String cur = q.poll();
        if ("#".equals(cur)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserialize(q);
        root.right = deserialize(q);

        return root;
    }
}
