package Algorithm.basic;

/**
 * 将单向链表按某值划分为左边小，中间相等，右边大的形式
 * 荷兰国旗的链表形式
 */
public class SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //方法一：将链表存入数组，然后按照荷兰国旗的方法划分
    public static Node listPartition1(Node head,int num){
        if (head==null){
            return null;
        }

        Node cur = head;
        int i=0;
        while (cur!=null){
            i++;
            cur = cur.next;
        }
        Node[] arryNode = new Node[i];
        cur = head;
        //将链表转换为数组
        for (int j=0;j<i;j++){
            arryNode[j] = cur;
            cur = cur.next;
        }
        arryPartition(arryNode,num);
        //将数组再转换为链表
        for (int j=1;j<arryNode.length;j++){
            arryNode[j-1].next = arryNode[j];
        }
        arryNode[i-1].next = null;

        return arryNode[0];
    }

    public static void arryPartition(Node[] arryNode,int num){
        int x=-1;
        int y = arryNode.length;
        int cur=0;

        while (cur<y){
           if (arryNode[cur].value<num){
               swap(arryNode,++x,cur++);
           }else if (arryNode[cur].value>num){
               swap(arryNode,--y,cur);
           }else if (arryNode[cur].value==num){
               cur++;
           }
        }

    }

    public static void swap(Node[] arr,int i,int j){
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //方法二：将链表分发到大中小三个链表中，再将三条链表按顺序头尾相连
    public static Node listPartition2(Node head,int num){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;

        while (head != null){
            next = head.next; //存放head的next
            head.next = null; //将当前节点变成单个Node，分发到对应链表
            if (head.value<num){
                if (sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head; //sT向后加一个节点
                    sT = head; //最后一位是当前节点
                }
            }else if (head.value == num){
                if (eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else {
                if (bH == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        //将三个链表连接
        if (sT != null){
            sT.next = eH;
            eT = eT==null?sT:eT;
        }
        if (eT != null){
            eT.next = bH;
        }

        //返回
        if (sH != null){
            return  sH;
        }else if (eH!=null){
            return eH;
        }else {
            return bH;
        }
    }


    public static void printNode(Node head){
        while (head!=null){
            System.out.print(head.value+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);

        printNode(head1);

//        Node node = listPartition1(head1,5);
        Node node1 = listPartition2(head1,5);
        printNode(node1);

    }

}
