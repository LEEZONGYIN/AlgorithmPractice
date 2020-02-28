package practice;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorTree {
    public void Mirror(TreeNode root) {
        if (root==null){
            return;
        }
        if (root.left!=null||root.right!=null){
            TreeNode temp = null;
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        MirrorTree mt = new MirrorTree();
        mt.Mirror(node1);
        System.out.println(node1.right.right.val);
    }
}
