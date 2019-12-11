package NewCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    public ListNode ReverseList(ListNode head) {

        ListNode pre =null;
        ListNode next = null;

        if (head==null){
            return null;
        }
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
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
