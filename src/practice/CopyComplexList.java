package practice;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CopyComplexList {
    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead==null){
            return null;
        }

        RandomListNode curNode = pHead;
        //先复制每个节点
        while (curNode!=null){
            RandomListNode next = curNode.next;
            RandomListNode node = new RandomListNode(curNode.label);
            curNode.next = node;
            node.next = next;

            curNode = next;
        }
        //找到random
        curNode = pHead;
        while (curNode!=null){
            RandomListNode curRandom = curNode.random;
            RandomListNode copyNode = curNode.next;
            copyNode.random = curRandom==null?null:curRandom.next;

            curNode = curNode.next.next;
        }

        //拿出复制的链表
        curNode = pHead;
        RandomListNode rHead = pHead.next;
       while (curNode!=null){
           RandomListNode copyNode = curNode.next;
           curNode.next = copyNode.next;
           copyNode.next = curNode.next==null?null:curNode.next.next;

           curNode = curNode.next;
       }
        return rHead;

    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3;
        node2.random = node2;
        node3.random = null;

        CopyComplexList copyComplexList = new CopyComplexList();
        System.out.println(copyComplexList.Clone(node1).next.random.label);
    }
}
