package Algorithm.basic;

/**
 * 打印两个有序链表的公共部分
 */
public class PrintCommonPart {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    public static void printCommon(Node n1,Node n2){

        if (n1 == null|| n2==null){
            return;
        }

        if (n1.value<n2.value){
            n1 = n1.next;
        }else if (n1.value>n2.value){
            n2 = n2.next;
        }else if (n1.value == n2.value){
            System.out.println(n1.value);
            n1 = n1.next;
            n2 = n2.next;
        }
    }

    public static void main(String[] args) {

    }

}
