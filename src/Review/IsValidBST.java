package Review;

/**
 * 判断是否是二叉搜索树
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root){
        return isValidBST(root,null,null);
    }
    public boolean isValidBST(TreeNode root,TreeNode max,TreeNode min){
        if (root==null) return true;

        if (max!=null && root.val>=max.val) return false;
        if (min!=null && root.val<max.val) return false;

        return isValidBST(root.left,root,min) && isValidBST(root.right,max,min);
    }
}
