package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintTreeNode {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root==null){
            return list;
        }

        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if (curNode.left!=null){
                queue.add(curNode.left);
            }
            if (curNode.right!=null){
                queue.add(curNode.right);
            }
            list.add(curNode.val);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        PrintTreeNode printTreeNode = new PrintTreeNode();
        System.out.println(printTreeNode.PrintFromTopToBottom(node1));
    }
}
