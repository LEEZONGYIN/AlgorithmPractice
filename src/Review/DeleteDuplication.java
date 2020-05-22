package Review;

/**
 * 删除链表重复结点
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null){
            return null;
        }
        ListNode pre = new ListNode(0);
        ListNode cur = pHead;
        pre.next = cur;
        ListNode head = pre;

        while (cur!=null){
            if (cur.next!=null&&cur.val==cur.next.val){
                while (cur.next!=null&&cur.next.val==cur.val){
                    cur = cur.next;
                }
               pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = cur;
                cur=cur.next;
            }
        }
        return head.next;
    }

}
