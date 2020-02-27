package NewCode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){
            return true;
        }
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(root,1,res);
        return res[0];
    }

    //如果用boolean res 得不到正确结果
    public static int getHeight(TreeNode head,int level,boolean[] res){
        if (head == null){
            return level;
        }
        int leftHeight = getHeight(head.left,level+1,res);
        //当有不平衡的时候，直接返回，level值已经不重要
        if (!res[0]){
            return level;
        }
        int rightHeight = getHeight(head.right,level+1,res);
        if (!res[0]){
            return level;
        }

        if (Math.abs(leftHeight-rightHeight)>1){
            res[0] = false;
        }

        return Math.max(leftHeight,rightHeight);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node2.right = node4;
        node1.right = node3;
        node3.left = node5;
        node5.right = node6;

        IsBalanced isBalanced = new IsBalanced();
        System.out.println(isBalanced.IsBalanced_Solution(node1));


    }
}
