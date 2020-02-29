package practice;

import java.util.Stack;

public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA==null||popA==null){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        boolean res = false;
        int i=0;
        int j=0;
        while ( j<popA.length){
            while (stack.empty() || stack.peek()!=popA[j]){
                if (i>=pushA.length){
                    return false;
                }
                stack.push(pushA[i++]);
            }
            stack.pop();
            j++;
        }
        if (stack.empty()){
            res = true;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,3,5,2,1};
        IsPopOrder is = new IsPopOrder();
        System.out.println(is.IsPopOrder(push,pop));
    }
}
