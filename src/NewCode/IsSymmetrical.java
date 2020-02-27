package NewCode;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot,pRoot);
    }
    boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2){
        if (pRoot1==null && pRoot2 == null){
            return true;
        }
        if (pRoot1==null || pRoot2==null){
            return false;
        }
        if (pRoot1.val != pRoot2.val){
            return false;
        }

        return isSymmetrical(pRoot1.left,pRoot2.right)
                &&
                isSymmetrical(pRoot1.right,pRoot2.left);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.left = node6;
        node3.right = node7;

        IsSymmetrical isSymmetrical = new IsSymmetrical();
        System.out.println(isSymmetrical.isSymmetrical(node1));
    }
}
