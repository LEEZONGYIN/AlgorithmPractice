package LeetCode;

public class SortCollection {
    public static void main(String[] args) {
        int[] a = {5,3,4,6,2};
        SortCollection sc = new SortCollection();
        sc.insertSort(a);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }


    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=arr.length-1;j>i;j--){
                if (arr[j-1]>arr[j]){
                    int temp;
                    temp = arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
    /**
     * 简单插入排序
     */
    public void selectSort(int[] arr){
        int min;
        for (int i=0;i<arr.length;i++){
            min = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[min]>arr[j]){
                    int temp;
                    temp = arr[min];
                    arr[min] = arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    /**
     * 直接插入排序
     */
    public void insertSort(int[] arr){
        int temp=0;
        for (int i=1;i<arr.length;i++){
            if (arr[i]<arr[i-1]){
                temp = arr[i];
                for (int j=i-1;j>=0&&arr[j]>temp;j--){
                    arr[j+1]=arr[j];
                    arr[j]=temp;

                }
            }
        }
    }

}
