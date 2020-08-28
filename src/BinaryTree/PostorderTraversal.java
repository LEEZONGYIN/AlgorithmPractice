package BinaryTree;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历
 * 非递归
 * 宽度优先遍历
 */
public class PostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return list;
        stack.push(root);
        while(!stack.empty()){
            TreeNode temp = stack.pop();
            list.addFirst(temp.val);
            if(temp.left!=null) stack.push(temp.left);
            if(temp.right!=null) stack.push(temp.right);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(postorderTraversal(node1));
    }
}
