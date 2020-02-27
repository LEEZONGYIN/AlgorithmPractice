package NewCode;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length<0){
            return 0;
        }
        int firstK = findFirstNumberOfK(array,0,array.length-1,k);
        if (firstK<0){
            return 0;
        }
        int endK = 0;
        for (int i=firstK;i<=array.length-1;i++){
           if (array[i]==k){
               endK++;
           }
        }
        return endK;
    }

    //递归写法
    public static int findFirstNumberOfK(int[] arr,int start,int end,int k){
        if (start>end){
            return -1;
        }
        //注意求中间值
        int mid = (end+start)/2;
        if (arr[mid]<k){
            return findFirstNumberOfK(arr,mid+1,end,k);
        }else if (arr[mid]>k){
            return findFirstNumberOfK(arr,start,mid-1,k);
        }else if (mid-1>=0&&arr[mid-1]==k){
            //当arr[mid]==k时，还要继续判断该K是不是第一个K
            return findFirstNumberOfK(arr,start,mid-1,k);
        }else {
            return mid;
        }

    }

    //循环方式
    public static int findFirstNumberOfK2(int[] arr,int start,int end,int k){
        while (start<=end){
            int mid = (start+end)/2;
            if (arr[mid]>k){
                end=mid-1;
            }else if (arr[mid]<k){
                start = mid+1;
            }else if (mid-1<end&&arr[mid-1]==k){
                end = mid-1;
            }else {
                return mid;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,4,5};
        System.out.println(findFirstNumberOfK2(arr,0,arr.length-1,3));
    }
}
