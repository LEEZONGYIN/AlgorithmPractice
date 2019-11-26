package NewCode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

public class ListMerge {
    public ListNode Merge(ListNode list1,ListNode list2) {

        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }

        ListNode temp = null;
        if (list1.val<list2.val){
            temp = list1;
            temp.next = Merge(list1.next,list2);
        }else if (list2.val<list1.val){
            temp = list2;
            temp.next = Merge(list1,list2.next);
        }
        return temp;
    }

    public static void main(String[] args) {

    }
}
