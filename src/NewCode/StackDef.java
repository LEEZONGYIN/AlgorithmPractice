package NewCode;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class StackDef {

    Stack<Integer> stack = new Stack();
    Stack<Integer> minStack = new Stack();


    public void push(int node) {
        stack.push(node);
        if (minStack.size()==0||minStack.peek()>node){
            minStack.push(node);
        }else {
            minStack.push(minStack.peek());
        }

    }

    public void pop() {
        if (stack.size()>0&&minStack.size()>0){
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
        StackDef sd = new StackDef();
        sd.push(1);
        sd.push(3);
        sd.push(2);
        sd.push(4);
        System.out.println(sd.min()+ " "+sd.top());


    }
}
