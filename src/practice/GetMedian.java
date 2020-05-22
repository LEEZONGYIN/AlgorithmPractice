package practice;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class GetMedian {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int count = 0;

    public void Insert(Integer num) {
        //个数为偶数的时候，先插到大堆顶，然后将大堆顶的最大数移动到小堆顶
        if (count%2==0){
            count++;
            maxHeap.offer(num);
            int temp = maxHeap.poll();
            minHeap.offer(temp);
        }else {
            //当个数为奇数的时候，先插到小堆顶，然后再将小堆顶最小的数移动到大堆顶
            count++;
            minHeap.offer(num);
            int temp = minHeap.poll();
            maxHeap.offer(temp);
        }
    }

    public Double GetMedian() {
        if (count%2==0){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else {
            return Double.valueOf(minHeap.peek());
        }
    }
}
