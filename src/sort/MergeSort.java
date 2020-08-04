package sort;

public class MergeSort {

    public void mergeSort(int[] nums){
        mergeProcess(nums,0,nums.length-1);
    }

    public void mergeProcess(int[] nums,int L,int R){
        if(L==R) return;

        int mid = L+(R-L)/2;
        mergeProcess(nums,L,mid);
        mergeProcess(nums,mid+1,R);
        merge(nums,L,mid,R);
    }

    public void merge(int[] nums,int l,int m,int r){
        int[] helper = new int[r-l+1];
        int p1 = l;
        int p2 = m+1;
        int k = 0;

        while(p1<=m && p2<=r){
            helper[k++] = nums[p1]<nums[p2] ? nums[p1++] : nums[p2++];
        }

        while(p1<=m){
            helper[k++] = nums[p1++];
        }
        while (p2<=r){
            helper[k++] = nums[p2++];
        }

        for(int i=0;i<helper.length;i++){
            nums[l+i] = helper[i];
        }
    }

    public static void main(String[] args) {
        int [] arr={1,3,5,1,8,9,4,2};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
