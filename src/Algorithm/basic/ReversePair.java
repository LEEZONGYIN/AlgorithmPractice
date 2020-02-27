package Algorithm.basic;

/**
 * 逆序对
 * 左边的数大于右边的数，这两个数为逆序对
 */
public class ReversePair {

    public static void main(String[] args) {
        int[] arr = {7,5,6,4};
        ReversePair reversePair = new ReversePair();
        reversePair.compareProcess(arr,0,arr.length-1);
        System.out.println("---------------------------");
        reversePair.method(arr);
    }

        private   void compareProcess(int[] arr,int L,int R){
        if (L==R){
            return;
        }
        int mid = (L+R)/2;
        compareProcess(arr,L,mid);
        compareProcess(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

        private void merge(int[] arr,int L,int mid,int R){
        int p1 = L;
        int p2 = mid+1;

        int[] temp = new int[R-L+1];
        int k=0;

        while (p1<=mid&&p2<=R){
            //如果p1处的值大于p2处的值，说明从p1到mid的值都大于p2处的值
            if (arr[p1]>arr[p2]){
                for (int i=p1;i<=mid;i++){
                    System.out.println(arr[i]+"-"+arr[p2]);
                }
                //将小的数放进辅助数组，完成排序
                temp[k++]=arr[p2++];
            }else {
                temp[k++]=arr[p1++];

            }
        }
        //将还没有进辅助数组的值放进辅助数组
        while (p1<=mid){
            temp[k++] = arr[p1++];
        }
        while (p2<=R){
            temp[k++] = arr[p2++];
        }
        for (int i=0;i<temp.length;i++){
            arr[L+i] = temp[i];
        }
    }

    //验证方法
    private   void method(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    System.out.println(arr[i]+"-"+arr[j]);
                }
            }
        }
    }
}
