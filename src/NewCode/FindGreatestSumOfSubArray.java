package NewCode;

/**
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray {
    public static int findGreatestSunOfSubArray(int[] array){
        if (array.length<1){
            return 0;
        }
        int curSum=0;
        int greatestSum = Integer.MIN_VALUE;

        for (int i=0;i<array.length;i++){
            if(curSum<=0){
                //如果从(0-3)累加的和小于0，抛弃该和，4开始
                curSum = array[i];
            }else {
                curSum+=array[i];
            }
            if (curSum>greatestSum){
                greatestSum = curSum;
            }
        }
        return greatestSum;
    }

    public static void main(String[] args) {
        int [] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(findGreatestSunOfSubArray(array));
    }
}
