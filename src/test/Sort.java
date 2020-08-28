package test;

public class Sort {
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 冒泡
     * @param arr
     */
    public static void bubleSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            boolean flag = true;
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if (flag){
                break;
            }
            for(int k:arr){
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }

    /**
     * 选择
     * @param arr
     */
    public static void SelectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            if(i!=min){
                swap(arr,i,min);
            }
        }
    }

    /**
     * 插入
     * @param arr
     */
    public static void InsertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int temp = arr[i];
            int j=i;
            while (j>0 && arr[j-1]>temp){
                arr[j] = arr[j-1];
                j--;
            }
            if(i!=j){
                arr[j] = temp;
            }
        }
    }

    /**
     * 归并
     * @param arr
     */
    public static void MergeSort(int[] arr){
        sortProcess(arr,0,arr.length-1);
    }
    public static void sortProcess(int[] arr,int L,int R){
        if(L == R) return;
        int mid = L +(R-L)/2;
        sortProcess(arr,L,mid);
        sortProcess(arr,mid+1,R);
        merge(arr,L,mid,R);
    }
    public static void merge(int[] arr,int l,int mid,int r){
        int[] helper = new int[r-l+1];
        int p1 = l;
        int p2 = mid+1;
        int i=0;
        while (p1<=mid && p2<=r){
            helper[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            helper[i++] = arr[p1++];
        }
        while (p2<=r){
            helper[i++] = arr[p2++];
        }

        for(int j=0;j<helper.length;j++){
            arr[l+j] = helper[j];
        }
    }

    /**
     * 快排
     * @param
     */
    public static void QuickSort(int[] arr){
        sort(arr,0,arr.length-1);
    }
    public static void sort(int[] arr,int l,int r){
        if(l>=r) return;
        int partition = partition(arr,l,r);
        sort(arr,l,partition);
        sort(arr,partition+1,r);
    }
    public static int partition(int[] arr,int l,int r){
        int i=l;
        int j=r+1;
        int t = arr[l];
        while (true){
            while (arr[++i]<t && i != r);
            while (arr[--j]>t && j != l);
            if(i>=j) break;
            swap(arr,i,j);
        }
        swap(arr,l,j);
        return j;
    }

    /**
     * 堆排序
     * @param
     */

    public static void heapSort(int[] arr){
        if(arr.length==0 || arr==null) return;
        int len = arr.length;
        buildMaxHeap(arr,len);
        for(int i=len-1;i>0;i--){
            swap(arr,0,i);
            len--;
            heapify(arr,0,len);
        }
    }
    private static void buildMaxHeap(int[] arr, int len){
        //从最后一个非叶节点开始向前遍历，调整节点性质，使之成为大顶堆
        for (int i=(int)Math.floor(len/2)-1;i>=0;i--){
            heapify(arr,i,len);
        }
    }
    private static void heapify(int[] arr, int i,int len){
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        //小堆顶就将>改为<
        if(left<len && arr[left]>arr[largest]){
            largest = left;
        }
        if(right<len && arr[right]>arr[largest]){
            largest = right;
        }
        if(i != largest){
            swap(arr,i,largest);
            //因为互换之后，子节点的值变了，如果该子节点也有自己的子节点，仍需要调整
            heapify(arr,largest,len);
        }

    }

    public static void main(String[] args) {
        int[] arr = {5,6,9,1,3 ,8 ,4 ,2};
        bubleSort(arr);
////        insertSort(arr);
////        InsertSort(arr);
////        MergeSort(arr);
////        QuickSort(arr);
////        heapSort(arr);
////        for(int i:arr){
//            System.out.print(i+" ");
//        }
    }
}
