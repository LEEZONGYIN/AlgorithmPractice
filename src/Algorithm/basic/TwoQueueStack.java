package Algorithm.basic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 */
public class TwoQueueStack {
    private Queue<Integer> data;
    private Queue<Integer> help;

    public TwoQueueStack(){
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(Integer obj){
        data.add(obj);
    }

    public Integer pop(){
        //将data队列的数留下最后一个，其他入help栈，弹出data栈的最后一个数；help栈同理，总之就是两个栈来回倒
        if (data.size()>0) {
            for (int i = 0; i < data.size() - 1; i++) {
                help.add(data.poll());
            }
            return data.poll();
        }else {
            for (int i=0;i<help.size()-1;i++){
                data.add(help.poll());
            }
            return help.poll();
        }
    }

    public static void main(String[] args) {
        TwoQueueStack twoQueueStack = new TwoQueueStack();
        twoQueueStack.push(1);
        twoQueueStack.push(2);
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());
    }
}
