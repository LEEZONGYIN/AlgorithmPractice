package Algorithm;

/**
 * 选择排序
 * 0-n找一个最小的排到0位置
 * 1-n找一个最小的排到1位置
 * .....
 *
 */
public class SelectSort {
    public static void selectSort(int[] arr){
        if (arr==null ||arr.length<2){
            return;
        }
        for (int i=0;i<arr.length;i++){
            int minIndex = i;
            for (int j=i;j<arr.length;j++){
                if (arr[minIndex]>arr[j]){
                    minIndex=j;
                }
                swap(arr,i,minIndex);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr={1,3,5,2};
        selectSort(arr);
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
