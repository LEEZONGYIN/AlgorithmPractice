package NewCode;

/**
 * 一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 算法：准快慢两个指针，快指针一次走两步，慢指针一次走一步，若有环，则两个指针相遇时，将快指针指到头结点，
 *       然后两个指针再每次走一步，当再次相遇时就是环的入口节点。
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode p1 = pHead;
        ListNode p2 = pHead;

        //注意当没有环的情况的处理方式
        while (p2 !=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                    p2 = pHead;
                    while (p1 != p2) {
                        p1 = p1.next;
                        p2 = p2.next;
                    }
                    return p1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

//        node1.next = node2;
//        node2.next = node3;

        EntryNodeOfLoop entryNodeOfLoop = new EntryNodeOfLoop();
        System.out.println(entryNodeOfLoop.EntryNodeOfLoop(node1));
    }
}
