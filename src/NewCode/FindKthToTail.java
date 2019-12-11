package NewCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        Map<Integer,ListNode> map = new HashMap<>();
        int count = 0;
        while (head != null){
            count++;
            map.put(count,head);
            head = head.next;

        }


        return map.get(count-k+1);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        FindKthToTail findKthToTail = new FindKthToTail();
        System.out.println(findKthToTail.FindKthToTail(listNode1,3).val);
    }
}
