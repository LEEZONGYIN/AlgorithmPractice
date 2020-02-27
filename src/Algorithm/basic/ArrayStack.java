package Algorithm.basic;

/**
 * 用一个数组实现栈
 */
public class ArrayStack {
    private Integer[] arr;
    private Integer index;

    public ArrayStack(int initSize)  {
        if (initSize<=0){
            throw new IllegalArgumentException("size < 0");
        }
        arr = new Integer[initSize];
        index = 0;
    }

    public Integer peek(){
        if(index==0){
            throw new IndexOutOfBoundsException("数组为空");
        }
        return arr[index-1];
    }

    public void push(Integer num){
        if (index == arr.length){
            throw new ArrayIndexOutOfBoundsException("数组已满");
        }
        arr[index++] = num;
    }

    public Integer pop() {
        if (index == 0) {
            return null;
        }
        return arr[--index];
    }
}
