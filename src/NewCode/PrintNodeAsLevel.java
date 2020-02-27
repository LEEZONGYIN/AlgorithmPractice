package NewCode;


import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每层打印一行
 */
public class PrintNodeAsLevel {
    public  ArrayList<ArrayList<Integer>> printNode(TreeNode pRoot){
        ArrayList<ArrayList<Integer> > lists = new ArrayList<>();

        if (pRoot==null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //当前层还没有打印的结点数
        int toBePrint = 1;
        //下一层结点数
        int level = 0;
        queue.add(pRoot);
        while (queue.size()!=0){
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (toBePrint!=0){
                TreeNode curNode = queue.poll();
                --toBePrint;
                arrayList.add(curNode.val);
                if (curNode.left!=null){
                    queue.add(curNode.left);
                    ++level;
                }
                if (curNode.right!=null){
                    queue.add(curNode.right);
                    ++level;
                }
            }
            if (toBePrint==0){
                lists.add(arrayList);
                toBePrint = level;
                level = 0;
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
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.left = node6;
        node3.right = node7;

        PrintNodeAsLevel printNodeAsLevel = new PrintNodeAsLevel();
        ArrayList<ArrayList<Integer>> lists = printNodeAsLevel.printNode(node1);
        System.out.println(lists);
    }
}
