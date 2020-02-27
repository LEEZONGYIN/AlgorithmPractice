package NewCode;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * ①如果一个结点有右子树，那么它的下一个结点就是它的右子树的最左子结点
 * ②没有右子树的情况，如果结点是它父节点的左子节点，那么它的下一个结点就是它的父结点
 * ③如果一个结点既没有右子树，并且它还是它父结点的右子结点，可以沿着指向父结点的指针一直向上遍历，
 *   直到找到一个是它父结点的左子结点的结点
 */
public class GetNextNode {
    public TreeLinkNode getNext(TreeLinkNode pNode){
        if (pNode==null){
            return null;
        }
        TreeLinkNode pnext = null;
       //有右子树
        if (pNode.right!=null){
            TreeLinkNode rightTree = pNode.right;
            while (rightTree.left!=null){
                rightTree = rightTree.left;
            }
            return rightTree;
        }else if (pNode.next!=null){
            TreeLinkNode parent = pNode.next;
            while (parent!=null && parent.right == pNode){
                pNode = parent;
                parent = pNode.next;
            }
            pnext = parent;

            //这个不能通过
//            TreeLinkNode parent = pNode.next;
//            if (pNode.right==null&&parent.left == pNode){
//                return parent;
//            }
//            if (pNode.right==null&&parent.right==pNode){
//                    while (parent!=null&&parent.right==pNode){
//                        pNode = parent;
//                        parent = pNode.next;
//                }
//                return parent;
//            }
        }
        return pnext;
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

        GetNextNode getNextNode = new GetNextNode();
        System.out.println(getNextNode.getNext(g));

    }

}
