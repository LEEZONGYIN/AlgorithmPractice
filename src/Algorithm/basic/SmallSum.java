package Algorithm.basic;

/**
 * 小和问题
 */
public class SmallSum {

    public static int mergeSort(int[] arr,int L,int R){
        if(L==R){
            return 0;
        }
        int mid = (L+R)/2;
        return mergeSort(arr,L,mid) //左侧产生的小和
                +mergeSort(arr,mid+1,R) //右侧产生的小和
                +merge(arr,L,mid,R); //merge过程中产生的小和
    }

    public static int merge(int[] arr,int L,int mid,int R){
        int[] help = new int[R-L+1];
        int i=0;
        int p1=L;
        int p2=mid+1;
        int res=0;
        while (p1<=mid&&p2<=R){
            res += arr[p1]<arr[p2]?(R-p2+1)*arr[p1]:0;
            help[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=R){
            help[i++] = arr[p2++];
        }
        for (i=0;i<help.length;i++){
            arr[L+i]=help[i];
        }

        return res;
    }
}
