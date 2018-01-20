/**
 * Created by shuoshu on 2018/1/20.
 */
public class Interview6 {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length != inOrder.length) {
            return null;
        }

        return buildTree(preOrder, 0, preOrder.length -1, inOrder, 0, inOrder.length - 1);
    }

    private TreeNode buildTree (int[] preOrder, int start1, int end1, int[] inOrder, int start2, int end2) {
        if (start1 > end1 || start2 > end2) {
            return null;
        }

        int index = -1;
        for (int i = start2; i <= end2; i++) {
            if (inOrder[i] == preOrder[start1]) {
                index = i - start2;
                break;
            }
        }

        if (index == -1) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[start1]);
        root.left = buildTree(preOrder, start1 + 1, start1 + index, inOrder, start2, start2 + index - 1);
        root.right = buildTree(preOrder, start1 + index + 1, end1, inOrder, start2 + index + 1, end2);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode (int val) {
        this.val = val;
    }
}