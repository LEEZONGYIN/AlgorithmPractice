package practice;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced {

    public boolean IsBalanced_Solution(TreeNode root) {

        if (root==null){
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left-right)>1){
            return false;
        }
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);


    }
    public int depth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);

        return left>right?left+1:right+1;
    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

    }

}
