//package 二叉树;
//
//import sun.reflect.generics.tree.Tree;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
///**
// * 前序遍历
// * 非递归
// */
//public class PreorderTraversal {
//    public static List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//
//        stack.push(root);
//        while (!stack.empty()){
//            TreeNode temp = stack.pop();
//            list.add(temp.val);
//            if(temp.right!=null) stack.add(temp.right);
//            if(temp.left!=null) stack.add(temp.left);
//        }
//        return list;
//    }
//
//    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        node1.left = node2;
//        node1.right = node3;
//        System.out.println(preorderTraversal(node1));
//    }
//}
