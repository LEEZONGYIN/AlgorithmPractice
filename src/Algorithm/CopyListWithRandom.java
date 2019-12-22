package Algorithm;

import java.util.HashMap;

/**
 *  复制含有随机指针节点的链表
 */
public class CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node copyListWithRandom(Node head){
        //将当前节点存入HashMap,key 为当前节点，value为复制节点
        HashMap<Node,Node> copyList = new HashMap<>();
        Node cur = head;
        while (cur != null){
            copyList.put(cur,new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        while (cur !=null){
            //复制的节点的next节点就是 key节点的next节点的value
            copyList.get(cur).next = copyList.get(cur.next) ;
            //random指针同理
            copyList.get(cur).rand = copyList.get(cur.rand) ;
            cur = cur.next;
        }

        return copyList.get(head);
    }

    private static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("cur ");
        while (cur != null){
            System.out.print(cur.value+" ");
            cur = cur.next;
        }
        System.out.println();

        cur = head;
        System.out.print("random ");
        while (cur!=null){
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRandom(head);
        printRandLinkedList(res1);
    }


}
