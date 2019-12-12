package Algorithm;

public class NetherlandFlag {
    public static void netherlandFlag(int[] arr,int l,int r,int num){
        int x=-1;
        int y=arr.length;

        while (l<y){ //
           if(arr[l]<num){
               swap(arr,++x,l++);
           }else if (arr[l]>num){
               swap(arr,--y,l);
           }else {
               l++;
           }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int arr[] = {3,5,4,7,2,6,9,8,2,1,4,8,5,6,4,5};
        netherlandFlag(arr,0,arr.length-1,5);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
