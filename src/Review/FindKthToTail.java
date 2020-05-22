package Review;

public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null||k<=0){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        for (int i=0;i<=k-1;i++){
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
