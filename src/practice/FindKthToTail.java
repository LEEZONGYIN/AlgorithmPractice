package practice;

import java.util.HashMap;
import java.util.Map;


/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        Map<Integer,ListNode> map = new HashMap<>();

        int count = 1;
        while (head!=null){
            map.put(count,head);
            count++;
            head = head.next;
        }
        return map.get(count-k);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        FindKthToTail findKthToTail = new FindKthToTail();
        System.out.println(findKthToTail.FindKthToTail(node1,4));
    }
}
