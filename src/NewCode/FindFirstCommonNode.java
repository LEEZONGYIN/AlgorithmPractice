package NewCode;


import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    //方法一：若两个链表有公共节点，则从从公共节点到最后的节点相同，
    //因此将两个链表入两个栈，从栈顶节点出栈比较，节点相同再比较下一个，
    //最后相同的节点就是公共节点
    public static ListNode findFirstCommonNode1(ListNode pHead1, ListNode pHead2){
        if(pHead1==null||pHead2==null){
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (pHead1.next!=null){
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2.next!=null){
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode res = null;
        while (!stack1.empty()||!stack2.empty()){
            if (stack1.peek()==stack2.peek()){
                res = stack1.pop();
                stack2.pop();
            }
            if (stack1.peek()!=stack2.peek()){
                return res;
            }
        }
        return res;
    }
    //先通过遍历获得两个链表的长度，然后让长的链表先移动多出的部分，比如长度为7和5的链表，7的链表先走两步
    //然后两个链表一起走，走到第一个节点相同的地方的节点为公共节点
    public static ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2){

        if (pHead1==null||pHead2==null){
            return null;
        }

        int len1 = 0;
        int len2 = 0;

        //为了不改变头结点，赋值给变量，让变量遍历，如果用头结点遍历，遍历结束，pHead==null
        ListNode p1 = pHead1;
        while (p1!=null){
            len1++;
            p1 = p1.next;
        }
        ListNode p2 = pHead2;
        while (p2!=null){
            len2++;
            p2 = p2.next;
        }
        int sub = Math.abs(len1-len2);
        ListNode longNode = pHead1;
        ListNode shortNode = pHead2;
        longNode = len1>len2?pHead1:pHead2;
        shortNode = len1>len2?pHead2:pHead1;

        while (sub>0){
            longNode=longNode.next;
            sub--;
        }
        while (shortNode!=null){
            if (longNode == shortNode){
                return longNode;
            }else {
                longNode = longNode.next;
                shortNode = shortNode.next;
            }
        }

        return null;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode( 5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node6.next = node7;
        node7.next = node8;
        node8.next = node4;


        System.out.println(findFirstCommonNode2(node1,node6).val);
    }
}
