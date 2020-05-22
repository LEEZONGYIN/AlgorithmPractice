package 算法小抄.高频面试题;

import java.util.List;

public class ReverseK {
    //翻转[a,b)之间的节点
    public ListNode reverse(ListNode a,ListNode b){
        ListNode pre = null;
        ListNode cur = a;
        while (cur!=b){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    //K个一组翻转链表
    public ListNode reverseK(ListNode head,int k){
        if (head==null) return null;
        ListNode a = head;
        ListNode b = head;

        for (int i=0;i<k;i++){
            if(b==null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a,b);
        a.next = reverseK(b,k);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ReverseK reverseK = new ReverseK();
        ListNode res = reverseK.reverseK(node1,2);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
