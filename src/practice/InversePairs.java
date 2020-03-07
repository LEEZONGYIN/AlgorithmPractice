package practice;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {
    int count = 0;
    public int InversePairs(int [] array) {
        if (array==null){
            return 0;
        }
        divide(array,0,array.length-1);
        return count;
    }

    public void divide(int[] array,int start,int end){
        if (start>=end){
            return;
        }

        int mid = start + (end-start)/2;

        divide(array,start,mid);
        divide(array,mid+1,end);

        merge(array,start,mid,end);
    }

    public void merge(int[] array,int start,int mid,int end){
        int[] temp = new int[end-start+1];

        int i=start;
        int j = mid+1;
        int k=0;
        while (i<=mid&&j<=end){
            if (array[i]<=array[j]){
                temp[k++] = array[i++];
            }else {
                temp[k++] = array[j++];
                count = (count+ (mid-i+1))%1000000007;
            }
        }
        if (i<=mid){
            while (i<=mid){
                temp[k++] = array[i++];
            }
        }
        if (j<=end){
            while (j<=end){
                temp[k++] = array[j++];
            }
        }
        for (k=0;k<temp.length;k++){
            array[start++] = temp[k];
        }
    }

    public static void main(String[] args) {
        InversePairs ip = new InversePairs();
        int[] arr = {1,2,3,4,5,6,7,0};
        System.out.println(ip.InversePairs(arr));
    }
}
