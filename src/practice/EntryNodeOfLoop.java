package practice;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {

       ListNode fast = pHead;
       ListNode slow = pHead;

       while (fast!=null&&fast.next!=null){
           slow = slow.next;
           fast = fast.next.next;
           if(slow==fast){
               fast = pHead;
               while (fast != slow){
                   slow = slow.next;
                   fast = fast.next;
               }
               return fast;
           }
       }
        return null;
    }

    public static void main(String[] args) {
        EntryNodeOfLoop tnol = new EntryNodeOfLoop();
        ListNode node = new ListNode(1);
        System.out.println(tnol.EntryNodeOfLoop(node));
    }
}
