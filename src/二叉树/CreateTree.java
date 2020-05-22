package 二叉树;



/**
 * 构建二叉树
 * 输入[1,2,3,null,null,4,null]
 *          1
 *       2    3
 *          4
 */
public class CreateTree {
    public TreeNode createTree(String[] nums, int index){
        if(index<nums.length) {
            if (nums[index] == null) {
                return null;
            }else {
                TreeNode root = new TreeNode(Integer.valueOf(nums[index]));
                root.left = createTree(nums,2*index+1);
                root.right = createTree(nums,2*index+2);
                return root;
            }
        }
        return null;
    }

    //打印二叉树
    public void printTree(TreeNode root){
        if(root==null) return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
}
