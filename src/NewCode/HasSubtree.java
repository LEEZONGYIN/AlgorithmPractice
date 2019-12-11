package NewCode;

import java.util.Date;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        boolean result = false;
        if (root1!=null&&root2!=null) {

            if (root1.val == root2.val) {
                result = DoseTree1HasTree2(root1, root2);
            }
            if (!result) {
                result = DoseTree1HasTree2(root1.left, root2);
            }
            if (!result) {
                result = DoseTree1HasTree2(root1.right, root2);
            }
        }
            return result;
    }

    private boolean DoseTree1HasTree2(TreeNode root1, TreeNode root2) {

        if (root2==null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        return DoseTree1HasTree2(root1.left,root2.left)&&DoseTree1HasTree2(root1.right,root2.right);
    }

    public static void main(String[] args) {
    }

}
