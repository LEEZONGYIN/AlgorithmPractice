package Algorithm;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基础功能上，再实现返回栈的最小元素操作，push pop getMin复杂度都是O(1),可以使用现成的栈结构
 *
 * 思路：创建一个最小值栈，在压栈过程中，当前值与最小值栈的栈顶比较，如果该值比最小值栈的栈顶值小，压入最小值栈，否则压入最小值栈的栈顶
 */
public class MinStack {
    Stack<Integer> myStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(Integer obj){
        minStack.push(obj);
        if (minStack.empty()){
            minStack.push(obj);
        } else if (obj<minStack.peek()){
            minStack.push(obj);
        }else {
            minStack.push(minStack.peek());
        }
    }

    public Integer pop(){
        if (!myStack.empty()&&!minStack.empty()){
            //min栈要一起pop
            minStack.pop();
            return myStack.pop();
        }else {
            throw new IndexOutOfBoundsException("");
        }
    }
    public Integer getMin(){
        return minStack.peek();
    }
}
