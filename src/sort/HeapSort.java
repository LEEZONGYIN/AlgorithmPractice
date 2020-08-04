package sort;

/**
 * 堆排序
 * 1. 首先将数组构造成大根堆
 * 2. 交换堆顶和末尾的数，即最大的数来到末尾
 * 3. 对除了最大的数以外的其他数重新进行调整
 * 4. 重复二三步
 */
public class HeapSort {
    public void sort(int[] nums){
        //先组成大根堆
        for(int i=0;i<nums.length;i++){
            heapInsert(nums,i);
        }
        //排序
        int size = nums.length;
        swap(nums,0,--size);
        while (size>0){
            sink(nums,0,size);
            swap(nums,0,--size);
            for(int i:nums){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public void heapInsert(int[] nums,int index){
        while(nums[index]>nums[(index-1)/2]){
            swap(nums,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public void sink(int[] nums,int index,int size){
        int left = index*2+1;
        while(left<size){
            //右孩子存在的话，找到左右孩子中的最大值
            int largest = (left+1)<size && nums[left]<nums[left+1]? left+1:left;
            //和index比较
            largest = nums[index] > nums[largest]?index:largest;

            if(largest==index) break;
            swap(nums,index,largest);
            index = largest;
            left = index*2+1;
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {25,84,21,47,15,27,68,35,20};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
//        for(int i:arr){
//            System.out.print(i+" ");
//        }
    }
}
