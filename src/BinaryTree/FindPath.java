package BinaryTree;

import java.util.Stack;

/**
 * 给出目标节点，找到该目标节点从根节点到目标节点的路径
 */
public class FindPath {
    public boolean findPath(TreeNode root, TreeNode target, Stack<TreeNode> stack){
        if(root==null) return false;
        stack.push(root);
        if(root==target) return true;
        boolean flag = false;
        //先从左子树找
        if(root.left!=null) flag = findPath(root.left,target,stack);
        //左子树没找到，且右子树不为空，在右子树找
        if(!flag && root.right!=null) flag = findPath(root.right,target,stack);
        //左右子树都没有，弹出栈顶元素，如果找到了，那么栈内就是路径
        if(!flag){
            stack.pop();
        }
        return flag;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        FindPath fp = new FindPath();
        Stack<TreeNode> stack = new Stack<>();
        fp.findPath(node1,node5,stack);
        for(TreeNode t:stack){
            System.out.println(t.val);
        }
    }
}
