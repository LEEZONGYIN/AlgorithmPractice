package Algorithm.basic;

/**
 * 堆排序
 */

public class HeapSort {

    public static void heapSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int size = arr.length;

        while (size>0){
            swap(arr,0,size-1);
            heapify(arr,0,--size);

        }
    }

    //将无序数组变成大根堆
    public static void heapInsert(int[] arr,int index){
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }
    //index位置的值不满足大根堆，将index的值往下沉
    public static void heapify(int[] arr,int index,int heapSize){
        int left = index*2+1;
        while (left<heapSize){
            //比较左右子节点的大小
            //如果存在右节点并且右节点的值大于左节点的值，largest为left-1
            int largest = (left+1)<heapSize && arr[left+1]>arr[left]?
                    left+1:left;
            //左右比较的结果和父节点即index比较
            largest = arr[index]>arr[largest]?index:largest;
            //如果index还是最大的值，循环结束
            if (largest==index){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left=index*2+1;
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,9,8,5,6};
        heapSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
