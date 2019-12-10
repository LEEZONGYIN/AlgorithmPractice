package Algorithm;

public class InsertSort {
    public static void insertSort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        //i表示i将要插入前面有序的数中，即i以前的数均有序
        for (int i=1;i<arr.length;i++){
            for (int j=i-1;j>=0&&arr[j]>arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int [] arr={6,3,5,4,9,10};
        insertSort(arr);
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
