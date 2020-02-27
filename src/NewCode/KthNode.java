package NewCode;

import java.util.ArrayList;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如,（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot==null||k<=0){
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        findNodeMid(pRoot,list);
        if (k>list.size()){
            return null;
        }
        return list.get(k-1);
    }

    static void findNodeMid(TreeNode pRoot, ArrayList<TreeNode> list){
        if (pRoot==null){
            return;
        }
        findNodeMid(pRoot.left,list);
        list.add(pRoot);
        findNodeMid(pRoot.right,list);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node2.left = node1;
        node2.right = node3;

      KthNode kthNode = new KthNode();
        System.out.println(kthNode.KthNode(node2,4));
    }
}
