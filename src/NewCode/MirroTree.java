package NewCode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirroTree {
    public void Mirror(TreeNode root) {

        if (root!=null && (root.right!=null ||root.left!=null)){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;

        MirroTree mt = new MirroTree();
        mt.Mirror(n1);
        System.out.println(n2.right.val);
    }
}
