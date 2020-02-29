package practice;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.empty() || minStack.peek()>node){
            minStack.push(node);
        }else {
                minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (!stack.empty() && !minStack.empty()){
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
       return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(2);
        ms.push(1);
        ms.push(3);
        System.out.println(ms.min());
        System.out.println(ms.top());
        ms.pop();
        System.out.println(ms.top());
    }
}
