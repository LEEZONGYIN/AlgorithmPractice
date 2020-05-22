package Review;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array){
        if(array.length==0) return 0;

        int p1 = 0;
        int p2 = array.length-1;
        int mid = p1;
        while (array[p1]>=array[p2]){
            if (p2-p1 == 1){
                mid = p2;
                break;
            }
            mid = (p2+p1)/2;
            if (array[p1]==array[p2]&&array[mid]==array[p1]){
                return minInOrder(array);
            }
            if (array[mid]>=array[p1]){
                p1 = mid;
            }else if (array[mid]<=array[p2]){
                p2=mid;
            }

        }
        return array[mid];
    }

    private int minInOrder(int[] array) {
        int res=Integer.MAX_VALUE;
        for (int i=0;i<array.length;i++){
            res = Math.min(res,array[i]);
        }
        return res;
    }
}
