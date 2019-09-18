package LeetCode;

/**
 * 简单选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = {5,8,1,6,4,9};
        SelectSort ss = new SelectSort();
        ss.selectSort(a);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
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
}
