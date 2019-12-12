package Algorithm;

public class PartitionArr {
    public static void main(String[] args) {
        int[] arr = {3,4,2,6,8,9,5};
        partArr(arr,5);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void partArr(int[] arr,int num){
        int x=-1;
        for (int i=0;i<arr.length;i++){
            if (arr[i]<=num){
                x++;
                swap(arr,x,i);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
