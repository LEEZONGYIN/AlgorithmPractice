package practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintLevel {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot==null){
            return lists;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(pRoot);
        int toBePrint = 1;
        int nextLevel = 0;

        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            toBePrint--;


            if (node.left!=null){
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right!=null){
                queue.add(node.right);
                nextLevel++;
            }

            if (toBePrint==0){
                toBePrint = nextLevel;
                nextLevel = 0;
                lists.add(new ArrayList(list));
                list.clear();
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
        PrintLevel pl = new PrintLevel();
        ArrayList<ArrayList<Integer>> lists = pl.Print(node1);
        System.out.println(lists);
    }
}
