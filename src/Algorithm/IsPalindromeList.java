package Algorithm;

import java.util.Stack;

/**
 * 判断一个链表是否回文链表
 */
public class IsPalindromeList {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }
    //不考虑空间复杂度，遍历链表，将链表存入栈，那么栈pop的值的顺序就是链表的逆序，与链表进行对比
    public static boolean isPalindromeList1(Node head){
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while (temp!=null){
            stack.push(temp.value);
            temp = temp.next;
        }

//        while (!stack.empty()){
//           if (head.value == stack.pop()){
//               head = head.next;
//           }else break;
//        }
//
//        if (stack.empty()){
//            return true;
//        }else return false;
        while (head!=null){
            if (head.value!= stack.pop()){
                return false;
            }else {
                head = head.next;
            }
        }
        return true;
    }

//准备两个指针，一个每次走一步，一个每次走两步，走两步的到达末尾后，一步的指针到达中间，
//把中间的指针后面的值入栈，然后和前半部分比较
    public static boolean isPalindromeList2(Node head){
        Node mid = head;
        Node two = head;
        while (two.next!=null){
            mid = mid.next;
            two = two.next.next;
        }
        Stack<Integer> stack = new Stack<>();
        while (mid!=null){
            stack.push(mid.value);
            mid = mid.next;
        }

        while (!stack.empty()){
            if (head.value!=stack.pop()){
                return false;
            }
            head = head.next;
        }

        return true;
    }
    //只需要O(1)复杂度的额外空间；用两个指针，一个一次走一步，另一个走两步，确定了中间位置后将后半部分的指针指向前一个节点，形成镜面
    // 然后分别对比两边的值
    public static boolean isPalindromeList3(Node head){

        Node n1 = head;
        Node n2 = head;
        while (n2.next!=null){
            n1 = n1.next;
            n2 = n2.next.next;
        }

        //将后半部分的指针反转
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while (n2!=null){
            n3 = n2.next;
            n2.next = n1;
            //将n1 n2往后移动
            n1 = n2;
            n2 = n3;
        }
        //
        n3 = n1; //将最后一个节点保存在n3，为后面再反转链表准备
        n2 = head;
        boolean res;
        while (n1!=null&&n2!=null){
            if (n1.value!=n2.value){
                res = false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        res = true;

        //将指针反转回去
        n1 = n3.next;
        n3.next = null;
        while (n2!=null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;

    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

//        System.out.println(isPalindromeList1(n1));
//        System.out.println(isPalindromeList2(n1));
        System.out.println(isPalindromeList3(n1));
    }

}
