package NewCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PrintTreeNode {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> treeNodeList = new ArrayList<>();
        Queue<TreeNode> tempTreeNode = new ArrayDeque<>();
        if (root==null)return treeNodeList;
        if (root!=null) {
            tempTreeNode.add(root);
        }
        while (tempTreeNode.size()>0) {
            TreeNode treeNode = tempTreeNode.poll();
            treeNodeList.add(treeNode.val);
            if (treeNode.left != null) {
                tempTreeNode.add(treeNode.left);
            }
            if (treeNode.right !=null){
                tempTreeNode.add(treeNode.right);
            }

        }
        return treeNodeList;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left=node2;
        node1.right=node3;

        PrintTreeNode printTreeNode = new PrintTreeNode();
        List<Integer> list = printTreeNode.PrintFromTopToBottom(node1);
        System.out.println(list);
    }
}
