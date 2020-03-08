package practice;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array==null||sum<=0){
            return list;
        }
        int i = 0;
        int j = array.length-1;
        while (i<j){
            int curSum = array[i]+array[j];
            if (curSum<sum){
                i++;
            }else if (curSum>sum){
                j--;
            }else if (curSum==sum){
                if (list.isEmpty()){
                    list.add(array[i]);
                    list.add(array[j]);
                }else {
                    int t1 = list.get(0);
                    int t2 = list.get(1);
                    if (t1*t2 > array[i]*array[j]){
                        list.add(0,array[i]);
                        list.add(1,array[j]);
                    }
                    i++;
                }

            }
        }
        return list;
    }

    public static void main(String[] args) {
        FindNumbersWithSum fnws = new FindNumbersWithSum();
        int[] arr = {1,2,4,7,11,15};
        ArrayList<Integer> list = fnws.FindNumbersWithSum(arr,15);
        System.out.println(list);
    }
}
