package NewCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintNodeAsZigzag {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        if (pRoot==null){
            return lists;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();


        stack1.push(pRoot);
        while (!stack1.empty() || !stack2.empty()){
            if (!stack1.empty()){
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack1.empty()){
                    TreeNode curNode = stack1.pop();
                    list.add(curNode.val);
                    System.out.print(curNode.val+" ");
                    if (curNode.left!=null){
                        stack2.push(curNode.left);
                    }
                    if (curNode.right!=null){
                        stack2.push(curNode.right);
                    }
                }
                lists.add(list);
                System.out.println();
            }else if (!stack2.empty()){
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack2.empty()){
                    TreeNode curNode = stack2.pop();
                    list.add(curNode.val);
                    System.out.print(curNode.val+" ");
                    if (curNode.right!=null){
                        stack1.push(curNode.right);
                    }
                    if (curNode.left!=null){
                        stack1.push(curNode.left);
                    }
                }
                lists.add(list);
                System.out.println();
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

        PrintNodeAsZigzag printNodeAsZigzag = new PrintNodeAsZigzag();
        ArrayList arrayList = new ArrayList();
        arrayList = printNodeAsZigzag.Print(node1);
        System.out.println(arrayList);
    }
}
