package Review;

/**
 * 数组中的逆序对
 *
 */
public class InversePairs {
    int count=0;
    public int InversePairs(int [] array) {
        if (array.length==0){
            return 0;
        }
        divide(array,0,array.length-1);
        return count;
    }

    public void divide(int[] array,int start,int end){
        if (start>=end){
            return;
        }
        int mid = start+(end-start);
        divide(array,start,mid);
        divide(array,mid+1,end);

        merge(array,start,mid,end);
    }

    public void merge(int[] array,int start,int mid,int end){
        int[] temp = new int[end-start+1];

        int k=0;
        int i = start;
        int j= mid +1;
        while (i<=start&&j<=end){
            if (array[i]<array[j]){
                temp[k++] = array[i++];
            }else {
                count += mid-i+1;
                temp[k++] = array[j++];
            }
        }
        if (i<=start){
            while (i<=start){
                temp[k++] = array[i++];
            }
        }
        if (j<=end){
            while (j<=end){
                temp[k++] = array[j++];
            }
        }
        for (k=0;k<temp.length;i++){
            array[start+k] = temp[k];
        }
    }
}
