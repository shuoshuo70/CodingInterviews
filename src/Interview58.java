/**
 * Created by shuoshu on 2018/1/28.
 */
public class Interview58 {
    public static void main(String[] args) {
        Interview58 solution = new Interview58();
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.parent = root;
        root.left.left = new BinaryTreeNode(4);
        root.left.left.parent = root.left.left;
        root.right = new BinaryTreeNode(3);
        root.right.parent = root;
        root.right.right = new BinaryTreeNode(5);
        root.right.parent = root.right;
        System.out.println(solution.getNext(root.right).val);
    }

    public BinaryTreeNode getNext(BinaryTreeNode p) {
        if (p == null) {
            return null;
        }

        if (p.right != null) {
            BinaryTreeNode cur = p.right;
            while (cur != null && cur.left != null) {
                cur = cur.left;
            }

            return cur;
        }

        BinaryTreeNode parent = p.parent;
        while (parent != null && parent.left != p) {
            p = parent;
            parent = p.parent;
        }

        return parent;
    }
}

class BinaryTreeNode {
    int val;
    BinaryTreeNode left, right, parent;

    BinaryTreeNode(int val) {
        this.val = val;
    }
}
