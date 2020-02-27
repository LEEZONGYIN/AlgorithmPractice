package Algorithm.basic;

/**
 * 归并排序
 * 从中间分，将左右两边分别排好序，然后创建辅助数组，左右依次比较，小的数放进辅助数组
 */

public class MergeSort {

    public static void mergeSort(int[] arr){
        sortProcess(arr,0,arr.length-1);
    }

    public static void sortProcess(int[] arr,int L,int R){
        if (L==R){
            return ;
        }
        //中点
        int mid = (L+R)/2;
        sortProcess(arr,L,mid);
        sortProcess(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] helper = new int[r-l+1];
        int p1=l;
        int p2=mid+1;
        int i=0;
        while (p1<=mid&&p2<=r){
            helper[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            helper[i++]=arr[p1++];
        }
        while (p2<=r){
            helper[i++]=arr[p2++];
        }

        for (int j=0;j<helper.length;j++){
            arr[l+j]=helper[j];
        }

    }

    public static void main(String[] args) {
        int [] arr={1,3,5,2};
        mergeSort(arr);
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
