package sort;

import java.util.Arrays;

public class SelectSort {
    public int[] sort(int[] array){
        int[] arr = Arrays.copyOf(array,array.length);
        for(int i=0;i<arr.length-1;i++){
            int min = i;
            for(int j = i+1;j<arr.length;i++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }

            if(min!=i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        for (int a:arr){
            System.out.println(a+" ");
        }
        return arr;
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] arr = {2,4,3,8,1};
        selectSort.sort(arr);
    }
}
