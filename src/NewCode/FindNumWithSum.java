package NewCode;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumWithSum {
    public static ArrayList<Integer> findNumWithSum(int[] arr, int s){
        ArrayList<Integer> res = new ArrayList<>();

        int p1=0;
        int p2 = arr.length-1;
        int small = Integer.MAX_VALUE;

        int[] resArr = new int[2];
        while (p1<p2){
            if (arr[p1]+arr[p2]>s){
                p2--;
            }else if (arr[p1]+arr[p2]<s){
                p1++;
            }else {
                if (small>(arr[p1]*arr[p2])){
                    small = arr[p1]*arr[p2];
                    resArr[0]=arr[p1];
                    resArr[1] = arr[p2];
                }
                p1++;
            }
        }

        if (resArr[0]!=0&&resArr[1]!=0) {
            res.add(resArr[0]);
            res.add(resArr[1]);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(findNumWithSum(arr,0));
    }
}
