package 算法小抄.数据结构;

import java.util.List;

public class ReverseList {


    //递归翻转整个链表
    public ListNode reverse(ListNode head){
        if (head.next==null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    //翻转前n个链表 n < 链表长度
    //后驱结点
    ListNode successor = null;
    public ListNode reverseN(ListNode head,int n){
        if (n==1){
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head,int m,int n){
        if (m==1){
            return reverseN(head,n);
        }
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
         node1.next = node2;
        node2.next = node3;
        node3.next= node4;

        ReverseList rl = new ReverseList();
        ListNode res = rl.reverseBetween(node1,2,3);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}
