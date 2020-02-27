package Algorithm.basic;

/**
 * 给定一个数组，如果排序后，相邻两数的最大差值，返回该差值，不能用基于比较的排序。
 * 思路：桶排序
 */
public class MaxGap {
    public static int maxGap(int[] arr){

        int len = arr.length;
        //变量数组，得到最大最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            min = min<arr[i]?min:arr[i];
            max = max>arr[i]?max:arr[i];
        }

        if(max==min){
            return 0;
        }

        boolean[] hasNum = new boolean[len+1];
        int[] maxs = new int[len+1];
        int[] mins = new int[len+1];
        int bid = 0;
        //得到每个桶的最大值和最小值
        for (int i=0;i<arr.length;i++){
            bid = bucket(arr[i],len,max,min);
            maxs[bid] = hasNum[bid]?Math.max(maxs[bid],arr[i]):arr[i];
            mins[bid] = hasNum[bid]?Math.min(mins[bid],arr[i]):arr[i];
            hasNum[bid] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        //相邻两个桶，左边桶的最大值和右边桶的最小值为相邻两个数，最大的差值就在这两个数的差值中产生
        for (;i<=len;i++){
            if (hasNum[i]){
                res = Math.max(res,(mins[i]-lastMax));
                lastMax = maxs[i];
            }
        }

        return res;

    }


    //确定该数在哪个桶
    public static int bucket(long num,long len,long max,long min){
        return (int) ((num-min)*len/(max-min));
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5,1,8,4};
        System.out.println(maxGap(arr));
    }
}
