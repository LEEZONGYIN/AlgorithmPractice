package Algorithm;

import java.util.Stack;

/**
 * 栈实现队列
 */
public class TwoStackQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public TwoStackQueue(){
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(Integer obj){
        pushStack.push(obj);
    }

    public Integer pop(){
       if (pushStack.empty()&&popStack.empty()){
           throw new RuntimeException("");
       }else if (popStack.empty()){
           while (!pushStack.empty()){
               popStack.push(pushStack.pop());
           }
       }
       return popStack.pop();
    }

    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.push(1);
        twoStackQueue.push(2);
        System.out.println(twoStackQueue.pop());
        System.out.println(twoStackQueue.pop());
    }
}
