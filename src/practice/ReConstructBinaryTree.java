package practice;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0||in.length==0){
            return null;
        }

        int rootVal = pre[0];
        if (pre.length==1){
            return new TreeNode(rootVal);
        }

        TreeNode root = new TreeNode(rootVal);
        //在中序遍历中找到根节点的位置
        int rootIndex=0 ;
        for (int i=0;i<in.length;i++){
            if (in[i]==rootVal){
                rootIndex = i;
                break;
            }
        }

        //这里注意Arrays.copyOfRange(int[],start,end)是[)的区间
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex+1),Arrays.copyOfRange(in,0,rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex+1,pre.length),Arrays.copyOfRange(in,rootIndex+1,in.length));

        return root;
    }

    public static void main(String[] args) {
        int[] pre =  {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
        TreeNode node = reConstructBinaryTree.reConstructBinaryTree(pre,in);
        System.out.println(node.val);
    }
}
