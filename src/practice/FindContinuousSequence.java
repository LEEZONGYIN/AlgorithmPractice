package practice;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (sum<=0){
            return lists;
        }

        int small = 1;
        int big = 2;
        int curSum = 3;
        while (small<=(sum+1)/2){
            if (curSum<sum){
                big++;
                curSum+=big;
            }else if (curSum>sum){
                curSum-=small;
                small++;
            }else if (curSum==sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=small;i<=big;i++){
                    list.add(i);
                }
                lists.add(list);
                big++;
                curSum+=big;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        FindContinuousSequence fcs = new FindContinuousSequence();
        ArrayList<ArrayList<Integer>> lists = fcs.FindContinuousSequence(15);
        System.out.println(lists);
    }
}
