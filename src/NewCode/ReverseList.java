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
            //存放头结点的下一个节点
            next = head.next;
            //pre表示前置节点，因此反转链表的头结点的下一个节点是前置节点
            head.next = pre;
            //头结点为前置节点
            pre = head;
            //移动到下一个节点
            head = next;
        }

        return pre;
    }

    //递归
    public static ListNode reverseList2(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode newList = reverseList2(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return newList;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//
        ReverseList reverseList = new ReverseList();

        System.out.println(reverseList.ReverseList(node1).val);
//        System.out.println(reverseList2(node1).val);
    }


}
