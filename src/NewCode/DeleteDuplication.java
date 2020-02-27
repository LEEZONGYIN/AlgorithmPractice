package NewCode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null ){
            return null;
        }
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pPreNode = head;
        ListNode pNode = pHead;

        while (pNode!=null){
            if (pNode.next!=null&&pNode.val == pNode.next.val){
                //找到最后一个重复节点
                while (pNode.next!=null&&pNode.val == pNode.next.val){
                    pNode = pNode.next;
                }
                pPreNode.next = pNode.next;
                pNode = pNode.next;
            }else {
                pPreNode = pPreNode.next;
                pNode = pNode.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        DeleteDuplication deleteDuplication = new DeleteDuplication();
        System.out.println(deleteDuplication.deleteDuplication(node1).val);
    }
}

