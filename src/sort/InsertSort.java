package sort;

import java.util.Arrays;

public class InsertSort {
    public int[] sort(int[] array){
        int[] arr = Arrays.copyOf(array,array.length);

        for(int i=1;i<arr.length;i++){
            int temp = arr[i];
            int j=i;
            while (j>0&&temp<arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            if(j!=i){
                arr[j] = temp;
            }
        }

        for(int a:arr){
            System.out.print(a+" ");
        }
        return arr;
    }

    public int[] sort2(int[] array){
        for(int i=1;i<array.length;i++){
            int j=i;
            while (j>0 && array[j]<array[j-1]){
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }
            for(int a:array){
                System.out.print(a+" ");
            }
            System.out.println();
        }

        return array;
    }

    public static void main(String[] args) {
      InsertSort insertSort = new InsertSort();
      int[] arr = {25,84,21,47,15,27,68,35,20};
      insertSort.sort2(arr);
    }
}
