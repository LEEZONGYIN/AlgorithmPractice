package Algorithm;

/**
 * 用数组实现队列
 */
public class ArrayQueue {

    private Integer[] arr;
    private Integer start;
    private Integer end;
    private Integer size;

    public ArrayQueue(int initSize){
        arr = new Integer[initSize];
        start = 0;
        end = 0;
        size = 0;
    }

    //入队列
    public void push(Integer num){
        if (size== arr.length){
            throw new IndexOutOfBoundsException("数组已满");
        }
        size++;
        arr[end++] = num;
        //如果end到达数组末尾，但是数组未满，end 移动到顶端
        end = end==arr.length-1?0:end+1;
    }

    //出队列
    public Integer pop(){
        if (size==0){
            throw new IndexOutOfBoundsException("数组为空");
        }
        //先保存start所在的位置，因为接下来要对start进行调整
        int temp = start;
        start = start == arr.length-1?0:start+1;
        return arr[temp];
    }

}
