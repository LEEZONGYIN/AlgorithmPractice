package practice;

import java.util.ArrayList;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot==null||k<=0) return null;
        ArrayList<TreeNode> list = new ArrayList<>();
        getNode(pRoot,list);
        if (list.size()<k){
            return null;
        }
        return list.get(k-1);
    }
    public void getNode(TreeNode root,ArrayList<TreeNode> list){
        if (root==null){
            return;
        }
        getNode(root.left,list);
        list.add(root);
        getNode(root.right,list);
    }
}
