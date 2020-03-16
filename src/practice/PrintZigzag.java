package practice;

import java.util.ArrayList;
import java.util.Stack;


/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintZigzag {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot==null){

            return lists;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.add(pRoot);
        while (!stack1.empty() || !stack2.empty() ){
            ArrayList<Integer> list = new ArrayList<>();
            if (!stack1.empty()){
                while (!stack1.empty()){
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if (node.left!=null){
                        stack2.push(node.left);
                    }
                    if (node.right!=null){
                        stack2.push(node.right);
                    }
                }
                lists.add(list);
            }else if (!stack2.empty()){
                while (!stack2.empty()){
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    if (node.right!=null){
                        stack1.add(node.right);
                    }
                    if (node.left!=null){
                        stack1.add(node.left);
                    }
                }
                lists.add(list);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        PrintZigzag pz = new PrintZigzag();
        ArrayList<ArrayList<Integer>> lists = pz.Print(node1);
        System.out.println(lists);
    }
}
