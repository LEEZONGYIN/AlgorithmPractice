package practice;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null){
            return pHead;
        }

        //重点一：不能写成ListNode head = null，要new出一个新节点
        ListNode head = new ListNode(0);
        ListNode pre = head;
        ListNode cur = pHead;
        pre.next = cur;
        //重点二：head记录头结点（但是为什么可以这样还有疑惑）
        head.next = pHead;

        while (cur!=null){
            if (cur.next!=null&&cur.val == cur.next.val){
                while (cur.next!=null&&cur.val==cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        DeleteDuplication dd = new DeleteDuplication();
        System.out.println(dd.deleteDuplication(node1));
    }
}
