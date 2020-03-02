package practice;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }

        ArrayList<Integer> list = new ArrayList<>();
        findPath(root,target,list,lists,0);
        return lists;
    }

    public void findPath(TreeNode root,int target,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> lists,int sum){

        sum += root.val;
        list.add(root.val);
        boolean isLeaf = root.left==null&&root.right==null?true:false;

        if (sum==target && isLeaf){
            //注意这里创建list
            lists.add(new ArrayList<>(list));
        }

        if (root.left!=null){
         findPath(root.left,target,list,lists,sum);
        }
        if (root.right != null){
         findPath(root.right,target,list,lists,sum);
        }

        list.remove(list.size()-1);
        sum -= root.val;
    }

    public static void main(String[] args) {
        TreeNode node10= new TreeNode(10);
        TreeNode node5= new TreeNode(5);
        TreeNode node12= new TreeNode(12);
        TreeNode node4= new TreeNode(4);
        TreeNode node7= new TreeNode(7);

        node10.left=node5;
        node10.right=node12;
        node5.left=node4;
        node5.right=node7;

        FindPath fp = new FindPath();

        System.out.println(fp.FindPath(node10,22));

    }
}
