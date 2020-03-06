package practice;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        convertTree(pRootOfTree);
        return realHead;
    }

    //画图可以看出pRoot的轨迹为中序遍历，head则为pRoot的上一个结点，使这两个结点形成双向指针，
    // 然后head走到pRoot位置，pRoot按中序遍历走到下一个位置，就可以形成双向链表
    public void convertTree(TreeNode pRoot){
        if (pRoot == null) return;
        convertTree(pRoot.left);
        if (head == null){
            head = pRoot;
            realHead = pRoot;
        }else {
            head.right = pRoot;
            pRoot.left = head;
            head = pRoot;
        }
        convertTree(pRoot.right);
    }
}
