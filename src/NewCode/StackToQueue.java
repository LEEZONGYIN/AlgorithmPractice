package NewCode;

import java.util.Stack;

public class StackToQueue {
//    用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    /**
     * 思路：push：就是将值存入stack1
     *      pop：先判断stack2中有没有值，有的话将stack2顶部的值弹出，没有则判断stack1中有没有值，
     *           有的话将stack1中的值push到stack2中
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        int a;
        if(stack2.empty()){
            while(!stack1.empty()){
                a=stack1.peek();
                stack2.push(a);
                stack1.pop();
            }
        }
        a=stack2.peek();
        stack2.pop();
        return a;
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.push(1);
        stackToQueue.push(2);
        System.out.println(stackToQueue.pop());
        stackToQueue.push(3);
        System.out.println(stackToQueue.pop());
    }
}
