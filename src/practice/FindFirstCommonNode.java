package practice;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int len1 = 0;
        int len2 = 0;

        ListNode p1 = pHead1;
        while (p1!=null){
            p1 = p1.next;
            len1++;
        }
        ListNode p2 = pHead2;
        while (p2!=null){
            p2 = p2.next;
            len2++;
        }

        int len = Math.abs(len1-len2);
        p1 = len1>len2?pHead1:pHead2;
        p2 = len2<len1?pHead2:pHead1;

        for (int i=0;i<len;i++){
            p1 = p1.next;
        }
        while (p1!=null &&p2!=null){
            if (p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2= p2.next;
        }
        return null;
    }
}
