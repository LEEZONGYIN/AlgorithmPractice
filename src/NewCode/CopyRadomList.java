package NewCode;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 *（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

public class CopyRadomList {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead==null) return null;
        //1.复制当前节点，并插入到该节点后面
        RandomListNode currentNode = pHead;
        while (currentNode!=null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next=nextNode;
            currentNode=nextNode;
        }

        //复制特殊指针
        currentNode = pHead;
        while (currentNode!=null){
            currentNode.next.random=currentNode.random==null?null:currentNode.random.next;
            currentNode=currentNode.next.next;
        }

        //拆分链表
        currentNode = pHead;
        RandomListNode pCloneNode = pHead.next;
        while (currentNode!=null){
            RandomListNode cloneNode = currentNode.next;
            currentNode.next=cloneNode.next;
            cloneNode.next=cloneNode.next==null?null:cloneNode.next.next;
            currentNode=currentNode.next;
        }
        return pCloneNode;
    }
}
