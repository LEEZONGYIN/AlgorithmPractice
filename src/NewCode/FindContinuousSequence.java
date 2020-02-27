package NewCode;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum<0){
            return null;
        }
        int small = 1;
        int big = 2;
        int mid = (1+sum)/2;
        int curSum = getSum(small,big);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while (small<mid){
            if (getSum(small,big)<sum){
                big++;
                curSum+=big;
            }else if (getSum(small,big)>sum&&small<mid){
                curSum -= small;
                small++;
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=small;i<=big;i++){
                    list.add(i);
                }
                res.add(list);
                curSum -= small;
                small++;
                curSum+=small;
            }
        }
        return res;
    }
    public static int getSum(int small,int big){
        int sum = 0;
        for (int i=small;i<=big;i++){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        lists = findContinuousSequence.FindContinuousSequence(15);
        for (ArrayList list:lists){
            System.out.println(list);
        }

//        System.out.println(getSum(4,6));
    }
}
