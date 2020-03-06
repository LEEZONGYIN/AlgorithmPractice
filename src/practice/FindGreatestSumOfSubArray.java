package practice;

/**
 * {6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length<=0){
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i=0;i<array.length;i++){
            if (curSum<=0){
                curSum = array[i];
            }else {
               curSum += array[i];
                }
                if (curSum>maxSum){
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        FindGreatestSumOfSubArray find = new FindGreatestSumOfSubArray();
        System.out.println(find.FindGreatestSumOfSubArray(arr));
    }
}
