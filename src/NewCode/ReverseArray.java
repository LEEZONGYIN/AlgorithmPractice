package NewCode;

//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
//思路：利用栈

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseArray {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack();
        while (listNode!=null){
            s.push(listNode.val);
            listNode = listNode.next;
        }
        while (!s.empty()){
            list.add( s.pop());
        }

        return list;

    }
}
