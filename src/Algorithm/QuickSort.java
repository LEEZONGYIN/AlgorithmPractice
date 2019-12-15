package Algorithm;

public class QuickSort {

    public static void quickSort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr,int l,int r){
        //判断条件不能少
        if (l<r) {
            //切分点随机
            swap(arr, (int) (l+(Math.random()*(r-l+1))),r);
            int[] p = partition(arr, l,r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }


    public static int[] partition(int[] arr,int l,int r){
        int less=l-1;
        int more=r;
        while (l<more){
            if (arr[l]<arr[r]){
                swap(arr,++less,l++);
            }
            if (arr[l]>arr[r]){
                swap(arr,--more,l);
            }
            if (arr[l]==arr[r]){
                l++;
            }
        }
        //把最后那个当做切分点的数交换到相等的位置
        swap(arr,more,r);
        //返回中间相等部分的开始位置和结束位置
        return new int[]{less+1,more};
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,2,5,6,5};
        quickSort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}
