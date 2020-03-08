package practice;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if (array==null){
            return 0;
        }
        int count = 0;
        for (Integer i:array){
            if (i==k){
                count++;
            }
        }
        return count;
    }
}
