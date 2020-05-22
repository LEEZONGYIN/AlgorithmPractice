package Review;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean res = false;
        if (root1!=null&&root2!=null) {
            if (root1.val == root2.val) {
                res = DoesTeer1HasTree2(root1, root2);
            }
            if (!res) {
                res = HasSubtree(root1.left, root2);
            }
            if (!res) {
                res = HasSubtree(root1.right, root2);
            }
        }
        return res;
    }

    public boolean DoesTeer1HasTree2(TreeNode root1,TreeNode root2){
        if (root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }

        if (root1.val!=root2.val){
            return false;
        }
        return DoesTeer1HasTree2(root1.left,root2.left)&&DoesTeer1HasTree2(root1.right,root2.right);
    }
}
