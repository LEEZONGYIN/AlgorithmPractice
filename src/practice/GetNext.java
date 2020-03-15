package practice;


/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode next = null;
        //如果一个节点有右子树，那么下一个节点就是它右子树的最左节点
        if (pNode.right!=null){
            TreeLinkNode right = pNode.right;
            while (right!=null&&right.left!=null){
                right = right.left;
            }
            return right;
        }
        //如果该节点没有右子树，分两种情况
        if (pNode.right==null){
            TreeLinkNode parent = pNode.next;
            while (parent!=null && parent.right==pNode){
                pNode = parent;
                parent = parent.next;
            }
            next = parent;
        }
        return next;
    }

    public static void main(String[] args) {
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode b = new TreeLinkNode(2);
        TreeLinkNode c = new TreeLinkNode(3);
        TreeLinkNode d = new TreeLinkNode(4);
        TreeLinkNode e = new TreeLinkNode(5);
        TreeLinkNode f = new TreeLinkNode(6);
        TreeLinkNode g = new TreeLinkNode(7);
        TreeLinkNode h = new TreeLinkNode(8);
        TreeLinkNode i = new TreeLinkNode(9);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        b.next = a;
        c.left = f;
        c.right = g;
        c.next = a;
        d.next = b;
        e.next = b;
        e.left = h;
        e.right = i;
        f.next = c;
        g.next = c;
        h.next = e;
        i.next = e;

        GetNext gn = new GetNext();
        System.out.println(gn.GetNext(f).val);
    }
}
