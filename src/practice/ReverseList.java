package practice;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = null;
        ListNode reverseHead = null;
        ListNode pNode = head;
        while (pNode!=null){
            ListNode next = pNode.next;
            if (pNode.next == null){
                reverseHead = pNode;
            }
            pNode.next = pre;

            pre = pNode;
            pNode = next;
        }
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ReverseList reverseList = new ReverseList();
        System.out.println(reverseList.ReverseList(node1).val);
    }
}
