package 算法小抄.动态规划;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出很多形如 [start, end] 的闭区间，请你设计一个算法，算出这些区间中最多有几个互不相交的区间
 */
public class IntervalSchedule {
    public int countIntervalSchedule(int[][] intervels){

        if (intervels.length==0){
            return 0;
        }
        Arrays.sort(intervels, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        //至少有一个区间
        int count=1;
        int end = intervels[0][1];
        for (int[] interal:intervels){
            //只有下一个的头大于当前的尾，区间才不相交
            if (interal[0]>=end){
                count++;
                //更新尾部
                end = interal[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] ints = {{1,3},{2,4},{5,6}};
        IntervalSchedule is = new IntervalSchedule();
        System.out.println(is.countIntervalSchedule(ints));
    }
}
