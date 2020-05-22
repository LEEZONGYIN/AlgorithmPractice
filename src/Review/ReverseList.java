package Review;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head==null){
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode resNode = null;

        while (cur!=null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
            if (next==null){
                resNode = cur;
            }
        }

        return resNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ReverseList rl = new ReverseList();
        System.out.println(rl.ReverseList(node1).val);
    }
}
