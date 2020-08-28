package test;

public class topK {
    /**
     * 先随机取出N个数中的K个数，将这N个数构造为小顶堆，那么堆顶的数肯定就是这K个数中最小的数了，
     * 然后再将剩下的N-K个数与堆顶进行比较，如果大于堆顶，那么说明该数有机会成为TopK，就更新堆顶为该数，
     * 此时由于小顶堆的性质可能被破坏，就还需要调整堆；否则说明这个数最多只能成为Top K+1 th，因此就不用管它。
     * 然后就将下一个数与当前堆顶的数作比较，根据大小关系如上面所述方法进行操作，知道N-K个数都遍历完，
     * 此时还在堆中的K个数就是TopK了
     * @param
     */
    public void heapify(int[] arr,int i,int len){
        int left = i*2+1;
        int right = i*2+2;
        int less = i;
        if(left<len && arr[less]>arr[left]){
            less = left;
        }
        if(right<len && arr[less]>arr[right]){
            less = right;
        }
        if(i!=less){
            int temp = arr[i];
            arr[i] = arr[less];
            arr[less] = temp;
            heapify(arr,less,len);
        }
    }
    public void buildHeap(int[] arr,int len){
        for(int i = (int) (Math.floor(len/2)-1);i>=0;i--){
            heapify(arr,i,len);
        }
    }
    public void topK(int[] arr,int k){
        int[] res = new int[k];
        int i=0;
        for(;i<k;i++){
            res[i] = arr[i];
        }
        buildHeap(res,k);
        for(i=i+1;i<arr.length;i++){
            if(arr[i]>res[0]){
                 res[0] = arr[i];
                 heapify(res,0,k);
            }
        }
        for(int j:res){
            System.out.print(j+" ");
        }
    }

    /**
     *快排思想
     *
     */
    public int partition(int[] arr,int l,int r){
        int left = l;
        int right = r+1;
        int temp = arr[l];
        while(true){
            while(arr[++left]<=temp && left!=r);
            while(arr[--right]>=temp && right!=l);
            if(left>=right) break;
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
        }
        int t = arr[l];
        arr[l] = arr[right];
        arr[right] = t;
        return right;
    }
    public int topKQuickSort(int[] arr,int k){
        int par = partition(arr,0,arr.length-1);
        int tar = arr.length-k;
        while (par!=tar){
            if(par<tar){
                par = partition(arr,par+1,arr.length-1);
            }else{
                par = partition(arr,0,par-1);
            }
        }
        return arr[par];
    }

    public static void main(String[] args) {
        topK topK = new topK();
        int[] arr = {1,2,5,4,3,9,8,5};

        System.out.println(topK.topKQuickSort(arr,3));
    }
}
