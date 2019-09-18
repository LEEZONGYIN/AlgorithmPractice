package LeetCode;

/**
 * 冒泡排序
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] a = {5,8,1,6,4,9};
        BubbleSortTest test = new BubbleSortTest();
        test.bubbleSort(a);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
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
}
